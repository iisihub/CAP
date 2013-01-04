/*_
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;

/**
 * <pre>
 * Common Handler
 * </pre>
 * 
 * @since 2011/3/22
 * @author RodesChen
 * @version <ul>
 *          <li>2011/3/22,RodesChen,new
 *          </ul>
 */
@Scope("request")
@Controller("commonformhandler")
public class CapCommonFormHandler extends MFormHandler {

	/**
	 * <pre>
	 * 檔案作業完成後以防IE status bar 不停止
	 * </pre>
	 * 
	 * @param params
	 *            PageParameters
	 * @return IResult
	 * @throws CapException
	 */
	public IResult fileSuccess(IRequest params) {
		return new AjaxFormResult();
	}

	/**
	 * <pre>
	 * DEFAULT_OPERATION
	 * </pre>
	 * 
	 * @return String
	 */
	public String getOperationName() {
		return "simpleOperation";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tw.com.iisi.cap.plugin.CapHandlerPlugin#execute(tw.com.iisi.cap.component
	 * .ICapRequest)
	 */
	@Override
	public IResult execute(IRequest request) {
		return null;
	}

}
