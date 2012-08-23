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

import com.iisigroup.cap.utils.StringUtil;


/**
 * <p>
 * set log4j MDC for log user information.
 * </p>
 * 
 * @author gabriellalau
 * @version <ul>
 *              <li>2011-11-23,gabriella,new
 *          </ul>
 */
public class LogContextFilter implements Filter {

	//private static final Logger log = Logger.getLogger(CapLogContextFilter.class);
	// private static final Logger logger =
	// Logger.getLogger(CapLogContextFilter.class);

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
		LogContext.setUUID(StringUtil.getUUIDString());
		//CapLogContext.setIp(req.getLocalAddr());
		if (session == null) {
			LogContext.setLogin(DEFAULT_LOGIN);
		} else {
			// 用戶端IP
			LogContext.put("clientAddr", req.getRemoteAddr());
			// Session ID
			LogContext.setSessionId(session.getId());
			LogContext.setRequestURL(getRequestURL(req));
			// User相關資訊
			String userId = (String) session.getAttribute(LOGIN_USERNAME);
			userId = StringUtil.isEmpty(userId) ? (String) request
					.getParameter("j_username") : userId;
			if (StringUtil.isEmpty(userId)) {
				LogContext.setLogin(DEFAULT_LOGIN);
			} else {
				LogContext.setLogin(userId);
			}
		}
		//log.info("test for MDC");
		chain.doFilter(request, response);
		LogContext.remove("reqURI");
		LogContext.remove(LogContext.SESSION_ID);
		LogContext.remove(LogContext.LOGIN);
	}// ;

	/**
	 * Gets the request url.
	 * 
	 * @param filter
	 *            the filter
	 * 
	 * @return the request url
	 */
	private String getRequestURL(HttpServletRequest req) {
		String url = req.getRequestURI().replaceFirst(req.getContextPath(), "");
		int f = url.indexOf("/app");
		if (f > -1) {
			url = url.substring(f + 4);
		}
		if (!StringUtil.isEmpty(req.getParameter("_pa"))) {
			url = "/" + req.getParameter("_pa");
//		} else {
//			String queryString = req.getQueryString();
//			if (!StringUtil.isEmpty(queryString)) {
//				StringBuffer newQueryString = new StringBuffer();
//				String[] query = queryString.split("&");
//				for (String q : query) {
//					if (q.startsWith("x=") || q.startsWith("jsessionid=")
//							|| "_pa=".equals(q) || "_=".equals(q)) {
//						continue;
//					} else {
//						newQueryString.append(q).append('&');
//					}
//				}
//				if (newQueryString.length() > 0) {
//					newQueryString.deleteCharAt(newQueryString.length() - 1);
//				}
//				if (newQueryString.indexOf("_pa=") > -1) {
//					return newQueryString.toString();
//				} else if (newQueryString.length() > 0) {
//					return new StringBuffer(url).append("?")
//							.append(newQueryString.toString()).toString();
//				}
//			}
		}
		return url;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// do nothing
	}

}
