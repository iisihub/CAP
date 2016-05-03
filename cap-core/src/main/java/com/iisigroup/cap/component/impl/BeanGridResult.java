/*_
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.component.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;

import com.iisigroup.cap.component.GridResult;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.constants.GridEnum;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.model.GenericBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <pre>
 * Grid Result
 * </pre>
 * 
 * @since 2010/11/25
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/11/25,iristu,new
 *          <li>2011/6/21,RodesChen,增加method 供 MGridHandler 使用
 *          <li>2011/11/1,rodeschen,from cap
 *          <li>2011/11/1,rodeschen,modify for criteria
 *          <li>2012/09/18,iristu,改implements IGridResult
 *          <li>2013/03/29,rodeschen,add extends AjaxFormResult
 *          </ul>
 */
@SuppressWarnings("serial")
public class BeanGridResult extends AjaxFormResult implements GridResult<BeanGridResult, GenericBean> {

    protected List<? extends GenericBean> rowData;

    protected String[] columns;

    protected Map<String, Formatter> dataReformatter;

    public BeanGridResult() {
        resultMap = new JSONObject();
    }

    public BeanGridResult(List<? extends GenericBean> rowData, int records) {
        this(rowData, records, null);
    }

    public BeanGridResult(List<? extends GenericBean> rowData, int records, Map<String, Formatter> dataReformatter) {
        resultMap = new JSONObject();
        setRowData(rowData);
        setRecords(records);
        setDataReformatter(dataReformatter);
    }

    /**
     * <pre>
     * 設定頁碼
     * </pre>
     * 
     * @param page
     *            頁碼
     * @return this
     */
    public BeanGridResult setPage(int page) {
        resultMap.put(GridEnum.PAGE.getCode(), page);
        return this;
    }

    /**
     * 取得頁碼
     * 
     * @return 頁碼
     */
    public int getPage() {
        return (Integer) resultMap.get(GridEnum.PAGE.getCode());
    }

    /**
     * <pre>
     * 設定總筆數、每頁筆數及計算總頁數
     * </pre>
     * 
     * @param rowCount
     *            總筆數
     * @param pageRows
     *            一頁筆數
     * @return this
     */
    public BeanGridResult setPageCount(int rowCount, int pageRows) {
        resultMap.put(GridEnum.TOTAL.getCode(), rowCount / pageRows + (rowCount % pageRows > 0 ? 1 : 0));
        resultMap.put(GridEnum.RECORDS.getCode(), rowCount);
        resultMap.put(GridEnum.PAGEROWS.getCode(), pageRows);
        return this;
    }

    /**
     * 取得每頁筆數
     * 
     * @return 每頁筆數
     */
    public int getPageRows() {
        return (Integer) resultMap.get(GridEnum.PAGEROWS.getCode());
    }

    /**
     * <pre>
     * 設定總筆數
     * </pre>
     * 
     * @param rowCount
     *            總筆數
     * @return this
     */
    public BeanGridResult setRecords(int rowCount) {
        resultMap.put(GridEnum.RECORDS.getCode(), rowCount);
        return this;
    }

    /**
     * <pre>
     * 取得總筆數
     * </pre>
     * 
     * @return 總筆數
     */
    public Integer getRecords() {
        Object o = resultMap.get(GridEnum.RECORDS.getCode());
        return o == null ? 0 : (Integer) o;
    }

    /**
     * <pre>
     * 設定資料行
     * </pre>
     * 
     * @param rowData
     *            資料
     * @return this
     */
    public BeanGridResult setRowData(List<? extends GenericBean> rowData) {
        this.rowData = rowData;
        return this;
    }

    @Override
    public String getResult() {
        resultMap.put(GridEnum.PAGEROWS.getCode(), getRowDataToJSON());
        return resultMap.toString();
    }

    @Override
    public String getLogMessage() {
        StringBuffer b = new StringBuffer();
        b.append("page=").append(resultMap.get(GridEnum.PAGE.getCode())).append(",pagerow=").append(resultMap.get(GridEnum.PAGEROWS.getCode())).append(",rowData=")
                .append(resultMap.get(GridEnum.PAGEROWS.getCode()));
        return b.toString();
    }

    @Override
    public void add(Result result) {
        JSONObject json = JSONObject.fromObject(result);
        resultMap.putAll(json);
    }

    public BeanGridResult addReformatData(String key, Formatter formatter) {
        if (dataReformatter == null) {
            dataReformatter = new HashMap<String, Formatter>();
        }
        dataReformatter.put(key, formatter);
        return this;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<? extends GenericBean> getRowData() {
        return this.rowData;
    }

    private JSONArray getRowDataToJSON() {
        JSONArray rows = new JSONArray();
        Map<String, Object> row = new HashMap<String, Object>();
        if (rowData != null && !rowData.isEmpty()) {
            for (GenericBean data : rowData) {
                try {
                    row.put(GridEnum.CELL.getCode(), data.toJSONString(this.columns, dataReformatter));
                } catch (CapException e) {
                    logger.error(e.getMessage(), e);
                }
                rows.add(row);
            }
        }
        return rows;
    }

    /**
     * set DataReformatter
     * 
     * @param dataReformatter
     *            Map<String, IFormatter>
     */
    public void setDataReformatter(Map<String, Formatter> dataReformatter) {
        this.dataReformatter = dataReformatter;
    }

    @Override
    public Map<String, Formatter> getDataReformatter() {
        return this.dataReformatter;
    }

    @Override
    public void respondResult(ServletResponse response) {
        new StringResponse(getContextType(), getEncoding(), getResult()).respond(response);
    }

}// ~
