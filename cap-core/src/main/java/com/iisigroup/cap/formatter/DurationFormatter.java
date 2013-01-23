/* 
 * DurationFormatter.java
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * 計算時間差
 * </pre>
 * 
 * @since 2012/11/7
 * @author iristu
 * @version <ul>
 *          <li>2012/11/7,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class DurationFormatter implements IBeanFormatter {

	private String startCol;
	private String endCol;
	private SimpleDateFormat _df;
	String DEF_PATTERN = "HH:mm:ss";

	public DurationFormatter(String startCol, String endCol, String pattern) {
		this.startCol = startCol;
		this.endCol = endCol;
		_df = new SimpleDateFormat(pattern);
		_df.setTimeZone(TimeZone.getTimeZone("GMT"));
	}// ;

	public DurationFormatter(String startCol, String endCol) {
		this.startCol = startCol;
		this.endCol = endCol;
		_df = new SimpleDateFormat(DEF_PATTERN);
		_df.setTimeZone(TimeZone.getTimeZone("GMT"));
	}// ;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.formatter.IFormatter#reformat(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String reformat(Object in) {
		Timestamp start = null, end = null;
		if (in instanceof GenericBean) {
			GenericBean bean = (GenericBean) in;
			start = (Timestamp) bean.get(startCol);
			end = (Timestamp) bean.get(endCol);
		} else if (in instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) in;
			start = (Timestamp) map.get(startCol);
			end = (Timestamp) map.get(endCol);
		}
		if (end != null) {
			return _df.format(new Date(end.getTime() - start.getTime()));
		}
		return Constants.EMPTY_STRING;
	}// ;

}
