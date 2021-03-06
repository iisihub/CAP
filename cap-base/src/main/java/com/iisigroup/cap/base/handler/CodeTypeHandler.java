/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.handler;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.constants.CapFunctionCode;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.component.impl.BeanGridResult;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.db.service.CommonService;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.formatter.impl.ADDateFormatter;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;
import com.isigroup.cap.base.annotation.CapAuditLogAction;
import com.isigroup.cap.base.annotation.CapAuditLogAction.CapActionTypeEnum;

/**
 * <pre>
 * base Handler
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/28,rodeschen,new
 *          <li>2011/12/23，gabriella,add method
 *          <li>2012/3/1,rodeschen,增加判斷重覆及更改程式名稱
 *          </ul>
 */
@Controller("codetypehandler")
public class CodeTypeHandler extends MFormHandler {

    @Resource
    private CodeTypeService codeTypeService;

    @Resource
    private CommonService commonService;

    @CapAuditLogAction(functionCode = CapFunctionCode.F101, actionType = CapActionTypeEnum.Query)
    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult query(SearchSetting search, Request params) {
        if (!CapString.isEmpty(params.get("locale"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "locale", params.get("locale"));
        }
        if (!CapString.isEmpty(params.get("codeType"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "codeType", params.get("codeType"));
        }
        if (!search.hasOrderBy()) {
            search.addOrderBy("codeType");
            search.addOrderBy("codeOrder");
        } else {
            Map<String, Boolean> m = search.getOrderBy();
            if (!m.containsKey("codeType")) {
                search.addOrderBy("codeType");
            }
            if (!m.containsKey("codeOrder")) {
                search.addOrderBy("codeOrder");
            }
        }
        Page<CodeType> page = commonService.findPage(CodeType.class, search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("updateTime", new ADDateFormatter());
        return new BeanGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * modify codetype
     * 
     * @param request
     *            request
     * @return IResult
     */
    @CapAuditLogAction(functionCode = CapFunctionCode.F101, actionType = CapActionTypeEnum.Update)
    public Result modify(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String type = request.get("type");
        String locale = CapSecurityContext.getLocale().toString();
        CodeType code = codeTypeService.getByCodeTypeAndValue(request.get("codeType"), request.get("codeValue"), locale);

        if ("A".equals(type)) {
            if (code != null) {
                // codetype.0001 代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("codetype.0001"), getClass());
            }
            code = new CodeType();
        } else {
            if (code != null && !code.getOid().equals(request.get("oid"))) {
                // codetype.0001 代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("codetype.0001"), getClass());
            } else if (code == null) {
                code = codeTypeService.getById(request.get("oid"));
            }
        }
        CapBeanUtil.map2Bean(request, code, CodeType.class);
        if ("A".equals(type)) {
            code.setOid(null);
        }
        code.setUpdater(CapSecurityContext.getUserId());
        code.setUpdateTime(CapDate.getCurrentTimestamp());
        codeTypeService.saveCodeType(code);
        return result;
    }

    /**
     * delete codetype
     * 
     * @param request
     *            request
     * @return IResult
     */
    @CapAuditLogAction(functionCode = CapFunctionCode.F101, actionType = CapActionTypeEnum.Delete)
    public Result delete(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        codeTypeService.deleteById(request.get("oid"));
        return result;
    }

    /**
     * get combo list By Keys
     * 
     * @param request
     *            request
     * @return IResult
     */
    @CapAuditLogAction(functionCode = CapFunctionCode.F101, actionType = CapActionTypeEnum.Query)
    @SuppressWarnings("rawtypes")
    public Result queryByKeys(Request request) {
        String locale = CapSecurityContext.getLocale().toString();
        String[] keys = request.getParamsAsStringArray("keys");
        String[] aKeys = request.getParamsAsStringArray("akeys");
        AjaxFormResult mresult = new AjaxFormResult();
        if (keys.length > 0 && !CapString.isEmpty(keys[0])) {
            Set<String> k = new HashSet<String>(Arrays.asList(keys));// 排除重覆的key
            Map<String, AjaxFormResult> m = codeTypeService.getCodeTypeByTypes(k.toArray(new String[k.size()]), locale);
            mresult.setResultMap(m);
        }
        if (aKeys.length > 0 && !CapString.isEmpty(aKeys[0])) {
            Class[] paramTypes = { Request.class };
            Result rtn = null;
            for (String key : aKeys) {
                if (mresult.containsKey(key)) {
                    continue;
                }
                Method method = ReflectionUtils.findMethod(this.getClass(), key, paramTypes);
                if (method != null) {
                    try {
                        rtn = (Result) method.invoke(this, request);
                    } catch (Exception e) {
                        logger.error("load ComboBox error : key = " + key, e);
                    }
                    mresult.set(key, (AjaxFormResult) rtn);
                }
            }
        }
        return mresult;
    }

}// ~
