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

import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.response.AjaxFormResult;

/**
 * <pre>
 * CodeType Dao Service
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/28,rodeschen,new
 *          <li>2013/4/10,rodeschen,增加預設語系
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
     * get Map by code type
     * 
     * @param codeType
     *            代碼類型
     * @param locale
     *            語系
     * @return Map
     * 
     */
    Map<String, String> findByCodeType(String codeType, String locale);

    /**
     * get Map by code type 語系預設使用
     * SimpleContextHolder.get(CapWebUtil.localeKey);
     * 
     * @param codeType
     *            代碼類型
     * @return Map
     * 
     */
    Map<String, String> findByCodeType(String codeType);

    /**
     * get codeType by types
     * 
     * @param types
     *            types
     * @param locale
     *            語系
     * @return Map<String, Map<String,String>>
     */
    Map<String, Map<String, String>> findByCodeTypes(String[] types, String locale);

    /**
     * get codeType by types
     * 
     * 語系預設使用 SimpleContextHolder.get(CapWebUtil.localeKey);
     * 
     * @param types
     *            types
     * @return Map<String, Map<String,String>>
     */
    Map<String, Map<String, String>> findByCodeTypes(String[] types);

    /**
     * get codeType by types
     * 
     * @param types
     *            type keys
     * @param locale
     *            語系
     * @return Map<String, CapAjaxFormResult>
     */
    Map<String, AjaxFormResult> getCodeTypeByTypes(String[] types, String locale);

    /**
     * get codeType by types
     * 
     * 語系預設使用 SimpleContextHolder.get(CapWebUtil.localeKey);
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
     * @return CodeType
     */
    CodeType getByCodeTypeAndValue(String type, String value, String locale);

    /**
     * get CodeType by type and value
     * 
     * 語系預設使用 SimpleContextHolder.get(CapWebUtil.localeKey);
     * 
     * @param type
     *            typeName
     * @return CodeType
     */
    CodeType getByCodeTypeAndValue(String type, String value);

    /**
     * get CodeType by oid
     * 
     * @param oid
     *            oid
     * 
     * @return CodeType
     */
    CodeType getById(String oid);

    /**
     * delete CodeType By Oid
     * 
     * @param oid
     *            oid
     */
    void deleteById(String oid);

}
