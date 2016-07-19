/* 
 * ICapRequest.java
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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

/**
 * <pre>
 * CapResponse
 * </pre>
 * 
 * @since 2011/11/22
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/22,rodeschen,new
 *          </ul>
 */
public interface Request extends Map<String, Object>, Serializable {

    /**
     * set Request Object
     * 
     * @param obj
     *            request obj
     */
    void setRequestObject(Object obj);

    <T extends ServletRequest> T getServletRequest();

    /**
     * get request parameter
     * 
     * @param key
     *            欄位名
     * @return 回傳
     */
    String get(String key);

    /**
     * get request parameter
     * 
     * @param key
     *            欄位名
     * @return 回傳
     */
    Object getObject(String key);

    /**
     * get request parameter
     * 
     * @param key
     *            欄位名
     * @param defaultValue
     *            預設值
     * @return 回傳
     */
    String get(String key, String defaultValue);

    /**
     * set customize parameter
     * 
     * @param key
     *            欄位名
     * @param value
     *            值
     */
    void setParameter(String key, Object value);

    /**
     * check parameter exist
     * 
     * @param key
     *            欄位名
     * @return 回傳
     */
    boolean containsParamsKey(String key);

    /**
     * get Integer parameter
     * 
     * @param key
     *            欄位名
     * @return 回傳
     */
    int getParamsAsInteger(String key);

    /**
     * get Integer parameter
     * 
     * @param key
     *            欄位名
     * @param defaultValue
     *            預設值
     * @return 回傳
     */
    int getParamsAsInteger(String key, int defaultValue);

    String[] getParamsAsStringArray(String key);

    String getParamsArrayAsString(String key);

    <T> T getFile(String key);

    <T> List<T> getFiles(String key);

}
