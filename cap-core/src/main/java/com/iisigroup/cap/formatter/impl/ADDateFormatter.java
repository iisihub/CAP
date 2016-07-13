/*
 * ADDateFormatter.java
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

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.iisigroup.cap.constants.Constants;
import com.iisigroup.cap.formatter.Formatter;

/**
 * <p>
 * 西元年日期Format (yyyy-MM-dd).
 * </p>
 * 
 * @author iristu
 * @version $Revision: 26 $
 * @version
 *          <ul>
 *          <li>2010/7/27,iristu,new
 *          <li>2011/8/02,sunkist,update {@link ADDateTimeFormatter#reformat(Object)} for Calendar.
 *          <li>2011/9/06,tammychen, handle null Object
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings("serial")
public class ADDateFormatter implements Formatter {

    private SimpleDateFormat df;

    private final static String DEF_PATTERN = "yyyy-MM-dd";

    public ADDateFormatter() {
        df = new SimpleDateFormat(DEF_PATTERN);
    }

    public ADDateFormatter(String pattern) {
        df = new SimpleDateFormat(pattern);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.formatter.IFormatter#reformat(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public String reformat(Object in) {
        if (in != null && !"".equals(in)) {
            if (in instanceof Calendar) {
                in = ((Calendar) in).getTime();
            } else if (in instanceof String) {
                return df.format(df.parse((String) in, new ParsePosition(0)));
            }
            return df.format(in);
        } else {
            return Constants.EMPTY_STRING;
        }
    }

}
