/* 
 * CodeTypeFormatter.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.formatter;

import java.math.BigDecimal;
import java.util.Map;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.formatter.KeyValueFormatTypeEnum;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 取得codeType
 * </pre>
 * 
 * @since 2013/2/26
 * @author iristu
 * @version <ul>
 *          <li>2013/2/26,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CodeTypeFormatter implements IFormatter {

	CodeTypeService service;
	String codeType;
	KeyValueFormatTypeEnum show;
	Map<String, String> codeMap;

	public CodeTypeFormatter(CodeTypeService service, String codeType) {
		this.service = service;
		this.codeType = codeType;
		this.codeMap = service.findByCodeType(codeType, CapSecurityContext
				.getLocale().toString());
		this.show = KeyValueFormatTypeEnum.Value;
	}

	public CodeTypeFormatter(CodeTypeService service, String codeType,
			KeyValueFormatTypeEnum show) {
		this.service = service;
		this.codeType = codeType;
		this.codeMap = service.findByCodeType(codeType, CapSecurityContext
				.getLocale().toString());
		this.show = show;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.formatter.IFormatter#reformat(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String reformat(Object in) {
		if (in instanceof BigDecimal) {
			in = ((BigDecimal) in).toPlainString();
		}
		String k = (String) in;
		if (codeMap != null && !CapString.isEmpty(k)) {
			String value = "";
			if (codeMap.containsKey(k)) {
				value = codeMap.get(k);
			}
			switch (show) {
			case Key_Value:
				return new StringBuffer(k).append("-").append(value).toString();
			case KeySpaceValue:
				return new StringBuffer(k).append(" ").append(value).toString();
			default:
				return value;
			}
		}
		return Constants.EMPTY_STRING;
	}

}
