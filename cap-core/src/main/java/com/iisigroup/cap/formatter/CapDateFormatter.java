/* 
 * CapDateFormatter.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.formatter;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.utils.CapDate;

/**
 * <pre>
 * 使用CapDate執行format
 * </pre>
 * 
 * @since 2013/4/16
 * @author iristu
 * @version
 *          <ul>
 *          <li>2013/4/16,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapDateFormatter implements Formatter {

    String fromDateFormat;
    String toDateFormat;

    public CapDateFormatter(String fromDateFormat, String toDateFormat) {
        this.fromDateFormat = fromDateFormat;
        this.toDateFormat = toDateFormat;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String reformat(Object in) {
        if (in != null) {
            String str = (String) in;
            return CapDate.formatDateFromF1ToF2(str, fromDateFormat, toDateFormat);
        }
        return Constants.EMPTY_STRING;
    }

}
