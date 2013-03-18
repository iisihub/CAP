/*
 * CapLogInfoFilter.java
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
package com.iisigroup.cap.log;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapWebUtil;

/**
 * <p>
 * set log4j MDC for log user information.
 * </p>
 * 
 * @author iris tu
 * @version <ul>
 *          <li>2011-11-23,iristu,new
 *          <li>2013-1-23,RodesChen,move getRequestURL to CapWebUtil
 *          </ul>
 */
public class LogContextFilter implements Filter {

	public final static String LOGIN_USERNAME = "LOGIN_USERNAME";

	private final static String DEFAULT_LOGIN = "------";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		LogContext.resetLogContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		// Host IP
		LogContext.setHost(req.getLocalAddr());

		if (session == null) {
			LogContext.setLogin(DEFAULT_LOGIN);
		} else {
			// 用戶端IP
			LogContext.seClientAddr(req.getRemoteAddr());
			// Session ID
			LogContext.setSessionId(session.getId());
			LogContext.setRequestURL(CapWebUtil.getRequestURL(req));
			// User相關資訊
			String userId = (String) session.getAttribute(LOGIN_USERNAME);
			userId = CapString.isEmpty(userId) ? (String) request
					.getParameter("j_username") : userId;
			if (CapString.isEmpty(userId)) {
				LogContext.setLogin(DEFAULT_LOGIN);
			} else {
				LogContext.setLogin(userId);
			}
		}
		chain.doFilter(request, response);
		LogContext.resetLogContext();
	}// ;

	public void init(FilterConfig filterConfig) throws ServletException {
		// do nothing
	}

}
