/*
 * CapAuthenticationEntryPoint.java
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
package com.iisigroup.cap.security.web;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * <p>
 * 當sessin過期時的動作， 若Ajax Request時需記錄為AjaxRequest，導致loginFormUrl以便判別
 * 若為一般頁面之Request時，需導到loginFormUrl
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/11/2,iristu,new
 *          </ul>
 */
@SuppressWarnings("deprecation")
public class CapAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.ui.AuthenticationEntryPoint#commence(javax
     * .servlet.ServletRequest, javax.servlet.ServletResponse,
     * org.springframework.security.AuthenticationException)
     */
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String xReq = httpRequest.getHeader("x-requested-with");
        if ("XMLHttpRequest".equalsIgnoreCase(xReq)) {
            return new StringBuffer(getLoginFormUrl()).append("?ajax=1").toString();
        } else {
            return getLoginFormUrl();
        }
    }

}
