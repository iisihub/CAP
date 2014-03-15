/*
 * SearchModeParameter.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.dao.utils;


/**
 * <pre>
 * SearchModeParameter
 * </pre>
 * 
 * @since 2011/3/28
 * @author iristu
 * @version <ul>
 *          <li>2011/3/28,iristu,new
 *          </ul>
 */
public class SearchModeParameter {

	SearchMode mode;
	Object key;
	Object value;

	public SearchModeParameter(SearchMode searchMode, Object key, Object value) {
		this.mode = searchMode;
		this.key = key;
		this.value = value;
	}

	public SearchMode getMode() {
		return mode;
	}

	@SuppressWarnings("unchecked")
	public <K> K getKey() {
		return (K) key;
	}

	public Object getValue() {
		return value;
	}

	
	public String toString() {
		return new StringBuffer().append(key).append(" ").append(mode)
				.append(" ").append(value).toString();
	}

}
