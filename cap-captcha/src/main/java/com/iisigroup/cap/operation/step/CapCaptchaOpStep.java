/* 
 * CapCaptchaOpStep.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.operation.step;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.handler.Handler;
import com.iisigroup.cap.model.OpStepContext;
import com.iisigroup.cap.security.annotation.Captcha;
import com.iisigroup.cap.security.captcha.web.CapCaptchaServlet;
import com.iisigroup.cap.security.constants.CheckStatus;
import com.iisigroup.cap.security.service.CheckCodeService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 動態驗証碼判斷
 * </pre>
 * 
 * @since 2014/2/12
 * @author RodesChen
 * @version
 *          <ul>
 *          <li>2014/2/12,RodesChen,new
 *          </ul>
 */
public class CapCaptchaOpStep extends AbstractCustomizeOpStep {

    protected final Logger logger = LoggerFactory.getLogger(CapCaptchaOpStep.class);

    @Override
    public OpStepContext execute(OpStepContext ctx, Request params, Handler handler) {
        String methodId = params.get(Handler.FORM_ACTION, "");
        if (!CapString.isEmpty(methodId)) {
            for (Method method : handler.getClass().getDeclaredMethods()) {
                if (methodId.equals(method.getName())) {
                    if (method.isAnnotationPresent(Captcha.class)) {
                        String key = method.getAnnotation(Captcha.class).value();
                        CheckCodeService captcha = CapAppContext.getBean(CapCaptchaServlet.defaultRender);
                        if (captcha == null || !CheckStatus.SUCCESS.equals(captcha.valid(params.get(key)))) {
                            // 驗証碼無效請重新輸入
                            throw new CapMessageException(CapAppContext.getMessage(captcha.getErrorMessage()), getClass());
                        }
                    }
                }
            }
        }
        return ctx.setGoToStep(NEXT);
    }
}
