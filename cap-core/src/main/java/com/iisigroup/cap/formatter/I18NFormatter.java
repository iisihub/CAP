/* 
 * I18NFormatter.java
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

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 取得i18n值
 * </pre>
 * 
 * @since 2012/11/12
 * @author iristu
 * @version <ul>
 *          <li>2012/11/12,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class I18NFormatter implements IFormatter {

	String prefix;
	boolean hasPrefix = false;

	public I18NFormatter() {
		hasPrefix = false;
	}
	
	public I18NFormatter(String prefix) {
		this.prefix = prefix;
		hasPrefix = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.formatter.IFormatter#reformat(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String reformat(Object in) throws CapFormatException {
		String key = CapString.trimNull(in);
		if (!CapString.isEmpty(key)) {
			return CapAppContext.getMessage(hasPrefix ? (prefix + key) : key);
		}
		return Constants.EMPTY_STRING;
	}

}
