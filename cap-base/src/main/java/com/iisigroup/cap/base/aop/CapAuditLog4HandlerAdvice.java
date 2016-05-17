/* 
 * AuditLog4HandlerAdvice.java
 * 
 * Copyright (c) 2009-2014 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.aop;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.iisigroup.cap.base.CapSystemProperties;
import com.iisigroup.cap.base.constants.CapConstants;
import com.iisigroup.cap.base.model.AuditLog;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapWebUtil;
import com.iisigroup.cap.utils.UUIDGenerator;
import com.isigroup.cap.base.annotation.CapAuditLogAction;

/**
 * <pre>
 * 寫 AuditLog 使用軌跡紀錄。
 * </pre>
 * 
 * @since 2014/1/13
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2014/1/13,Sunkist Wang,new
 *          <li>2014/1/20,Sunkist Wang,update 以def.properties取中文寫入
 *          <li>2014/4/18,Sunkist Wang,update get commonSrv,sysProp
 *          </ul>
 */
public class CapAuditLog4HandlerAdvice {

    private static String HOST_NAME = CapWebUtil.getHostName();
    private static String HOST_ID = HOST_NAME.trim().substring(HOST_NAME.length() - 1);
    private static final String DEF_PROP = "def";
    private static final String MENU_PREFIX = "menu.";
    private static final String ACTION_PREFIX = "btn.";
    private static final String DISABLE_TYPE = "DisableType";

    private static final Logger LOGGER = LoggerFactory.getLogger(CapAuditLog4HandlerAdvice.class);

    protected static Set<String> capFilter;

    static {
        capFilter = new HashSet<String>();
        capFilter.add("js." + MENU_PREFIX);
        capFilter.add(ACTION_PREFIX);
    }

    @Resource
    private CommonService commonSrv;

    @Resource
    private CapSystemProperties sysProp;

    /**
     * 子系統代碼(COLA...)
     */
    String sysId = null;

    /**
     * Log Around AjaxHandler execute.
     * 
     * @param pjp
     *            the join point
     * @param data
     *            the data
     * @param parent
     *            the parent
     * @throws Throwable
     * @return Object
     */
    public Object logAroundAjaxHandlerExecute(ProceedingJoinPoint pjp, Request params) throws Throwable {
        long start = System.currentTimeMillis();
        params.put(CapConstants.C_AUDITLOG_START_TS, String.valueOf(System.currentTimeMillis()));
        final String TITLE = StrUtils.concat("#[AL_AROUND][", System.nanoTime(), "]");

        String targetName = pjp.getTarget().getClass().getName();

        Method method = CapBeanUtil.findMethod(pjp.getTarget().getClass(), params.get(CapConstants.P_FORM_ACTION), (Class<?>) null);
        String logAuditInfo = "none";
        if (method != null) {
            String action = null, function = null;
            CapAuditLogAction auditLogAction = method.getAnnotation(CapAuditLogAction.class);

            action = (auditLogAction != null && auditLogAction.actionType() != null) ? auditLogAction.actionType().toString() : null;
            function = (auditLogAction != null && auditLogAction.functionCode() != null) ? auditLogAction.functionCode().getCode() : null;
            if (action != null && function != null) {
                logAuditInfo = StrUtils.concat(auditLogAction.actionType().name(), CapConstants.SPACE, auditLogAction.functionCode().name(), CapConstants.SPACE,
                        auditLogAction.functionCode().getUrlPath());
            }
        }
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("{} ENTRY: {} Start Time: {} Audit Information: {}", new Object[] { TITLE, targetName, new Date(start), logAuditInfo });
        }

        Object obj = pjp.proceed();

        LOGGER.info("{} TOTAL_COST= {} ms", TITLE, (System.currentTimeMillis() - start));

