/*
 * CapConstants.java
 *
 * Copyright (c) 2009 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap;

import java.math.BigDecimal;

/**
 * <p>
 * This interface provide common use constants..
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/6/30,iristu,modify
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface Constants {

	/**
	 * Line break.
	 */
	public final static String LINE_BREAK = System
			.getProperty("line.separator");

	/**
	 * empty string.
	 */
	public final static String EMPTY_STRING = "";

	/**
	 * a space string.
	 */
	public final static String SPACE = " ";

	/**
	 * a "0" string.
	 */
	public final static String S0 = "0";

	/**
	 * a "1" string.
	 */
	public final static String S1 = "1";

	/**
	 * a "-1" string.
	 */
	public final static String S1N = "-1";
	/**
	 * a "Y" string
	 */
	public static final String FLAG_Y = "Y";
	/**
	 * a "N" string
	 */
	public static final String FLAG_N = "N";
	/**
	 * a "-" string
	 */
	public final static String NEGATIVE = "-";
	/**
	 * a BigDecimal, value is 0.
	 */
	public final static BigDecimal B0 = new BigDecimal(0d);

	/**
	 * a BigDecimal, value is 1.
	 */
	public final static BigDecimal B1 = new BigDecimal(1d);

	/**
	 * a BigDecimal, value is -1.
	 */
	public final static BigDecimal B1N = new BigDecimal(-1d);

	/**
	 * a empty string array.
	 */
	public final static String[] EMPTY_ARRAY = new String[0];

	public final static String VALUES_SEPARATOR = "|";

	public final static String COMMA = ",";

	public final static String DATE_STAMP = "'";

	/**
	 * http
	 */
	public final static String HOST_URL = "HOST_URL";// HTTP.TARGET_HOST;

	public final static String CONNECTION_TIMEOUT = "TIMEOUT";// HttpConnectionParams.CONNECTION_TIMEOUT;

	public final static String ASYNC = "ASYNC";
	
	public final static String HTTP_RETRY_COUNT = "HTTP_RETRY_COUNT";

	/**
	 * Empty Json
	 */
	public final static String EMPTY_JSON = "{}";

	/** The Constant AJAX_HANDLER_TIMEOUT. */
	public final static String AJAX_HANDLER_TIMEOUT = "AJAX_HANDLER_TIMEOUT";

	/** UI端顯示訊息 */
	public final static String AJAX_NOTIFY_MESSAGE = "NOTIFY_MESSAGE";

	/**
	 * security
	 */
	public final static String SECURITY_CONTEXT = "capSecurityContext";

	/**
	 * system config
	 */
	public final static String SYSTEM_CONFIG = "systemConfig";

	public static final String TXNCD = "transCde";

}
