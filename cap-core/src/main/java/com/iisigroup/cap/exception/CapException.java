/**
 * CapException.java
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

/**
 * <p>
 * class CapException extends Exception
 * </p>
 * 
 * <pre>
 * $Date: 2010-09-03 17:38:42 +0800 (星期五, 03 九月 2010) $
 * $Author: iris $
 * $Revision: 307 $
 * $HeadURL: svn://192.168.0.1/MICB_ISDOC/cap/cap-core/src/main/java/tw/com/iisi/cap/exception/CapException.java $
 * </pre>
 * 
 * @author iristu
 * @version $Revision: 307 $
 * @version <ul>
 *          <li>2010/7/12,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings({ "serial" })
public class CapException extends RuntimeException {

	@SuppressWarnings("rawtypes")
	Class causeClass;
	private Object extraInformation;

	/**
	 * Instantiates a new cap exception.
	 */
	public CapException() {
		super();
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
	public CapException(String message, Class causeClass) {
		super(message);
		this.causeClass = causeClass;
	}

	/**
	 * Instantiates a new cap exception.
	 * 
	 * @param cause
	 *            the cause
	 * @param causeClass
	 *            the cause class
	 */
	@SuppressWarnings("rawtypes")
	public CapException(Throwable cause, Class causeClass) {
		super(cause);
		this.causeClass = causeClass;
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
	public CapException(String message, Throwable cause, Class causeClass) {
		super(message, cause);
		this.causeClass = causeClass;
	}

	/**
	 * get cause class
	 * 
	 * @return Class
	 */
	@SuppressWarnings("rawtypes")
	public Class getCauseClass() {
		return causeClass;
	}

	/**
	 * set cause class
	 * 
	 * @param causeClass
	 *            the cause class
	 */
	@SuppressWarnings("rawtypes")
	public void setCauseSource(Class causeClass) {
		this.causeClass = causeClass;
	}

	public Object getExtraInformation() {
		return extraInformation;
	}

	public CapException setExtraInformation(Object extraInformation) {
		this.extraInformation = extraInformation;
		return this;
	}

}
