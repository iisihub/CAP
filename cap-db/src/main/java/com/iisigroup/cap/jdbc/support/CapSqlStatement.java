/* 
 * CapSqlStatement.java
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.ParserContext;

/**
 * <pre>
 * CapSqlStatement
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public class CapSqlStatement {

    final Map<String, Object> parameter;

    ParserContext parserContext;

    public CapSqlStatement(Map<String, Object> map) {
        this.parameter = map;
    }

    public CapSqlStatement(Collection<Map<String, Object>> collection) {
        this.parameter = new HashMap<String, Object>();
        for (Map<String, Object> map : collection) {
            parameter.putAll(map);
        }
    }

    public Map<String, Object> getParameter() {
        return parameter;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(String key, T defaultValue) {
        if (parameter.containsKey(key)) {
            Object obj = parameter.get(key);
            return (T) obj;
        }
        return defaultValue;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) {
        if (parameter.containsKey(key)) {
            Object obj = parameter.get(key);
            return (T) obj;
        }
        return null;
    }

    public boolean containsKey(String key) {
        return parameter.containsKey(key);
    }

    public ParserContext getParserContext() {
        return parserContext;
    }

    public void setParserContext(ParserContext parserContext) {
        this.parserContext = parserContext;
    }

}// ~
