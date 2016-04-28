/* 
 * CapWebUtil.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.iisigroup.cap.component.IRequest;

/**
 * <pre>
 * CapWebStringUtil
 * </pre>
 * 
 * @since 2011/12/9
 * @author iristu
 * @version
 *          <ul>
 *          <li>2011/12/9,iristu,new
 *          </ul>
 */
public class CapWebUtil {

    public static final String localeKey = "localeKey";

    /**
     * 下載檔名中文依IE及FireFox做區分
     * 
     * @param request
     *            HttpServletRequest
     * @param fileName
     *            前端要顯示的檔案名稱
     * @return String
     */
    public static String encodeFileName(IRequest request, String fileName) {
        try {
            fileName = URLDecoder.decode(fileName, "utf-8");
            return URLEncoder.encode(fileName, "UTF8");
        } catch (UnsupportedEncodingException e) {
            return fileName;
        }
    }

    /**
     * Gets the request url.
     * 
     * @param req
     *            HttpServletRequest
     * 
     * @return the request url
     */
    public static String getRequestURL(HttpServletRequest req) {
        String url = req.getRequestURI().replaceFirst(req.getContextPath(), "");
        int f = url.indexOf("/webroot");
        if (f > -1) {
            url = url.substring(f + 8);
        }
        if (!CapString.isEmpty(req.getParameter("_handler"))) {
            url = "/" + req.getParameter("_handler");
        } else if (!CapString.isEmpty((String) req.getAttribute("_handler"))) {
            url = "/" + req.getAttribute("_handler");
        }
        f = url.indexOf("/handler");
        if (f > -1) {
            url = url.substring(f + 8);
        }
        f = url.indexOf("/page");
        if (f > -1) {
            url = url.substring(f + 5);
        }
        return url;
    }

}
