/*
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.response;

import net.sf.json.JSONObject;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapClosePageException;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.exception.CapSessioniExpireException;
import com.iisigroup.cap.utils.AppContext;
import com.iisigroup.cap.utils.StringUtil;


/**
 * <pre>
 * 錯誤訊息回應
 * </pre>
 * 
 * @since 2010/11/24
 * @author iristu
 * @version <ul>
 *          <li>iristu,2010/11/24,new
 *          <li>RodesChen,2011/6/2,增加關閉畫面錯誤
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings("serial")
public class ErrorResult implements IErrorResult {

	public static final String AJAX_HANDLER_EXCEPTION = "AJAX_HANDLER_EXCEPTION";
	public static final String AJAX_MESSAGE_HANDLER_EXCEPTION = "AJAX_MESSAGE_HANDLER_EXCEPTION";
	public static final String AJAX_SESSION_EXPIRE_EXCEPTION = "AJAX_SESSION_EXPIRE_EXCEPTION";
	/** 關閉畫面錯誤類別 */
	public static final String AJAX_CLOSE_PAGE_HANDLER_EXCEPTION = "AJAX_CLOSE_PAGE_HANDLER_EXCEPTION";

	JSONObject errorMessage = new JSONObject();

	String logMessage = "";

	public ErrorResult() {
	}

	public ErrorResult(IRequest request, Exception e) {
		this.putError(request, e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.response.IResult#getResult()
	 */
	@Override
	public String getResult() {
		return errorMessage.toString();
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void putError(IRequest request, Exception e) {
		if (e instanceof CapMessageException) {
			CapMessageException ce = (CapMessageException) e;
			logMessage = ce.getMessage();
			if (!StringUtil.isEmpty(ce.getMessageKey())) {
				logMessage = AppContext.getMessage(ce.getMessageKey());
			}
			errorMessage.put(AJAX_MESSAGE_HANDLER_EXCEPTION, logMessage);
		} else if (e instanceof CapClosePageException) {
			CapClosePageException ce = (CapClosePageException) e;
			logMessage = ce.getMessage();
			if (!StringUtil.isEmpty(ce.getMessageKey())) {
				logMessage = AppContext.getMessage(ce.getMessageKey());
			}
			errorMessage.put(AJAX_CLOSE_PAGE_HANDLER_EXCEPTION, logMessage);
		} else if (e instanceof CapSessioniExpireException) {
			CapSessioniExpireException ce = (CapSessioniExpireException) e;
			logMessage = ce.getMessage();
			if (!StringUtil.isEmpty(ce.getMessageKey())) {
				logMessage = AppContext.getMessage(ce.getMessageKey());
			}
			errorMessage.put(AJAX_SESSION_EXPIRE_EXCEPTION, logMessage);
		} else if (e instanceof CapException) {
			CapException ce = (CapException) e;
			logMessage = new StringBuffer(ce.getCauseClass().getName()).append(":").append(e.getMessage()).toString();
			errorMessage.put(AJAX_HANDLER_EXCEPTION, logMessage);
		} else {
			logMessage = e.getLocalizedMessage();
			errorMessage.put(AJAX_HANDLER_EXCEPTION, logMessage);
		}
	}// ;

	@Override
	public void add(IResult result) {
		JSONObject json = JSONObject.fromObject(result);
		this.errorMessage.putAll(json);
		this.logMessage = result.getLogMessage();
	}

}
