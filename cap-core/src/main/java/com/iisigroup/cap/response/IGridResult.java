/* 
 * IGridResult.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.response;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.formatter.IFormatter;

/**
 * <pre>
 * IGridResult for jqGird result
 * </pre>
 * 
 * @since 2011/10/27
 * @author iristu
 * @version <ul>
 *          <li>2011/10/27,iristu,new
 *          </ul>
 * @param <E>
 * @param <T>
 */
public interface IGridResult<T, E> extends IResult {

    /**
     * <pre>
     * 設定頁碼
     * </pre>
     * 
     * @param page
     *            頁碼
     * @return this
     */
    T setPage(int page);

    /**
     * <pre>
     * 設定總頁數
     * </pre>
     * 
     * @param rowCount
     *            總筆數
     * @param pageRows
     *            一頁筆數
     * @return this
     */
    T setPageCount(int rowCount, int pageRows);

    /**
     * <pre>
     * 設定總筆數
     * </pre>
     * 
     * @param rowCount
     *            總筆數
     * @return this
     */
    T setRecords(int rowCount);

    /**
     * <pre>
     * 取得總筆數
     * </pre>
     * 
     * @return 總筆數
     */
    Integer getRecords();

    /**
     * <pre>
     * 設定資料行
     * </pre>
     * 
     * @param rowData
     *            資料
     * @return this
     */
    T setRowData(List<? extends E> rowData);

    List<? extends E> getRowData();

    void setColumns(String[] columns);

    void setDataReformatter(Map<String, IFormatter> dataReformatter);

    Map<String, IFormatter> getDataReformatter();

}
