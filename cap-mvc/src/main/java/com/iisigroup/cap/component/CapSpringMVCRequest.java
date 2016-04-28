/* 
 * CapDefaultRequest.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.component;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * default CapRequest
 * </pre>
 * 
 * @since 2011/11/23
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/23,rodeschen,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapSpringMVCRequest extends HashMap<String, Object> implements IRequest {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private ServletRequest request;

    // Map<String, Object> custParams = new HashMap<String, Object>();

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#SetRequestObject(java.lang.Object)
     */
    @Override
    public void setRequestObject(Object obj) {
        this.request = (HttpServletRequest) obj;
        super.putAll(getReqParameter(request));
    }

    /**
     * <pre>
     * 取得form傳過來的field名稱和值。
     * </pre>
     * 
     * @param req
     *            HttpServletRequest
     * @return Map 前頁傳過來的參數值
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getReqParameter(ServletRequest req) {
        Enumeration<String> fids = req.getParameterNames();
        HashMap<String, Object> hm = new HashMap<String, Object>();
        while (fids.hasMoreElements()) {
            String field = (String) fids.nextElement();
            String[] value = req.getParameterValues(field);
            hm.put(field, value);
        }
        return hm;
    } // ;

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#getParameter(java.lang.String)
     */
    @Override
    public String get(String key) {
        return get(key, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#getParameter(java.lang.String, java.lang.String)
     */
    @Override
    public String get(String key, String defaultValue) {
        Object value = null;
        value = super.containsKey(key) ? super.get(key) : request.getParameter(key);

        if (value == null) {
            logger.trace("can't find request parameter :" + key);
            return defaultValue;
        } else {
            if (value instanceof String[] && ((String[]) value).length > 0) {
                return ((String[]) value)[0];
            }
            return String.valueOf(value);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#setParameter(java.lang.String, java.lang.Object)
     */
    @Override
    public void setParameter(String key, Object value) {
        super.put(key, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#getServletRequest()
     */
    @SuppressWarnings("unchecked")
    @Override
    public ServletRequest getServletRequest() {
        return request;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#containsParamsKey(java.lang.String)
     */
    @Override
    public boolean containsParamsKey(String key) {
        return request.getParameter(key) != null || super.containsKey(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#getParamsAsInteger(java.lang.String )
     */
    @Override
    public int getParamsAsInteger(String key) {
        return Integer.valueOf(get(key, "0"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.component.ICapRequest#getParamsAsInteger(java.lang.String , int)
     */
    @Override
    public int getParamsAsInteger(String key, int defaultValue) {
        return Integer.valueOf(get(key, String.valueOf(defaultValue)));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisi.cap.component.ICapRequest#getParamsAsStringArray(java.lang.String )
     */
    @Override
    public String[] getParamsAsStringArray(String key) {
        Object values = super.get(key);
        if (values instanceof String[]) {
            return (String[]) values;
        } else if (values != null) {
            return new String[] { String.valueOf(values) };
        } else {
            return new String[0];
        }
    }

    @Override
    public String getParamsArrayAsString(String key) {
        String[] ary = getParamsAsStringArray(key);
        return CapString.array2String(ary);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisi.cap.component.ICapRequest#get(java.lang.String)
     */
    @Override
    public Object getObject(String key) {
        Object value = null;
        value = super.containsKey(key) ? super.get(key) : request.getParameter(key);

        if (value == null) {
            logger.debug("can't find request parameter :" + key);
            return null;
        } else {
            if (value instanceof String[] && ((String[]) value).length > 0) {
                return ((Object[]) value)[0];
            }
            return value;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisi.cap.component.ICapRequest#getFile(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getFile(String key) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        return (T) multipartRequest.getFile(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisi.cap.component.ICapRequest#getFiles(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getFiles(String key) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        return (List<T>) multipartRequest.getFiles(key);
    }
}
