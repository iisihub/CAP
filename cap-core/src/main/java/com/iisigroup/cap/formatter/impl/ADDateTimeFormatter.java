/*
 * ADDateTimeFormatter.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.formatter.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.iisigroup.cap.constants.Constants;
import com.iisigroup.cap.formatter.Formatter;

/**
 * <pre>
 * 西元年日期時間Format (yyyy-MM-dd HH:mm:ss)
 * </pre>
 * 
 * @since 2010/7/27
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/27,iristu,new
 *          <li>2011/8/02,sunkist,update {@link ADDateTimeFormatter#reformat(Object)} for Calendar.
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings("serial")
public class ADDateTimeFormatter implements Formatter {

    private SimpleDateFormat _df;

    String DEF_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public ADDateTimeFormatter() {
        _df = new SimpleDateFormat(DEF_PATTERN);
    }

    public ADDateTimeFormatter(String pattern) {
        _df = new SimpleDateFormat(pattern);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.formatter.IFormatter#reformat(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public String reformat(Object in) {
        if (in == null) {
            return Constants.EMPTY_STRING;
        }
        if (in instanceof Calendar) {
            in = ((Calendar) in).getTime();
        } else if (in instanceof String) {
            return (String) in;
        }
        return _df.format(in);
    }

}
