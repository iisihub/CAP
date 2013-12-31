package com.iisigroup.cap.base.aop;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.iisigroup.cap.base.model.AuditConfig.DisableType;
import com.iisigroup.cap.base.model.AuditData;
import com.iisigroup.cap.base.model.AuditLog;
import com.iisigroup.cap.base.service.AuditConfigService;
import com.iisigroup.cap.base.service.AuditLogService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.utils.CapCommonUtil;
import com.iisigroup.cap.utils.CapWebUtil;
import com.iisigroup.cap.utils.StrUtils;

public class AuditLog4HandlerAdvice {
	private static final String P_FORM_ACTION = "formAction";

	private static final String C_AUDITLOG_START_TS = "_AuditLogTS";

	private static final String P_MAIN_ID = "mainId";

	private static final String P_OID = "oid";

	private static final String P_CUSTID = "custId";

	private static final String P_DUPNO = "dupNo";

	private static final String P_TX_CODE = "txCode";

	private static String HOST_NAME = CapCommonUtil.getHostName();
	private static String HOST_ID = HOST_NAME.trim().substring(
			HOST_NAME.length() - 1);

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuditLog4HandlerAdvice.class);

	@Autowired
	private AuditLogService auditLogService;

	@Autowired
	private AuditConfigService auditConfigService;

	/**
	 * 子系統代碼(LMS/CES/CMS/COL...)
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
	public Object logAroundAjaxHandlerExecute(ProceedingJoinPoint pjp,
			IRequest params) throws Throwable {
		long start = System.currentTimeMillis();
		params.put(C_AUDITLOG_START_TS,
				String.valueOf(System.currentTimeMillis()));
//		data.put(C_AUDITLOG_START_TS,
//				String.valueOf(System.currentTimeMillis()));
		final String TITLE = StrUtils.concat("#[AL_AROUND][",
				System.nanoTime(), "]");

		String targetName = pjp.getTarget().getClass().getName();

		LOGGER.trace("{} ENTRY: {} Start Time: {}", new Object[] { TITLE,
				targetName, new Date(start) });

		Object obj = pjp.proceed();

		LOGGER.info("{} TOTAL_COST= {} ms", TITLE,
				(System.currentTimeMillis() - start));

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
	public void logAfterAjaxHandlerExecute(JoinPoint joinPoint,
			IRequest params, Object reVal) {
		long t1 = System.currentTimeMillis();
		final String sno = String.valueOf(System.nanoTime());
		final String TITLE = StrUtils.concat("##[AL_AFTER][", sno, "]");
		String targetName = joinPoint.getTarget().getClass().getName();
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(
					"{} ENTRY: targetName:{} JoinPoint:{}\n IRequest:{}\n Object:{} ",
					new Object[] { TITLE, targetName, joinPoint, params,
							reVal });
		}

		try {
			// 判斷是否不需要記錄(在AuditLogConfig
			boolean disableData = false;
			String dtype = auditConfigService.getDisableType(targetName);
			if (DisableType.ALL.isEquals(dtype)) {
				LOGGER.trace("{} {} DISABLE_AUDITLOG ALL!!", TITLE, targetName);
				return;
			} else if (DisableType.DATA.isEquals(dtype)) {
				disableData = true;
			}

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();

			AuditLog auditLog = new AuditLog();
			auditLog.setSysId(this.sysId);
			auditLog.setServerName(HOST_NAME!=null?HOST_NAME.substring(0, 10):"");
			auditLog.setInvokeResult(AuditLog.RC_NORMAL);
			auditLog.setInvokeSource(CapWebUtil.getRequestURL((HttpServletRequest)params.getServletRequest()));
			auditLog.setInvokeTarget(targetName);

			auditLog.setInvokeAction(StringUtils.trimToEmpty(params.get(P_FORM_ACTION)));
			auditLog.setMainId(StringUtils.trimToEmpty(params.get(P_MAIN_ID)));
			auditLog.setDocOid(StringUtils.trimToEmpty(params.get(P_OID)));
			auditLog.setTxid(StringUtils.trimToEmpty(params.get(P_TX_CODE)));

			auditLog.setCustId(trimByLen(
					StringUtils.trimToEmpty(params.get(P_CUSTID)), 10));
			auditLog.setDupNo(trimByLen(
					StringUtils.trimToEmpty(params.get(P_DUPNO)), 1));

			String uid = null;
			if (auth.getPrincipal() instanceof CapUserDetails) {
				CapUserDetails details = (CapUserDetails) auth
						.getPrincipal();
				uid = details.getUserId();
				auditLog.setUserId(uid);
			} else {
				uid = auth.getPrincipal().toString();
				auditLog.setUserId(uid);
			}
			auditLog.setSno(this.getSno(uid, "0"));

			if (auth.getDetails() instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails details = (WebAuthenticationDetails) auth
						.getDetails();
				auditLog.setInvokerIp(details.getRemoteAddress());
			}

			if (!disableData) {
				AuditData reqData = new AuditData(AuditData.TYPE_REQUEST,
						params.toString(), auditLog);
				reqData.setSno(this.getSno(uid, "1"));

				AuditData respData = new AuditData(AuditData.TYPE_RESPONSE,
						String.valueOf(reVal), auditLog);
				respData.setSno(this.getSno(uid, "2"));

				auditLog.setAuditLogDataList(Arrays.asList(new AuditData[] {
						reqData, respData }));
			}

			long tstart = NumberUtils.toLong(StringUtils.trimToEmpty(params.get(C_AUDITLOG_START_TS)));
			if (tstart > 0) {
				auditLog.setStartTime(new Timestamp(tstart));
			}
			long tend = System.currentTimeMillis();
			auditLog.setEndTime(new Timestamp(tend));
			auditLog.setCost(tend - tstart);

			LOGGER.trace("{} AuditLog={}", TITLE, auditLog);
			auditLogService.log(auditLog);

		} catch (Exception ex) {
			LOGGER.error(StrUtils.concat(TITLE, "DO_LOG_EXCEPTION_OCCURED!!"),
					ex);
		} finally {
			LOGGER.info("{} TOTAL_COST= {} ms", TITLE,
					(System.currentTimeMillis() - t1));
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
	public void logAfterAjaxHandlerThrowingException(JoinPoint joinPoint,
			IRequest params, Exception exception) {
		long t1 = System.currentTimeMillis();
		final String TITLE = StrUtils.concat("###[AL_AFTER_EXCEPTION][",
				System.nanoTime(), "]");

		String targetName = joinPoint.getTarget().getClass().getName();

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(
					"{} ENTRY: targetName:{} JoinPoint:{}\n IRequest:{}\n Exception:{} ",
					new Object[] { TITLE, targetName, joinPoint, params,
							exception });
		}

		try {

			boolean disableData = false;
			String dtype = auditConfigService.getDisableType(targetName);
			if (DisableType.ALL.equals(dtype)) {
				LOGGER.trace("{} {} DISABLE_AUDITLOG ALL!!", TITLE, targetName);
				return;
			} else if (DisableType.DATA.equals(dtype)) {
				disableData = true;
			}

			AuditLog auditLog = new AuditLog();
			auditLog.setSysId(this.sysId);
			auditLog.setServerName(HOST_NAME!=null?HOST_NAME.substring(0, 10):"");
			auditLog.setInvokeResult(AuditLog.RC_EXCEPTION);
			auditLog.setInvokeSource(CapWebUtil.getRequestURL((HttpServletRequest)params.getServletRequest()));
			auditLog.setInvokeTarget(targetName);
			auditLog.setMainId(StringUtils.trimToEmpty(params.get(P_MAIN_ID)));
			auditLog.setTxid(StringUtils.trimToEmpty(params.get(P_TX_CODE)));
			auditLog.setInvokeAction(StringUtils.trimToEmpty(params.get(P_FORM_ACTION)));
			auditLog.setDocOid(StringUtils.trimToEmpty(params.get(P_OID)));

			auditLog.setCustId(trimByLen(
					StringUtils.trimToEmpty(params.get(P_CUSTID)), 10));
			auditLog.setDupNo(trimByLen(
					StringUtils.trimToEmpty(params.get(P_DUPNO)), 1));

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();

			String uid = null;
			if (auth.getPrincipal() instanceof CapUserDetails) {
				CapUserDetails details = (CapUserDetails) auth
						.getPrincipal();
				uid = details.getUserId();
				auditLog.setUserId(uid);
			} else {
				uid = auth.getPrincipal().toString();
				auditLog.setUserId(uid);
			}
			auditLog.setSno(this.getSno(uid, "0"));

			if (auth.getDetails() instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails details = (WebAuthenticationDetails) auth
						.getDetails();
				auditLog.setInvokerIp(details.getRemoteAddress());
			}

			auditLog.setInvokeMemo(exception.getMessage());

			if (!disableData) {
				AuditData reqData = new AuditData(AuditData.TYPE_REQUEST,
						params.toString(), auditLog);
				reqData.setSno(this.getSno(uid, "3"));

				AuditData respData = new AuditData(AuditData.TYPE_RESPONSE,
						String.valueOf(StrUtils.getStackTrace(exception)),
						auditLog);
				respData.setSno(this.getSno(uid, "4"));

				auditLog.setAuditLogDataList(Arrays.asList(new AuditData[] {
						reqData, respData }));
			}

			long tstart = NumberUtils.toLong(StringUtils.trimToEmpty(params.get(C_AUDITLOG_START_TS)));
			if (tstart > 0) {
				auditLog.setStartTime(new Timestamp(tstart));
			}
			long tend = System.currentTimeMillis();
			auditLog.setEndTime(new Timestamp(tend));
			auditLog.setCost(tend - tstart);

			auditLogService.log(auditLog);

		} catch (Exception ex) {
			LOGGER.error(StrUtils.concat(TITLE, "DO_LOG_EXCEPTION_OCCURED!!"),
					ex);
		} finally {
			LOGGER.info("{} TOTAL_COST= {} ms", TITLE,
					(System.currentTimeMillis() - t1));
		}
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
		this.sysId = StringUtils.trimToEmpty(sysId).toUpperCase();
	}

	private String getSno(String userId, String rno) {
		return StrUtils.concat(System.nanoTime(), "-", userId, "-", HOST_ID,
				"-", rno + RandomStringUtils.randomNumeric(2));
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
}
