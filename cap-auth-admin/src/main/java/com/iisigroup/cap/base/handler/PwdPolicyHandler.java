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

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;

/**
 * <pre>
 * system pwdpolicy handler
 * </pre>
 * 
 * @since 2014/02/11
 * @author yunglinliu
 * @version <ul>
 *          <li>2014/02/11,yunglinliu,new
 *          </ul>
 */
@Scope("request")
@Controller("pwdpolicyhandler")
public class PwdPolicyHandler extends MFormHandler {

    @Resource
    private ICommonService commonService;

    private enum PwdKeys {
        PWD_EXPIRED_DAY, PWD_MIN_LENGTH, PWD_RULE, PWD_MAX_HISTORY, PWD_CAPTCHA_ENABLE, PWD_ACCOUNT_LOCK, PWD_FORCE_CHANGE_PWD
    }

    public IResult query(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        for (PwdKeys value : PwdKeys.values()) {
            SysParm parm = commonService.findById(SysParm.class, value
                    .toString().toLowerCase());
            if (parm != null) {
                result.set(parm.getParmId().substring(4), parm.getParmValue());
            }
        }
        return result;
    }

    public IResult modify(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        for (PwdKeys value : PwdKeys.values()) {
            String key = value.toString().toLowerCase();
            String data = request.get(key.substring(4));
            SysParm parm = commonService.findById(SysParm.class, key);
            if (parm == null) {
                parm = new SysParm();
            }
            parm.setParmId(key);
            parm.setParmValue(data);
            parm.setParmDesc(CapAppContext.getMessage("pwdpolicy."
                    + key.substring(4)));
            parm.setUpdater("XXXX");
            parm.setUpdateTime(CapDate.getCurrentTimestamp());
            commonService.save(parm);
        }
        return result;
    }
}
