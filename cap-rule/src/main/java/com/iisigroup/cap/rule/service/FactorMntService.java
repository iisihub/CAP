/* 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.rule.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;

/**
 * <pre>
 * Division Factor Item Maintain Dao Service
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface FactorMntService {

    /**
     * save DivFtItm
     * 
     * @param ftItm
     *            DivFtItm
     */
    void saveDivFtItm(DivFtItm ftItm);

    /**
     * 查詢因子項目
     * 
     * @param divFtItmNo
     *            因子代碼
     * @return DivFtItm
     */
    DivFtItm findByDivFtItmNo(String divFtItmNo);

    /**
     * get Map by ftItmNos
     * 
     * @param ftItmNos
     *            代碼s
     * @return Map
     * 
     */
    Map<String, String> findByDivFtItmNos(String[] ftItmNos);

    /**
     * get divFtItm by numbers
     * 
     * @param nos
     *            numbers
     * @return Map<String, Map<String,String>>
     */
    Map<String, Map<String, String>> findMapByFtItmNos(String[] nos);

    /**
     * get divFtItm by numbers
     * 
     * @param numbers
     *            type keys
     * @return Map<String, CapAjaxFormResult>
     */
    Map<String, AjaxFormResult> getDivFtItmByNos(String[] nos);

    /**
     * get DivFtItm by ftItmNo
     * 
     * @param ftItmNo
     *            ftItmNo
     * @return DivFtItm
     */
    DivFtItm getByFtItmNo(String ftItmNo);

    /**
     * get DivFtItm by oid
     * 
     * @param oid
     *            oid
     * 
     * @return DivFtItm
     */
    DivFtItm getById(String oid);

    /**
     * delete DivFtItm By Oid
     * 
     * @param oid
     *            oid
     */
    void deleteById(String oid);

    /**
     * 取得所有因子項目
     * 
     * @return List<DivFtItm>
     */
    List<DivFtItm> findAllDivFtItm();

    /**
     * 查詢Factor Detail Data
     * 
     * @param factorNo
     *            String
     * @param rangeNos
     *            String[]
     * @return
     */
    List<DivFtDtl> findByFactorNoAndRangeNos(String factorNo, String[] rangeNos);

    /**
     * 查詢Factor Detail Data
     * 
     * @param factorNo
     *            String
     * @param rangeNo
     *            String
     * @return
     */
    DivFtDtl findByFactorNoAndRangeNo(String factorNo, String rangeNos);

    void deleteFtDtlByList(List<DivFtDtl> list);

    void insertTestCaseInfoData();
}
