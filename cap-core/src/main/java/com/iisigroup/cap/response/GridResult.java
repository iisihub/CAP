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

package com.iisigroup.cap.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.enums.IGridEnum;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * Grid Result
 * </pre>
 * 
 * @since 2010/11/25
 * @author iristu
 * @version <ul>
 *          <li>2010/11/25,iristu,new
 *          <li>2011/6/21,RodesChen,增加method 供 MGridHandler 使用
 *          <li>2011/11/1,rodeschen,from cap
 *          <li>2011/11/1,rodeschen,modify for criteria
 *          </ul>
 */
@SuppressWarnings("serial")
public class GridResult implements IResult {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private JSONObject resultMap;

	private List<? extends GenericBean> rowData;

	private String[] columns;

	private Map<String, IFormatter> dataReformatter;

	public GridResult() {
		resultMap = new JSONObject();
	}

	public GridResult(List<? extends GenericBean> rowData, int records) {
		this(rowData, records, null);
	}

	public GridResult(List<? extends GenericBean> rowData, int records, Map<String, IFormatter> dataReformatter) {
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
	public GridResult setPage(int page) {
		resultMap.put(IGridEnum.PAGE.getCode(), page);
		return this;
	}// ;

	/**
	 * 取得頁碼
	 * 
	 * @return 頁碼
	 */
	public int getPage() {
		return (Integer) resultMap.get(IGridEnum.PAGE.getCode());
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
	public GridResult setPageCount(int rowCount, int pageRows) {
		resultMap.put(IGridEnum.TOTAL.getCode(), rowCount / pageRows + (rowCount % pageRows > 0 ? 1 : 0));
		resultMap.put(IGridEnum.RECORDS.getCode(), rowCount);
		resultMap.put(IGridEnum.PAGEROWS.getCode(), pageRows);
		return this;
	}// ;

	/**
	 * 取得每頁筆數
	 * 
	 * @return 每頁筆數
	 */
	public int getPageRows() {
		return (Integer) resultMap.get(IGridEnum.PAGEROWS.getCode());
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
	public GridResult setRecords(int rowCount) {
		resultMap.put(IGridEnum.RECORDS.getCode(), rowCount);
		return this;
	}// ;

	/**
	 * <pre>
	 * 取得總筆數
	 * </pre>
	 * 
	 * @return 總筆數
	 */
	public Integer getRecords() {
		Object o = resultMap.get(IGridEnum.RECORDS.getCode());
		return o == null ? 0 : (Integer) o;
	}// ;

	/**
	 * <pre>
	 * 設定資料行
	 * </pre>
	 * 
	 * @param rowData
	 *            資料
	 * @return this
	 */
	public GridResult setRowData(List<? extends GenericBean> rowData) {
		this.rowData = rowData;
		return this;
	}

	@Override
	public String getResult() {
		resultMap.put(IGridEnum.PAGEROWS.getCode(), getRowDataToJSON());
		return resultMap.toString();
	}

	@Override
	public String getLogMessage() {
		StringBuffer b = new StringBuffer();
		b.append("page=").append(resultMap.get(IGridEnum.PAGE.getCode())).append(",pagerow=").append(resultMap.get(IGridEnum.PAGEROWS.getCode())).append(",rowData=")
				.append(resultMap.get(IGridEnum.PAGEROWS.getCode()));
		return b.toString();
	}

	@Override
	public void add(IResult result) {
		JSONObject json = JSONObject.fromObject(result);
		resultMap.putAll(json);
	}

	public GridResult addReformatData(String key, IFormatter formatter) throws CapException {
		if (dataReformatter == null) {
			dataReformatter = new HashMap<String, IFormatter>();
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

	public Map<String, IFormatter> getdataReformatter() {
		return this.dataReformatter;
	}

	private JSONArray getRowDataToJSON() {
		JSONArray rows = new JSONArray();
		Map<String, Object> row = new HashMap<String, Object>();
		if (rowData != null && !rowData.isEmpty()) {
			for (GenericBean data : rowData) {
				try {
					row.put(IGridEnum.CELL.getCode(), data.toJSONString(this.columns, dataReformatter));
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
	public void setDataReformatter(Map<String, IFormatter> dataReformatter) {
		this.dataReformatter = dataReformatter;
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
	public GridResult addOrderBy(String orderBy) {
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
	public GridResult addOrderBy(String orderBy, boolean orderDesc) {
		if (this.orderBy == null) {
			this.orderBy = new LinkedHashMap<String, Boolean>();
		}
		this.orderBy.put(orderBy, orderDesc);
		return this;
	}

	public GridResult setOrderBy(Map<String, Boolean> orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public Map<String, Boolean> getOrderBy() {
		return this.orderBy;
	}

}// ~
