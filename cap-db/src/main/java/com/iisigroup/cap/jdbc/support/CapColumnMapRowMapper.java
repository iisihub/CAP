/* 
 * CapColumnMapRowMapper.java
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;

import com.iisigroup.cap.utils.CapDbUtil;

/**
 * <pre>
 * {@link ColumnMapRowMapper} implementation that creates a <code>java.util.Map</code>
 * </pre>
 * 
 * @since 2011/08/02
 * @author iristu
 * @version
 *          <ul>
 *          <li>2011/08/02,iristu,new
 *          <li>2011/08/10,iristu,override mapRow因取得getColumnKey需為rsmd.getColumnName的方式
 *          </ul>
 */
public class CapColumnMapRowMapper extends ColumnMapRowMapper {

    private String removePrefix;

    public CapColumnMapRowMapper setRemovePrefix(String removePrefix) {
        this.removePrefix = removePrefix;
        return this;
    }

    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Map<String, Object> mapOfColValues = createColumnMap(columnCount);
        for (int i = 1; i <= columnCount; i++) {
            String key = getColumnKey(rsmd.getColumnLabel(i));
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

    @Override
    protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
        Object obj = super.getColumnValue(rs, index);
        if (obj instanceof String) {
            String str = (String) obj;
            str = str.trim();
            obj = CapDbUtil.trimFullSpace(str);
        }
        return obj;
    }// ;

}// ~
