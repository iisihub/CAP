/* 
 * ColumnMapFieldSetMapper.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.item.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/11/19
 * @author iristu
 * @version <ul>
 *          <li>2012/11/19,iristu,new
 *          </ul>
 */
public class ColumnMapFieldSetMapper implements
		FieldSetMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapFieldSet(FieldSet fieldSet)
			throws BindException {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Entry<Object, Object> entry : fieldSet.getProperties().entrySet()) {
			map.put(String.valueOf(entry.getKey()), entry.getValue());
		}
		return map;
	}
}
