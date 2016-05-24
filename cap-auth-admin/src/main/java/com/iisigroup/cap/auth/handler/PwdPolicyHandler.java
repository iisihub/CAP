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
package com.iisigroup.cap.auth.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.auth.service.PwdPolicyService;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.db.service.CommonService;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.security.constatns.SecConstants.PwdPolicyKeys;

/**
 * <pre>
 * system pwdpolicy handler
 * </pre>
 * 
 * @since 2014/02/11
 * @author yunglinliu
 * @version
 *          <ul>
 *          <li>2014/02/11,yunglinliu,new
 *          </ul>
 */
@Controller("pwdpolicyhandler")
public class PwdPolicyHandler extends MFormHandler {

    @Resource
    private CommonService commonService;
    @Resource
    private PwdPolicyService pwdPolicyService;

    public Result query(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        for (PwdPolicyKeys value : PwdPolicyKeys.values()) {
            SysParm parm = commonService.findById(SysParm.class, value.toString().toLowerCase());
            if (parm != null) {
                result.set(parm.getParmId().substring(4), parm.getParmValue());
            }
        }
        return result;
    }

    public Result modify(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        pwdPolicyService.updatePwdPolicy(request);
        return result;
    }
}
