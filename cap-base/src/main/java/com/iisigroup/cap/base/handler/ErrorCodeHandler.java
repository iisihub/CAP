/* 
 * ErrorCodeHandler.java
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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.ErrorCode;
import com.iisigroup.cap.base.service.ErrorCodeService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 訊息代碼維護
 * </pre>
 * 
 * @since 2013/12/31
 * @author tammy
 * @version
 *          <ul>
 *          <li>2013/12/31,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("errorCodehandler")
public class ErrorCodeHandler extends MFormHandler {

    @Resource
    private ICommonService commonSrv;

    @Resource
    private ErrorCodeService errorCodeService;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult query(ISearch search, IRequest params) {
        String code = params.get("code");
        String locale = params.get("locale");
        String sysId = params.get("sysId");

        if (!CapString.isEmpty(code)) {
            search.addSearchModeParameters(SearchMode.LIKE, "code", code);
        }
        if (!CapString.isEmpty(locale)) {
            search.addSearchModeParameters(SearchMode.EQUALS, "locale", locale);
        }
        if (!CapString.isEmpty(sysId)) {
            search.addSearchModeParameters(SearchMode.LIKE, "sysId", sysId);
        }
        search.addOrderBy("code");

        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        // fmt.put("lastModifyBy", new UserNameFormatter(this.userService));

        Page<ErrorCode> page = commonSrv.findPage(ErrorCode.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    /**
     * 編輯資料
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult save(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String oid = request.get("oid");
        String code = request.get("code").toUpperCase();
        String locale = request.get("locale");
        ErrorCode errorCode = null;

        if (CapString.isEmpty(oid)) {
            errorCode = errorCodeService.getErrorCode(code, locale);
            if (errorCode != null) {
                result.set("exist", Boolean.TRUE);
                return result;
            }
        } else {
            errorCode = commonSrv.findById(ErrorCode.class, oid);
        }

        if (errorCode == null) {
            errorCode = new ErrorCode();
            errorCode.setOid(null);
        }
        CapBeanUtil.map2Bean(request, errorCode, ErrorCode.class);
        errorCode.setCode(errorCode.getCode().toUpperCase());
        errorCode.setLastModifyBy(CapSecurityContext.getUserId());
        errorCode.setLastModifyTime(CapDate.getCurrentTimestamp());
        errorCodeService.save(errorCode);

        return result;
    }

    /**
     * 刪除資料
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult delete(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        ErrorCode code = commonSrv.findById(ErrorCode.class, request.get("oid"));
        if (code != null) {
            commonSrv.delete(code);
        }
        return result;
    }

}
