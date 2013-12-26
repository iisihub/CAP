/* 
 * Cap.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

/**
 * <pre>
 * CapWebAuthenticationDetailsSource
 * 注入CapAuthenticationDetails
 * </pre>
 * 
 * @since 2013/3/26
 * @author iristu
 * @version <ul>
 *          <li>2013/3/26,iristu,new
 *          </ul>
 */
public class CapWebAuthenticationDetailsSource extends
		WebAuthenticationDetailsSource {

	public CapAuthenticationDetails buildDetails(HttpServletRequest context) {
		return new CapAuthenticationDetails(context);
	}

}
