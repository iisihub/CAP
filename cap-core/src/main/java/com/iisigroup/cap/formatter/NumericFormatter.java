/* 
 * NumericFormatter.java
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

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.iisigroup.cap.utils.CapMath;

/**
 * <pre>
 * 數字字串的formatter
 * </pre>
 * 
 * @since 2010/11/24
 * @author iristu
 * @version <ul>
 *          <li>2010/11/24,iristu,new
 *          <li>2011/9/06,tammychen, handle BigDecimal
 *          </ul>
 */
@SuppressWarnings("serial")
public class NumericFormatter implements IFormatter {

	private DecimalFormat _nf;

	public NumericFormatter() {
		this._nf = new DecimalFormat("###,##0");
	}

	public NumericFormatter(String pattern) {
		this._nf = new DecimalFormat(pattern);
	}

	/**
	 * <pre>
	 * 數字的Formatter
	 * </pre>
	 * 
	 * @param in
	 *            input
	 * @return String
	 * @throws CapFormatException
	 */
	@SuppressWarnings("unchecked")
	
	public String reformat(Object in) {

		BigDecimal dec = in instanceof BigDecimal ? (BigDecimal) in : CapMath
				.getBigDecimal((String) in);
		return _nf.format(dec);
	}

}
