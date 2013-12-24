/* 
 * FieldSetItemPreparedStatementSetter.java
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

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.file.transform.FieldSet;

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
public class FieldSetItemPreparedStatementSetter implements
		ItemPreparedStatementSetter<FieldSet> {

	@Override
	public void setValues(FieldSet item, PreparedStatement ps)
			throws SQLException {
		for (int i = 0; i < item.getValues().length; i++) {
			ps.setObject(i + 1, item.getValues()[i]);
		}

	}// ;

}
