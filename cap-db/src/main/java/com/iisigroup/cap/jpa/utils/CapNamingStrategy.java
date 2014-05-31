/* 
 * CapNamingStrategy.java
 * 
 * Copyright (c) 2009-2014 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.jpa.utils;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

/**
 * <pre>
 * Custom Naming Strategy.
 * </pre>
 * 
 * @since 2014/3/31
 * @author Sunkist Wang
 * @version <ul>
 *          <li>2014/3/31,Sunkist Wang,new
 *          </ul>
 */
public class CapNamingStrategy extends ImprovedNamingStrategy {

	/***/
	private static final long serialVersionUID = 1L;

	private static final String TABLE_PREFIX = "";

	public CapNamingStrategy() {
	}

	public String classToTableName(String className) {
		return (new StringBuilder()).append(TABLE_PREFIX)
				.append(StringHelper.unqualify(className)).toString();
	}

	public String tableName(String tableName) {
		return (new StringBuilder()).append(TABLE_PREFIX).append(tableName)
				.toString();
	}

	public String columnName(String columnName) {
		return columnName;
	}

	public String propertyToColumnName(String propertyName) {
		return propertyName;
	}
}
