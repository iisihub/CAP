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

package com.iisigroup.cap.rule.dao;

import java.util.List;

import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.rule.model.CaseInfo;

/**
 * <pre>
 * Case info IDao
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface CaseInfoDao extends IGenericDao<CaseInfo> {

    /**
     * find by CaseInfo.
     * 
     * @param caseNo
     *            條件代碼
     * @return T
     */
    public CaseInfo findByCaseNo(String caseNo);

    /**
     * 查詢OID
     * 
     * @param oid
     *            OID
     * @return CaseInfo
     */
    public CaseInfo findByOid(String oid);

    /**
     * save list
     * 
     * @param caseInfoList
     */
    void saveCaseInfos(List<CaseInfo> caseInfoList);

    /**
     * save caseInfo
     * 
     * @param caseInfo
     */
    void saveCaseInfo(CaseInfo caseInfo);

    /**
     * 使用群組Id查詢資料
     * 
     * @param grpUppId
     * @return
     */
    List<CaseInfo> findCaseInfosByGrpUppId(String[] grpUppId);

    List<CaseInfo> findNoneDispatchCaseInfoOrderByCaseNo();

}
