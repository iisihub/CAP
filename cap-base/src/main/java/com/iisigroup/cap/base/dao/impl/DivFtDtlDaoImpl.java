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
import com.iisigroup.cap.base.dao.DivFtDtlDao;
import com.iisigroup.cap.base.model.DivFtDtl;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * Division Fator Details DAO Impl
 * </pre>
 * 
 * @since 2013/12/19
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/19,TimChiang,new
 *          </ul>
 */
//@Repository
public class DivFtDtlDaoImpl extends CapJpaDao<DivFtDtl> implements DivFtDtlDao {

	@Override
	public DivFtDtl findByFactorNo(String factorNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", factorNo);
		return findUniqueOrNone(search);
	}

	@Override
	public List<DivFtDtl> findByFactorNos(String[] factorNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", factorNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("codeOrder");
		return find(search);
	}

	@Override
	public DivFtDtl findByOid(String oid) {
		return find(oid);
	}

	@Override
	public DivFtDtl findByFactorNoAndRangeNo(String factorNo, String rangeNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", factorNo);
		search.addSearchModeParameters(SearchMode.EQUALS, "rangeNo", rangeNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("rangeNo");
		return findUniqueOrNone(search);
	}

	@Override
	public List<DivFtDtl> findByFactorNoAndRangeNos(String factorNo, String[] rangeNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", factorNo);
		search.addSearchModeParameters(SearchMode.EQUALS, "rangeNo", rangeNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("rangeNo");
		return find(search);
	}
}
