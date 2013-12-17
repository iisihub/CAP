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

import com.iisigroup.cap.base.model.DivRlItm;
import com.iisigroup.cap.response.AjaxFormResult;

/**
 * <pre>
 * Division Rule Item Maintain Dao Service
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface RuleMntService {

	/**
	 * save DivRlItm
	 * 
	 * @param rlItm
	 *            DivRlItm
	 */
	void saveDivRlItm(DivRlItm ftItm);

	/**
	 * 查詢因子項目
	 * @param divRlItmNo 因子代碼
	 * @return DivRlItm
	 */
	DivRlItm findByDivRlItmNo(String divRlItmNo);
	
	/**
	 * get Map by ftItmNos
	 * 
	 * @param ftItmNos
	 *            代碼s
	 * @return Map
	 * 
	 */
	Map<String, String> findByDivRlItmNos(String[] ctItmNos);

	/**
	 * get divRlItm by numbers
	 * 
	 * @param nos
	 *            numbers
	 * @return Map<String, Map<String,String>>
	 */
	Map<String, Map<String, String>> findMapByRlItmNos(String[] nos);

	/**
	 * get divRlItm by types
	 * 
	 * @param numbers
	 *            type nos
	 * @return Map<String, CapAjaxFormResult>
	 */
	Map<String, AjaxFormResult> getDivRlItmsByNos(String[] nos);


	/**
	 * get DivRlItm by rlItmNo
	 * 
	 * @param rlItmNo
	 *            rlItmNo
	 * @return DivRlItm
	 */
	DivRlItm getByRlItmNo(String rlItmNo);

	/**
	 * get DivRlItm by oid
	 * 
	 * @param oid
	 *            oid
	 * 
	 * @return DivRlItm
	 */
	DivRlItm getById(String oid);

	/**
	 * delete DivRlItm By Oid
	 * 
	 * @param oid
	 *            oid
	 */
	void deleteById(String oid);

}
