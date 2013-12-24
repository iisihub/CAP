/* 
 * CapColumnMapRowSetMapper.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.jdbc.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import com.iisigroup.cap.utils.CapDbUtil;

/**
 * <pre>
 * {@link ColumnMapRowMapper} implementation that creates a <code>java.util.Map</code>
 * </pre>
 * 
 * @since 2011/08/02
 * @author iristu
 * @version <ul>
 *          <li>2011/08/02,iristu,new
 *          <li>2011/08/10,iristu,override
 *          mapRow因取得getColumnKey需為rsmd.getColumnName的方式
 *          </ul>
 */
public class CapColumnMapRowSetMapper {

	private String removePrefix;

	public CapColumnMapRowSetMapper setRemovePrefix(String removePrefix) {
		this.removePrefix = removePrefix;
		return this;
	}

	public Map<String, Object> mapRow(SqlRowSet rs, int rowNum) {
		SqlRowSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Map<String, Object> mapOfColValues = new HashMap<String, Object>(
				columnCount);
		for (int i = 1; i <= columnCount; i++) {
			String key = rsmd.getColumnName(i);
			if (removePrefix != null) {
				key = key.replaceFirst(removePrefix, "");
			}
			Object obj = getColumnValue(rs, i);
			if (obj instanceof String) {
				obj = CapDbUtil.trimNull(obj);
			}
			mapOfColValues.put(key, obj);
		}
		return mapOfColValues;
	}// ;

	protected Object getColumnValue(SqlRowSet rs, int index) {
		Object obj = rs.getObject(index);
		if (obj instanceof String) {
			String str = (String) obj;
			str = str.trim();
			obj = CapDbUtil.trimFullSpace(str);
		}
		return obj;
	}// ;

}// ~
