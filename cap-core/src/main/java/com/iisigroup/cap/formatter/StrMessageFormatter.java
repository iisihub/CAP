/* 
 * StrMessageFormatter.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.formatter;

import java.util.Map;

/**
 * <pre>
 * Stirng Formattter
 * 
 * String unformatMsg = "An ${key1} a day keeps the ${key2} away!";
 * Map<String, Object> params = {key1=Apple,key2=doctor}
 * new StrMessageFormatter(String unformatMsg).reformat(params) ;
 * 
 * return An Apple a day keep the doctor away!
 * 
 * </pre>
 * 
 * @since 2011/12/1
 * @author iristu
 * @version <ul>
 *          <li>2011/12/1,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class StrMessageFormatter implements IFormatter {

	String unformatMsg;

	public StrMessageFormatter(String unformatMsg) {
		this.unformatMsg = unformatMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.formatter.IFormatter#reformat(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String reformat(Object in) {
		final Map<String, Object> params = (Map<String, Object>) in;
		final StringBuffer buffer = new StringBuffer();
		// For each occurrences of "${"
		int start;
		int pos = 0;

		while ((start = unformatMsg.indexOf("${", pos)) != -1) {
			buffer.append(unformatMsg.substring(pos, start));
			if (unformatMsg.charAt(start + 1) == '$') {
				buffer.append('$');
				pos = start + 2;
				continue;
			}
			pos = start;
			final int startVariableName = start + 2;
			final int endVariableName = unformatMsg.indexOf('}',
					startVariableName);

			if (endVariableName != -1) {
				String variableName = unformatMsg.substring(startVariableName,
						endVariableName);
				String value = params.containsKey(variableName) ? params.get(
						variableName).toString() : "";
				buffer.append(value);
				pos = endVariableName + 1;
			} else {
				break;
			}
		}
		if (pos < unformatMsg.length()) {
			buffer.append(unformatMsg.substring(pos));
		}
		return buffer.toString();
	}// ;

}// ~
