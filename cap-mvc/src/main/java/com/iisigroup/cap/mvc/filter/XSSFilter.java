/**
 * 
 * <br>
 * Copyright: Copyright (c) 2001-2008<br>
 * Company: IISI
 * CrateDate: 2013/1/26 
 * @author gverds
 */
package com.iisigroup.cap.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author TimChiang
 * @since <li>2013/1/26,Tim,弱點掃描CrossSiteScript Filter
 * <li>2014/3/21,tammy,copy to citi, 過濾字元
 * <li>2014/4/7,Tim,copy to CAP
 */
public class XSSFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request),
				response);
	}
}
