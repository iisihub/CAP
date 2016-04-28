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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.auth.service.PwdPolicyService;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.SecConstants.PwdPloicyKeys;
import com.iisigroup.cap.service.ICommonService;

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
@Scope("request")
@Controller("pwdpolicyhandler")
public class PwdPolicyHandler extends MFormHandler {

    @Resource
    private ICommonService commonService;
    @Resource
    private PwdPolicyService pwdPolicyService;

    public IResult query(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        for (PwdPloicyKeys value : PwdPloicyKeys.values()) {
            SysParm parm = commonService.findById(SysParm.class, value.toString().toLowerCase());
            if (parm != null) {
                result.set(parm.getParmId().substring(4), parm.getParmValue());
            }
        }
        return result;
    }

    public IResult modify(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        pwdPolicyService.updatePwdPolicy(request);
        return result;
    }
}