        return obj;
    }

    /**
     * Log after AjaxHandler execute.
     * 
     * @param joinPoint
     *            the join point
     * @param data
     *            the data
     * @param reVal
     *            the return Json
     * @param parent
     *            the parent
     */
    public void logAfterAjaxHandlerExecute(JoinPoint joinPoint, Request params, Object reVal) {
        long t1 = System.currentTimeMillis();
        final String sno = String.valueOf(System.nanoTime());
        final String TITLE = StrUtils.concat("##[AL_AFTER][", sno, "]");
        String targetName = joinPoint.getTarget().getClass().getName();
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("{} ENTRY: targetName:{} JoinPoint:{}\n IRequest:{}\n Object:{} ", new Object[] { TITLE, targetName, joinPoint, params, reVal });
        }

        try {

            Class clazz = joinPoint.getTarget().getClass();
            AuditLog auditLog = loggedFunction(TITLE, targetName, clazz, params);
            if (auditLog != null) {
                // 暫時不知道要放什麼值
                auditLog.setRemark(CapConstants.EMPTY_STRING);
                commonSrv.save(auditLog);
            }

        } catch (Exception ex) {
            LOGGER.error(StrUtils.concat(TITLE, "DO_LOG_EXCEPTION_OCCURED!!"), ex);
        } finally {
            LOGGER.info("{} TOTAL_COST= {} ms", TITLE, (System.currentTimeMillis() - t1));
        }
    }

    /**
     * Log After AjaxHandler Throwing Exception.
     * 
     * @param joinPoint
     *            the join point
     * @param data
     *            the data
     * @param parent
     *            the parent
     * @param exception
     *            the exception
     */
    public void logAfterAjaxHandlerThrowingException(JoinPoint joinPoint, Request params, Exception exception) {
        long t1 = System.currentTimeMillis();
        final String TITLE = StrUtils.concat("###[AL_AFTER_EXCEPTION][", System.nanoTime(), "]");

        String targetName = joinPoint.getTarget().getClass().getName();

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("{} ENTRY: targetName:{} JoinPoint:{}\n IRequest:{}\n Exception:{} ", new Object[] { TITLE, targetName, joinPoint, params, exception });
        }

        try {

            Class clazz = joinPoint.getTarget().getClass();
            AuditLog auditLog = loggedFunction(TITLE, targetName, clazz, params);
            if (auditLog != null) {
                auditLog.setRemark(trimByLen(CapString.trimNull(new StringBuffer().append("Exception: ").append(exception.getMessage()).toString()), 50));
                commonSrv.save(auditLog);
            }

        } catch (Exception ex) {
            LOGGER.error(StrUtils.concat(TITLE, "DO_LOG_EXCEPTION_OCCURED!!"), ex);
        } finally {
            LOGGER.info("{} TOTAL_COST= {} ms", TITLE, (System.currentTimeMillis() - t1));
        }
    }

    private AuditLog loggedFunction(String TITLE, String targetName, Class clazz, Request params) {

        // 判斷是否不需要記錄(放 SysParm)
        String sysparmDisableData = sysProp.get(targetName + "." + DISABLE_TYPE);
        String dtype = CapString.trimNull(sysparmDisableData, DisableType.CANCEL.getCode());
        sysProp.put(targetName + "." + DISABLE_TYPE, dtype);
        if (DisableType.ALL.isEquals(dtype)) {
            LOGGER.trace("{} {} DISABLE_AUDITLOG ALL!!", TITLE, targetName);
            return null;
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Method method = CapBeanUtil.findMethod(clazz, params.get(CapConstants.P_FORM_ACTION), (Class<?>) null);
        String action = null, function = null;
        boolean haveToAudit = false;
        if (method != null) {
            CapAuditLogAction auditLogAction = method.getAnnotation(CapAuditLogAction.class);

            action = (auditLogAction != null && auditLogAction.actionType() != null) ? auditLogAction.actionType().toString() : null;
            function = (auditLogAction != null && auditLogAction.functionCode() != null) ? auditLogAction.functionCode().getCode() : null;
            if (action != null && function != null) {
                haveToAudit = true;
            }
        }

        String uid = null, ipAddress = null;

        CapUserDetails user = CapSecurityContext.getUser();
        if (user != null) {
            uid = user.getUserId();
            // ipAddress = user.getIpAddress();
        } else {
            uid = auth.getPrincipal().toString();
        }

        if (CapString.isEmpty(ipAddress) && auth != null && auth.getDetails() instanceof WebAuthenticationDetails) {
            WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
            ipAddress = details.getRemoteAddress();
        }
        if (CapString.isEmpty(ipAddress)) {
            ServletRequest req = params.getServletRequest();
            ipAddress = req.getRemoteAddr();
        }

        AuditLog auditLog = null;
        if (haveToAudit) {
            auditLog = new AuditLog();
            auditLog.setId(UUIDGenerator.getUUID());
            auditLog.setUserId(uid);
            auditLog.setIpAddress(trimByLen(CapString.trimNull(ipAddress), 50));
            auditLog.setFunctionId(trimByLen(function, 20));
            auditLog.setAction(trimByLen(action.toLowerCase(), 20));
            // auditLog.setRemark(trimByLen(CapString.trimNull(params.toString()),
            // 50));

            long tstart = NumberUtils.toLong(CapString.trimNull(params.get(CapConstants.C_AUDITLOG_START_TS)));
            if (tstart > 0) {
                auditLog.setExecuteDate(new Timestamp(tstart));
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace("{} AuditLog={}", TITLE, auditLog);
                }
            }
        }
        return auditLog;
    }

    /**
     * @return the sysId
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * @param sysId
     *            the sysId to set
     */
    public void setSysId(String sysId) {
        this.sysId = CapString.trimNull(sysId).toUpperCase();
    }

    private String getSno(String userId, String rno) {
        return StrUtils.concat(System.nanoTime(), "-", userId, "-", HOST_ID, "-", rno + RandomStringUtils.randomNumeric(2));
    }

    private String trimByLen(String src, int maxLen) {
        if (src != null) {
            byte[] bsrc = src.getBytes();
            if (bsrc.length > maxLen) {
                src = new String(bsrc, 0, maxLen);
            }
        }
        return src;
    }

    public enum DisableType {
        ALL("A"),
        DATA("D"),
        CANCEL("C");

        private String rcode;

        DisableType(String code) {
            this.rcode = code;
        }

        public String getCode() {
            return rcode;
        }

        public boolean isEquals(Object other) {
            if (other instanceof String) {
                return rcode.equals(other);
            } else {
                return super.equals(other);
            }
        }
    }
}

class StrUtils {
    public final static String concat(Object... params) {
        StringBuffer strBuf = new StringBuffer();
        for (Object o : params) {
            if (o instanceof byte[]) {
                strBuf.append(new String((byte[]) o));
            } else {
                strBuf.append(String.valueOf(o));
            }
        }
        return strBuf.toString();
    }
}
