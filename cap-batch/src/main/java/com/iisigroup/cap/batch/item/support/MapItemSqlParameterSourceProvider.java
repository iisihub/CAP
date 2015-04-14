/* 
 * MapItemSqlParameterSourceProvider.java
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

import java.util.Map;

import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

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
public class MapItemSqlParameterSourceProvider implements ItemSqlParameterSourceProvider<Map<String, Object>> {

    @Override
    public SqlParameterSource createSqlParameterSource(Map<String, Object> item) {
        return new MapSqlParameterSource(item);
    }

}
