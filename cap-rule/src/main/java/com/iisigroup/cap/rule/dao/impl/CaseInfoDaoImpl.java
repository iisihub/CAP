/*
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.rule.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.dao.impl.GenericDaoImpl;
import com.iisigroup.cap.rule.dao.CaseInfoDao;
import com.iisigroup.cap.rule.model.CaseInfo;

/**
 * <pre>
 * Case info DAO Impl
 * </pre>
 * 
 * @since 2013/12/18
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/18,TimChiang,new
 *          </ul>
 */
@Repository
public class CaseInfoDaoImpl extends GenericDaoImpl<CaseInfo> implements CaseInfoDao {

    @Override
    public CaseInfo findByCaseNo(String caseNo) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "divCtItmNo", caseNo);
        return findUniqueOrNone(search);
    }

    @Override
    public List<CaseInfo> findCaseInfosByGrpUppId(String[] grpUppId) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "grpUppId", grpUppId);
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("casNo");
        return find(search);
    }

    @Override
    public List<CaseInfo> findNoneDispatchCaseInfoOrderByCaseNo() {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.IS_NULL, "docStatus", true);
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("casNo");
        return find(search);
    }

    @Override
    public CaseInfo findByOid(String oid) {
        return find(oid);
    }

    @Override
    public void saveCaseInfos(List<CaseInfo> caseInfoList) {
        save(caseInfoList);
    }

    @Override
    public void saveCaseInfo(CaseInfo caseInfo) {
        save(caseInfo);
    }

}
