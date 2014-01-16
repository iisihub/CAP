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
package com.iisigroup.cap.dao.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

/**
 * <p>
 * SearchSetting .
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/9,iristu,new
 *          <li>2011/03/21,iristu,配合JPA修改SearchModeParameter中key的型態
 *          <li>2011/6/10,RodesChen, add method
 *          </ul>
 */
public abstract class AbstractSearchSetting implements ISearch {

	private static final long serialVersionUID = 1L;

	public AbstractSearchSetting() {

	}

	/**
	 * Constructs a new search template and initializes it with the values of
	 * the passed search template.
	 * 
	 * @param searchSetting
	 *            searchSetting
	 */
	public AbstractSearchSetting(AbstractSearchSetting searchSetting) {
		setOrderBy(searchSetting.getOrderBy());
		setFirstResult(searchSetting.getFirstResult());
		setMaxResults(searchSetting.getMaxResults());
	}

	String entityName;

	public String getEntityName() {
		return entityName;
	}

	public AbstractSearchSetting setEntityName(String entityName) {
		this.entityName = entityName;
		return this;
	}

	private boolean isDistinct;

	/**
	 * <pre>
	 * 是否distinct result
	 * </pre>
	 * 
	 * @param isDistinct
	 *            true/false
	 */
	public void setDistinct(boolean isDistinct) {
		this.isDistinct = isDistinct;
	}

	/**
	 * <pre>
	 * 是否distinct result
	 * </pre>
	 * 
	 * @return boolean
	 */
	public boolean isDistinct() {
		return isDistinct;
	}

	// -----------------------------------
	// Order by support
	// -----------------------------------
	private Map<String, Boolean> orderBy;

	public boolean hasOrderBy() {
		return !(orderBy == null || orderBy.isEmpty());
	}

	/**
	 * Specify that results must be ordered by the passed column Null by
	 * default. 預設為升羃排序
	 * 
	 * @param orderBy
	 *            the order by
	 * @return SearchSetting
	 */
	public AbstractSearchSetting addOrderBy(String orderBy) {
		if (this.orderBy == null) {
			this.orderBy = new LinkedHashMap<String, Boolean>();
		}
		this.orderBy.put(orderBy, false);
		return this;
	}

	/**
	 * Specify that results must be ordered by the passed column Null by
	 * default.
	 * 
	 * @param orderBy
	 *            orderBy
	 * @param orderDesc
	 *            是否要降羃排序
	 * @return SearchSetting
	 */
	public AbstractSearchSetting addOrderBy(String orderBy, boolean orderDesc) {
		if (this.orderBy == null) {
			this.orderBy = new LinkedHashMap<String, Boolean>();
		}
		this.orderBy.put(orderBy, orderDesc);
		return this;
	}

	public AbstractSearchSetting setOrderBy(Map<String, Boolean> orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public Map<String, Boolean> getOrderBy() {
		return this.orderBy;
	}

	// -----------------------------------
	// Pagination support
	// -----------------------------------
	// private int maxResultsLimit = 2000;
	private int maxResults = 100;

	/**
	 * 設定查詢的筆數
	 * 
	 * @param maxResults
	 *            查詢的筆數
	 * @return this
	 */
	public AbstractSearchSetting setMaxResults(int maxResults) {
		Assert.isTrue(maxResults > 0, "maxResults must be > 0");
		// this.maxResults = Math.min(maxResults, maxResultsLimit);
		this.maxResults = maxResults;
		return this;
	}

	public int getMaxResults() {
		return maxResults;
	}

	// the first result
	private int firstResult = 0;

	/**
	 * 設定查詢的頁碼
	 * 
	 * @param firstResult
	 *            查詢的頁碼
	 * @return this
	 */
	public AbstractSearchSetting setFirstResult(int firstResult) {
		Assert.isTrue(firstResult >= 0, "maxResults must be >= 0");
		this.firstResult = firstResult;
		return this;
	}

	public int getFirstResult() {
		return this.firstResult;
	}

	// -----------------------------------
	// Search mode support
	// -----------------------------------
	private List<SearchModeParameter> searchModeParameters = new ArrayList<SearchModeParameter>();

	public List<SearchModeParameter> getSearchModeParameters() {
		return this.searchModeParameters;
	}

	public AbstractSearchSetting addSearchModeParameters(SearchMode searchMode,
			Object key, Object value) {
		Assert.notNull(searchMode, "search mode must not be null");
		searchModeParameters
				.add(new SearchModeParameter(searchMode, key, value));
		return this;
	}

	public AbstractSearchSetting addSearchModeParameters(ISearch search) {
		this.searchModeParameters.addAll(search.getSearchModeParameters());
		return this;
	}

}
