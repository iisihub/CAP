/* 
 * CapRowMapperResultSetExtractor.java
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

/**
 * <pre>
 * Callback interface used by {@link JdbcTemplate}'s query methods
 * </pre>
 * 
 * @param <T>
 *            T
 * @since 2011/8/4
 * @author iristu
 * @version <ul>
 *          <li>2011/8/4,iristu,new
 *          <li>2011/12/14,sunkistwang,remove ++
 *          </ul>
 */
public class CapRowMapperResultSetExtractor<T> implements
		ResultSetExtractor<List<T>> {

	private final RowMapper<T> rowMapper;

	private final int startRow;

	private final int fetchSize;

	/**
	 * EloanRowMapperResultSetExtractor
	 * 
	 * @param rowMapper
	 *            the RowMapper which creates an object for each row
	 * @param startRow
	 *            the start row
	 * @param fetchSize
	 *            the fetech size
	 */
	public CapRowMapperResultSetExtractor(RowMapper<T> rowMapper, int startRow,
			int fetchSize) {
		Assert.notNull(rowMapper, "RowMapper is required");
		this.rowMapper = rowMapper;
		this.startRow = startRow;
		this.fetchSize = fetchSize;
	}// ;

	/**
	 * extractData
	 * 
	 * @param rs
	 *            ResultSet
	 * @return List<T>
	 */
	public List<T> extractData(ResultSet rs) throws SQLException {
		List<T> results = new ArrayList<T>();
		// if (startRow > 1) {
		// for (int i = 0; i < startRow - 1; i++) {
		// if (!rs.next()) {
		// break;
		// }
		// }
		// }
		if (rs.absolute(startRow)) {
			for (int rows = 0; rows < fetchSize && rs.next(); rows++) {
				results.add(this.rowMapper.mapRow(rs, rows));
			}
		}
		return results;
	}// ;

}// ~
