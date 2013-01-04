/* 
 * CapJdbcContants.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.contants;

/**
 * <pre>
 * CapJdbcContants
 * </pre>
 * 
 * @since 2012/9/19
 * @author iristu
 * @version <ul>
 *          <li>2012/9/19,iristu,new
 *          </ul>
 */
public interface CapJdbcContants {

	final String SQLQuery_Suffix = "query.suffix";

	final String SQLPaging_Query = "paging.querySql";

	final String SQLPaging_TotalPage = "paging.totalPage";
	
	final String SQLPaging_SourceSQL="sourceSQL";
	
	final static String EMPTY_STRING = "";

	/**
	 * a space string.
	 */
	final static String SPACE = " ";
	
	void nothing();

}
