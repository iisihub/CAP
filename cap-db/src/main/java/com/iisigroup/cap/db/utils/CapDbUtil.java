/* 
 * CapDbUtil.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.db.utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;

/**
 * <pre>
 * CapDbUtil
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public class CapDbUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CapDbUtil.class);
    
    /**
     * Convert a prepared statment to standard SQL command Can be used to debug SQL command
     * 
     * @param cmd
     *            the sql
     * @param data
     *            the parameters
     * @return String
     */
    public static String convertToSQLCommand(String cmd, Map<String, ?> data) {
        String sql = NamedParameterUtils.parseSqlStatementIntoString(cmd);
        if (data == null || data.isEmpty())
            return cmd;
        Object[] oa = NamedParameterUtils.buildValueArray(cmd, data);
        StringBuffer sb = new StringBuffer(sql);
        try {
            int[] npos = getQuestionPos(sb, oa.length);
            for (int j = npos.length - 1; j >= 0; j--) {
                if (npos[j] > 0) {
                    int pos = npos[j];
                    String value = getSqlValue(oa[j]);
                    sb.deleteCharAt(pos);
                    sb.insert(pos, value == null ? "null" : "'" + value + "'");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.error(e.getMessage());
        }
        return sb.toString();
    }

    @SuppressWarnings("rawtypes")
    protected static String getSqlValue(Object o) {
        String rtn = null;
        if (o == null) {
            rtn = null;
        } else {
            if (o instanceof String) {
                rtn = (String) o;
            } else if (o instanceof Number || o instanceof BigDecimal || o instanceof StringBuffer) {
                rtn = o.toString();
            } else if (o instanceof Timestamp) {
                rtn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(o);
            } else if (o instanceof Time) {
                rtn = new SimpleDateFormat("HH:mm:ss").format(o);
            } else if (o instanceof Date) {
                rtn = new SimpleDateFormat("yyyy-MM-dd").format(o);
            } else if (o instanceof Collection) {
                rtn = getSqlValue(((Collection) o).toArray());
            } else if (o.getClass().isArray()) {
                if (Array.getLength(o) > 0) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < Array.getLength(o); ++i) {
                        sb.append(i == 0 ? "" : "'").append(Array.get(o, i)).append("',");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    rtn = sb.toString();
                } else {
                    rtn = "empty?";
                }
            } else {
                rtn = "?";
            }
        }
        return rtn;
    }

    /**
     * getQuestionPos
     * 
     * @param sb
     *            StringBuffer
     * @param len
     *            len
     * @return int[]
     */
    protected static int[] getQuestionPos(StringBuffer sb, int len) {
        int[] pos = new int[len];
        int npos = 0;
        int i = 0;
        do {
            npos = sb.indexOf("?", npos);
            pos[i] = npos;
            i++;
            npos++;
        } while (npos > 0 && i < pos.length);
        return pos;
    }

}
