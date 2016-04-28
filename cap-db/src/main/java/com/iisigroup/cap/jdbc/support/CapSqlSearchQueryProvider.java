/* 
 * CapSqlSearchProd.java
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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.model.SearchModeParameter;

/**
 * <pre>
 * JdbcTemplate SqlSearchQueryProvider
 * </pre>
 * 
 * @since 2012/11/7
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/11/7,iristu,new
 *          </ul>
 */
public class CapSqlSearchQueryProvider {

    Map<String, Object> params;
    SearchSetting search;

    public CapSqlSearchQueryProvider(SearchSetting search) {
        this.search = search;
        this.params = new HashMap<String, Object>();
        params.put("startRow", search.getFirstResult());
        params.put("endRow", search.getFirstResult() + search.getMaxResults());
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String generateWhereCause() {
        StringBuffer sb = new StringBuffer();
        if (!CollectionUtils.isEmpty(search.getSearchModeParameters())) {
            for (SearchModeParameter s : search.getSearchModeParameters()) {
                Object _key = s.getKey();
                Object _value = s.getValue();
                if (_key instanceof SearchModeParameter && _value instanceof SearchModeParameter) {
                    sb.append('(').append(generateItemQuery((SearchModeParameter) _key));
                    if (SearchMode.OR == s.getMode()) {
                        sb.append(" or ");
                    } else if (SearchMode.AND == s.getMode()) {
                        sb.append(" and ");
                    }
                    sb.append(generateItemQuery((SearchModeParameter) _value)).append(')');

                } else {
                    sb.append(generateItemQuery(s));
                }
                sb.append(" and ");
            }
            int len = sb.length();
            sb.delete(len - 5, len); // 拿掉最後一個" and "
        } else {
            sb.append("1 = 1");
        }

        return sb.toString();
    }

    public String generateOrderCause() {
        StringBuffer sb = new StringBuffer();
        if (search.hasOrderBy()) {
            sb.append(" order by ");
            Map<String, Boolean> orderMap = search.getOrderBy();
            for (Entry<String, Boolean> entry : orderMap.entrySet()) {
                sb.append(entry.getKey());
                if (entry.getValue()) {
                    sb.append(" desc ");
                }
                sb.append(',');
            }
            int len = sb.length();
            sb.delete(len - 1, len); // 拿掉最後一個","
        }
        return sb.toString();
    }

    @SuppressWarnings("incomplete-switch")
    private String generateItemQuery(SearchModeParameter search) {
        String key = search.getKey();
        Object value = search.getValue();
        StringBuffer sb = new StringBuffer();
        switch (search.getMode()) {

        case BETWEEN:
            Object[] values = asArray(value);
            if (values != null) {
                sb.append(key).append(" between :").append(key).append("1 and :").append(key).append('2');
                params.put(key + "1", values[0]);
                params.put(key + "2", values[1]);
            }
            break;
        case GREATER_THAN:
            sb.append(key).append(" < :").append(key);
            params.put(key, value);
            break;
        case GREATER_EQUALS:
            sb.append(key).append(" >= :").append(key);
            params.put(key, value);
            break;
        case LESS_THAN:
            sb.append(key).append(" < :").append(key);
            params.put(key, value);
            break;
        case LESS_EQUALS:
            sb.append(key).append(" <= :").append(key);
            params.put(key, value);
            break;
        case IS_NULL:
            sb.append(key).append(" is null ");
            break;
        case IS_NOT_NULL:
            sb.append(key).append(" is not null ");
            break;
        case IN:
            sb.append(key).append(" in :").append(key);
            params.put(key, asCollection(value));
            break;
        case LIKE:
            sb.append(key).append(" like :").append(key);
            params.put(key, value);
            break;
        case NOT_LIKE:
            sb.append(key).append(" not like :").append(key);
            params.put(key, value);
            break;
        case EQUALS:
            sb.append(key).append(" = :").append(key);
            params.put(key, value);
            break;
        case NOT_EQUALS:
            sb.append(key).append(" != :").append(key);
            params.put(key, value);
            break;
        }
        return sb.toString();
    }

    private Collection<?> asCollection(Object value) {
        if (value instanceof Collection) {
            return (Collection<?>) value;
        } else if (value.getClass().isArray()) {
            return Arrays.asList(value);
        }
        return Arrays.asList(value);
    }

    @SuppressWarnings("rawtypes")
    private Object[] asArray(Object value) {
        if (value.getClass().isArray()) {
            Object[] result = new Object[Array.getLength(value)];
            for (int i = 0; i < result.length; ++i) {
                result[i] = Array.get(value, i);
            }
            return result;
        } else if (value instanceof Collection) {
            return ((Collection) value).toArray();
        }
        return null;
    }

}// ~
