/*
 * GenericBean.java
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
package com.iisigroup.cap.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.ReflectionUtils;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.ADDateTimeFormatter;
import com.iisigroup.cap.formatter.IBeanFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapString;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <p>
 * GenericBean.
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/19,iristu,new
 *          <li>2011/8/02,sunkistWang,update {@link GenericBean#toJSONString(String[], Map)}, {@link GenericBean#toJSONObject(String[], Map)} for Calendar.
 *          <li>2011/08/08,iristu,新增IBeanFormatter
 *          <li>2011/10/05,iristu,get()新增取得GenericBean欄位值(gbean.field1).
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class GenericBean {

    /**
     * set值
     * 
     * @param <T>
     *            T extends GenericBean
     * @param field
     *            欄位id
     * @param value
     *            欄位值
     * @return T <T>
     */
    @SuppressWarnings("unchecked")
    public <T> T set(String field, Object value) {
        if (CapString.isEmpty(field)) {
            return (T) this;
        }
        try {
            Field f = ReflectionUtils.findField(getClass(), field);
            if (f != null) {
                String setter = new StringBuffer("set").append(String.valueOf(f.getName().charAt(0)).toUpperCase()).append(f.getName().substring(1)).toString();
                Method method = ReflectionUtils.findMethod(this.getClass(), setter, new Class[] { f.getType() });
                if (method != null) {
                    method.invoke(this, value);
                }
            }
        } catch (Exception e) {
            throw new CapException(new StringBuffer("field:").append(field).append(" ").append(e.getMessage()).toString(), e, getClass());
        }
        return (T) this;
    }

    /**
     * 取得某欄位的值
     * 
     * @param fieldId
     *            欄位名稱
     * @return Object
     */
    public Object get(String fieldId) {
        if (CapString.isEmpty(fieldId)) {
            throw new CapException("field [" + fieldId + "] is empty!!", getClass());
        }
        try {
            String field = fieldId;
            int index = fieldId.indexOf(".");
            if (index > 0) {
                field = fieldId.substring(0, index);
                Object keyClazz = get(field);
                if (keyClazz instanceof GenericBean) {
                    return ((GenericBean) keyClazz).get(fieldId.substring(index + 1));
                }
            } else {
                String getter = new StringBuffer("get").append(String.valueOf(field.charAt(0)).toUpperCase()).append(field.substring(1)).toString();
                Method method = ReflectionUtils.findMethod(getClass(), getter);
                if (method == null) {
                    getter = "is" + getter.substring(3);
                    method = ReflectionUtils.findMethod(getClass(), getter);
                }
                if (method != null) {
                    return method.invoke(this);
                } else {
                    Field f = ReflectionUtils.findField(getClass(), field);
                    if (f != null) {
                        f.setAccessible(true);
                        return f.get(this);
                    }
                }
            }
            throw new CapException(new StringBuffer("field:").append(field).append(" is not exist!!").toString(), getClass());

        } catch (Exception e) {
            throw new CapException(e, getClass());
        }

    }

    private static String SPLIT = "\\|";

    /**
     * 取得每個欄位的值
     * 
     * @param columns
     *            顯示欄位
     * @param reformat
     *            Map<String, IFormatter>
     * @return String JsonString
     */
    public String toJSONString(String[] columns, Map<String, IFormatter> reformat) {
        JSONArray row = new JSONArray();
        for (String str : columns) {
            Object val = null;
            try {
                try {
                    String[] s = str.split(SPLIT);
                    val = s.length == 1 ? get(s[0]) : get(s[1]);
                    str = s[0];
                } catch (Exception e) {
                    val = "";
                }
                if (reformat != null && reformat.containsKey(str)) {
                    IFormatter callback = reformat.get(str);
                    if (callback instanceof IBeanFormatter) {
                        val = callback.reformat(this);
                    } else {
                        val = callback.reformat(val);
                    }
                } else if (val instanceof Timestamp) {
                    val = new ADDateTimeFormatter().reformat(val);
                } else if (val instanceof Date || val instanceof Calendar) {
                    val = new ADDateFormatter().reformat(val);
                }
                row.add(String.valueOf(val));
            } catch (Exception e) {
                throw new CapException(e.getMessage(), e, getClass());
            }
        }
        return row.toString();
    }

    /**
     * 取得每個欄位的值
     * 
     * @param columns
     *            顯示欄位
     * @param reformat
     *            Map<String, IFormatter>
     * @return String JsonString
     */
    public JSONObject toJSONObject(String[] columns, Map<String, IFormatter> reformat) {
        JSONObject json = new JSONObject();
        if (columns == null) {
            Field[] cols = CapBeanUtil.getField(this.getClass(), true);// this.getClass().getDeclaredFields();
            columns = new String[cols.length];
            for (int i = 0; i < columns.length; i++) {
                columns[i] = cols[i].getName();
            }
        }
        for (String str : columns) {
            Object val = null;
            try {
                try {
                    val = get(str);
                } catch (Exception e) {
                    val = "";
                }
                if (reformat != null && reformat.containsKey(str)) {
                    IFormatter callback = reformat.get(str);
                    if (callback instanceof IBeanFormatter) {
                        val = callback.reformat(this);
                    } else {
                        val = callback.reformat(val);
                    }
                } else if (val instanceof Timestamp) {
                    val = new ADDateTimeFormatter().reformat(val);
                } else if (val instanceof Date || val instanceof Calendar) {
                    val = new ADDateFormatter().reformat(val);
                }
                json.element(str, val);
            } catch (Exception e) {
                throw new CapException(e.getMessage(), e, getClass());
            }
        }
        return json;
    }

    /**
     * toString
     * 
     * @return string
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false, false);
    }

}
