/* 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.service;

import java.util.Map;

import com.iisigroup.cap.base.model.DivCtItm;
import com.iisigroup.cap.response.AjaxFormResult;

/**
 * <pre>
 * Division Condition Item Maintain Dao Service
 * </pre>
 * 
 * @since 2013/12/16
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/16,TimChiang,new
 *          </ul>
 */
public interface ConditionMntService {

	/**
	 * save DivCtItm
	 * 
	 * @param ftItm
	 *            DivCtItm
	 */
	void saveDivCtItm(DivCtItm ftItm);

	/**
	 * 查詢因子項目
	 * @param divCtItmNo 因子代碼
	 * @return DivCtItm
	 */
	DivCtItm findByDivCtItmNo(String divCtItmNo);
	
	/**
	 * get Map by ctItmNos
	 * 
	 * @param ctItmNos
	 *            代碼s
	 * @return Map
	 * 
	 */
	Map<String, String> findByDivCtItmNos(String[] ctItmNos);

	/**
	 * get divCtItm by numbers
	 * 
	 * @param nos
	 *            numbers
	 * @return Map<String, Map<String,String>>
	 */
	Map<String, Map<String, String>> findMapByCtItmNos(String[] nos);

	/**
	 * get divCtItm by numbers
	 * 
	 * @param numbers
	 *            type nos
	 * @return Map<String, CapAjaxFormResult>
	 */
	Map<String, AjaxFormResult> getDivCtItmsByNos(String[] nos);


	/**
	 * get DivCtItm by ftCtmNo
	 * 
	 * @param ftCtmNo
	 *            ftCtmNo
	 * @return DivCtItm
	 */
	DivCtItm getByCtItmNo(String ftCtmNo);

	/**
	 * get DivCtItm by oid
	 * 
	 * @param oid
	 *            oid
	 * 
	 * @return DivCtItm
	 */
	DivCtItm getById(String oid);

	/**
	 * delete DivCtItm By Oid
	 * 
	 * @param oid
	 *            oid
	 */
	void deleteById(String oid);

}
