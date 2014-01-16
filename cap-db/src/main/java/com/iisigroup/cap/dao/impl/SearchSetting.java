/*
 * SearchSetting.java
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
package com.iisigroup.cap.dao.impl;

import com.iisigroup.cap.dao.utils.AbstractSearchSetting;
import com.iisigroup.cap.dao.utils.ISearch;

/**
 * <pre>
 * SearchSetting
 * </pre>
 * 
 * @since 2011/3/28
 * @author iristu
 * @version <ul>
 *          <li>2011/3/28,iristu,new
 *          <li>2011/6/10,RodesChen, add method
 *          </ul>
 */
class SearchSetting extends AbstractSearchSetting implements ISearch {

	private static final long serialVersionUID = 1L;

	public SearchSetting() {

	}

	/**
	 * Constructs a new search template and initializes it with the values of
	 * the passed search template.
	 * 
	 * @param searchSetting
	 *            searchSetting
	 */
	public SearchSetting(ISearch searchSetting) {
		setOrderBy(searchSetting.getOrderBy());
		setFirstResult(searchSetting.getFirstResult());
		setMaxResults(searchSetting.getMaxResults());
	}

}
