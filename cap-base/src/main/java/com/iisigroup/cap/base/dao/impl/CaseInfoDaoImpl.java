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

package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import com.iisigroup.cap.base.dao.CapJpaDao;
import com.iisigroup.cap.base.dao.CaseInfoDao;
import com.iisigroup.cap.base.model.CaseInfo;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * Case info DAO Impl
 * </pre>
 * 
 * @since 2013/12/18
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/18,TimChiang,new
 *          </ul>
 */
//@Repository
public class CaseInfoDaoImpl extends CapJpaDao<CaseInfo> implements CaseInfoDao {

	@Override
	public CaseInfo findByCaseNo(String caseNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divCtItmNo", caseNo);
		return findUniqueOrNone(search);
	}
	
	@Override
	public List<CaseInfo> findCaseInfosByGrpUppId(String[] grpUppId) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "grpUppId", grpUppId);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("codeOrder");
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
