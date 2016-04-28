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

package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.dao.GenericDao;

/**
 * <pre>
 * 代碼表IDao
 * </pre>
 * 
 * @since 2010/12/15
 * @author eugene
 * @version
 *          <ul>
 *          <li>2010/12/15,eugene,new
 *          </ul>
 */
public interface CodeTypeDao extends GenericDao<CodeType> {

    /**
     * find by codetype.
     * 
     * @param codetype
     *            代碼類型
     * @param locale
     *            語言別
     * @return T
     */
    List<CodeType> findByCodeType(String codetype, String locale);

    /**
     * find by CodeType and CodeValue
     * 
     * @param cType
     *            代碼類型
     * @param cValue
     *            代碼值
     * @param locale
     *            語言別
     * @return T
     */
    CodeType findByCodeTypeAndCodeValue(String cType, String cValue, String locale);

    /**
     * find by codetype.
     * 
     * @param codetypes
     *            多個代碼類型
     * @param locale
     *            語言別
     * @return T List
     */
    List<CodeType> findByCodeType(String[] codetypes, String locale);

    /**
     * find by code Desc
     * 
     * @param cType
     *            代碼類型
     * @param codeDesc
     *            代碼內容
     * @param locale
     *            語言別
     * @return CodeType
     */
    List<CodeType> findByCodeTypeAndCodeDesc(String cType, String codeDesc, String locale);

    /**
     * 查詢OID
     * 
     * @param oid
     *            OID
     * @return CodeType
     */
    CodeType findByOid(String oid);

}
