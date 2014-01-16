/**
 * CapClosePageException.java
 *
 * Copyright (c) 2009 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.exception;

import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 錯誤產生時，通知前端關閉畫面
 * </pre>
 * @since  2011/1/4
 * @author RodesChen
 * @version <ul>
 *           <li>2011/1/4,RodesChen,new
 *           <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings( { "serial" })
public class CapClosePageException extends CapException {

	String i18nKey;

	/**
	 * Instantiates a new cap exception.
	 */
	public CapClosePageException() {
		super();
	}

	/**
	 * Instantiates a new cap exception.
	 * 
	 * @param causeClass
	 *            the cause class
	 */
	@SuppressWarnings("rawtypes")
	public CapClosePageException(Class causeClass) {
		super();
		super.setCauseSource(causeClass);
	}

	/**
	 * Instantiates a new cap exception.
	 * 
	 * @param message
	 *            the message
	 * @param causeClass
	 *            the cause class
	 */
	@SuppressWarnings("rawtypes")
	public CapClosePageException(String message, Class causeClass) {
		super(message, causeClass);
	}

	/**
	 * Instantiates a new cap exception.
	 * 
	 * @param cause
	 *            the throwable
	 * @param causeClass
	 *            the cause class
	 */
	@SuppressWarnings("rawtypes")
	public CapClosePageException(Throwable cause, Class causeClass) {
		super(cause, causeClass);
	}

	/**
	 * Instantiates a new cap exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param causeClass
	 *            the cause class
	 */
	@SuppressWarnings("rawtypes")
	public CapClosePageException(String message, Throwable cause, Class causeClass) {
		super(message, cause, causeClass);
	}

	@Override
	public String getMessage() {
		return CapString.isEmpty(i18nKey) ? super.getMessage() : i18nKey;
	}

	/**
	 * set i18n key
	 * 
	 * @param i18nKey
	 *            the i18n key
	 * @return CapMessageException
	 */
	public CapClosePageException setMessageKey(String i18nKey) {
		this.i18nKey = i18nKey;
		return this;
	}

	/**
	 * get i18n key
	 * 
	 * @return String
	 */
	public String getMessageKey() {
		return i18nKey;
	}

}
