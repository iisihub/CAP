/**
 * CapMessageException.java
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
 * <p>
 * class CapMessageException extends CapException.
 * </p>
 * 
 * <pre>
 * $Date: 2010-09-08 18:18:26 +0800 (星期三, 08 九月 2010) $
 * $Author: iris $
 * $Revision: 372 $
 * $HeadURL: svn://192.168.0.1/MICB_ISDOC/cap/cap-core/src/main/java/tw/com/iisi/cap/exception/CapMessageException.java $
 * </pre>
 * 
 * @author iristu
 * @version $Revision: 372 $
 * @version <ul>
 *          <li>2010/7/12,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings({ "serial" })
public class CapMessageException extends CapException {

    String i18nKey;

    /**
     * Instantiates a new cap exception.
     */
    public CapMessageException() {
        super();
    }

    /**
     * Instantiates a new cap exception.
     * 
     * @param causeClass
     *            the cause class
     */
    @SuppressWarnings("rawtypes")
    public CapMessageException(Class causeClass) {
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
    public CapMessageException(String message, Class causeClass) {
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
    public CapMessageException(Throwable cause, Class causeClass) {
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
    public CapMessageException(String message, Throwable cause, Class causeClass) {
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
    public CapMessageException setMessageKey(String i18nKey) {
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
