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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.handler.FormHandler;
import com.iisigroup.cap.handler.IHandler;
import com.iisigroup.cap.operation.OpStepContext;
import com.iisigroup.cap.security.annotation.Captcha;
import com.iisigroup.cap.security.captcha.CapSecurityCaptcha;
import com.iisigroup.cap.security.captcha.CapSecurityCaptcha.CaptchaStatus;
import com.iisigroup.cap.security.captcha.servlet.CapCaptchaServlet;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 動態驗証碼判斷
 * </pre>
 * 
 * @since 2014/2/12
 * @author RodesChen
 * @version <ul>
 *          <li>2014/2/12,RodesChen,new
 *          </ul>
 */
public class CapCaptchaOpStep extends AbstractCustomizeOpStep {

	protected static Log logger = LogFactory.getLog(CapCaptchaOpStep.class);

	@Override
	public OpStepContext execute(OpStepContext ctx, IRequest params,
			IHandler handler) {
		String methodId = params.get(FormHandler.FORM_ACTION, "");
		if (!CapString.isEmpty(methodId)) {
			for (Method method : handler.getClass().getDeclaredMethods()) {
				if (methodId.equals(method.getName())) {
					if (method.isAnnotationPresent(Captcha.class)) {
						String key = method.getAnnotation(Captcha.class)
								.value();
						CapSecurityCaptcha captcha = CapAppContext
								.getBean(CapCaptchaServlet.DEF_RENDERER);
						if (captcha == null
								|| !CaptchaStatus.SUCCESS.equals(captcha
										.valid(params.get(key)))) {
							// 驗証碼無效請重新輸入
							throw new CapMessageException(
									CapAppContext.getMessage(captcha.getErrorMessage()),
									getClass());
						}
					}
				}
			}
		}
		return ctx.setGoToStep(NEXT);
	}
}
