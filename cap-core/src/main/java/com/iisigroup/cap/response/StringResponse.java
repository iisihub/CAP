/* 
 * StringResponse.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.response;

import java.io.OutputStream;

import javax.servlet.ServletResponse;

import com.iisigroup.cap.exception.CapException;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/9/24
 * @author iristu
 * @version <ul>
 *          <li>2012/9/24,iristu,new
 *          </ul>
 */
public class StringResponse {

	/** the string for the response. */
	private final String string;

	/** content type for the string */
	private final String contentType;

	/** charset of the string */
	private final String encoding;

	public StringResponse(String contentType, String encoding, String str) {
		this.contentType = contentType;
		this.string = str;
		this.encoding = encoding;
	}

	public void respond(ServletResponse response) {
		response.setContentType(contentType + ";charset=" + encoding);
		try {
			OutputStream out = response.getOutputStream();
			out.write(string.getBytes(encoding));
			out.flush();
		} catch (Exception e) {
			throw new CapException(e.getMessage(), e, getClass());
		}
	}
}
