/* 
 * CapAuthenticationDetails.java
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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.iisigroup.cap.security.model.CapUserDetails;

/**
 * <pre>
 * CapAuthenticationDetails
 * </pre>
 * 
 * @since 2013/3/26
 * @author iristu
 * @version <ul>
 *          <li>2013/3/26,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapAuthenticationDetails extends WebAuthenticationDetails {

	private CapUserDetails userDetails;

	@SuppressWarnings("rawtypes")
	private Map parameters = new HashMap();

	@SuppressWarnings("unchecked")
	public CapAuthenticationDetails(HttpServletRequest request) {
		super(request);
		this.userDetails = (CapUserDetails) request.getAttribute("userDetails");
		parameters.putAll(request.getParameterMap());
	}

	public CapUserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(CapUserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Map<?, ?> getParameters() {
		return parameters;
	}

	public String getString(String key) {
		Object o = parameters.get(key);
		if (o == null) {
			return null;
		} else if (o instanceof String) {
			return (String) o;
		} else if (o instanceof String[]) {
			return (String) ((String[]) o)[0];
		}
		return String.valueOf(o);
	}

}
