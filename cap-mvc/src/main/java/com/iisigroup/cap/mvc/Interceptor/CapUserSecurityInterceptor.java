/* 
 * BQDUserSecurityInterceptor.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.mvc.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.model.CapUserDetails;

/**
 * <pre>
 * 交易權限判斷
 * </pre>
 * 
 * @since 2011/11/30
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/30,rodeschen,new
 *          </ul>
 */
public class CapUserSecurityInterceptor extends HandlerInterceptorAdapter {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet .http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        CapUserDetails user = CapSecurityContext.getUser();
        // try {
        if (user == null) {
            user = new CapUserDetails();
            // user.setUnitNo("XXX");
            // user.setUserId("testUser");
            // user.setUserName("測試使用者");
        }
        // } catch (CapException e) {
        // Map<String, String> mapMessage = new HashMap<String, String>();
        // mapMessage.put("ERRMSG", e.getMessage());
        // throw new ModelAndViewDefiningException(new ModelAndView("/error",
        // mapMessage));
        // }
        if (user != null && request.getRequestURI().equals(request.getContextPath() + "/")) {
            response.sendRedirect(request.getContextPath() + "/page/index");
            return false;
        }
        return true;

    }

}
