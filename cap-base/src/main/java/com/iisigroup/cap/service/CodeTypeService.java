/* 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;

/**
 * <pre>
 * CodeType Dao Service
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/28,rodeschen,new
 *          <li>2012/3/12,gabriellaLau,add queryCodeTypeByType
 *          </ul>
 */
public interface CodeTypeService {

	/**
	 * save CodeType
	 * 
	 * @param codeType
	 *            CodeType
	 */
	void saveCodeType(CodeType codeType);

	/**
	 * get CodeType by type
	 * 
	 * @param type
	 *            typeName
	 * @return List
	 */
	List<CodeType> getCodeTypeByType(String type);

	/**
	 * get codeType by type
	 * 
	 * @param type
	 *            type key
	 * @return Map<String, String>
	 */
	Map<String, String> queryCodeTypeByType(String type);
	
	/**
	 * get codeType by types
	 * @param types
	 * 		types
	 * @return
	 * 		Map<String, Map<String,String>>
	 */
	public Map<String, Map<String,String>> queryCodeTypeByTypes(String[] types);
	
	/**
	 * get codeType by types
	 * 
	 * @param types
	 *            type keys
	 * @return Map<String, CapAjaxFormResult>
	 */
	Map<String, AjaxFormResult> getCodeTypeByTypes(String[] types);

	/**
	 * get CodeType by type and value
	 * 
	 * @param type
	 *            typeName
	 * @param value
	 *            value
	 * @return CodeType
	 */
	CodeType getCodeTypeByCodeTypeAndValue(String type, String value);

	/**
	 * get CodeType by oid
	 * 
	 * @param oid
	 *            oid
	 * 
	 * @return CodeType
	 */
	CodeType getCodeTypeById(String oid);

	/**
	 * delete CodeType By Oid
	 * @param oid oid
	 */
	void deleteCodeTypeById(String oid);

	/**
	 * 取得Grid 所需資料
	 * 
	 * @param capGridresult
	 *            settings
	 * @return capGridResult
	 */
	GridResult getPage(GridResult capGridresult);
	
}
