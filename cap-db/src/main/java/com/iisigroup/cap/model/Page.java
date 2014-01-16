/* 
 * Page.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 頁資料
 * </pre>
 * 
 * @since 2011/6/20
 * @author iristu
 * @version <ul>
 *          <li>2011/6/20,iristu,new
 *          </ul>
 * @param <T>
 */
public class Page<T> {

	private final List<T> content = new ArrayList<T>();
	private final int totalRow;
	private final int pageSize;
	private final int pageNumber;

	/**
	 * 頁的資料
	 * 
	 * @param content
	 *            頁的資料
	 * @param totalRow
	 *            總筆數
	 * @param pageSize
	 *            頁的筆數
	 * @param pageNumber
	 *            第幾頁
	 */
	public Page(List<T> content, int totalRow, int pageSize, int pageNumber) {

		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}

		this.content.addAll(content);
		this.totalRow = totalRow;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	/**
	 * 頁的筆數
	 * 
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 第幾頁
	 * 
	 * @return int
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * 頁的資料
	 * 
	 * @return List<T>
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * 總筆數
	 * 
	 * @return int
	 */
	public int getTotalRow() {
		return totalRow;
	}

}
