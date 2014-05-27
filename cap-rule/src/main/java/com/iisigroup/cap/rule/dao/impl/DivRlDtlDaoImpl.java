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

import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.rule.dao.DivRlDtlDao;
import com.iisigroup.cap.rule.model.DivRlDtl;

/**
 * <pre>
 * Division Rule Details DAO Impl
 * </pre>
 * 
 * @since 2013/12/19
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/19,TimChiang,new
 *          </ul>
 */
@Repository
public class DivRlDtlDaoImpl extends GenericDao<DivRlDtl> implements DivRlDtlDao {

	@Override
	public DivRlDtl findByRuleNo(String divRlNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo", divRlNo);
		return findUniqueOrNone(search);
	}
	
	@Override
	public List<DivRlDtl> findRlDtlsByRlNoAndSort(String divRlNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo", divRlNo);
		search.addOrderBy("divRlSor");
		return find(search);
	}

	@Override
	public List<DivRlDtl> findByRuleNos(String[] divRlNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo", divRlNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("divRlSor");
		return find(search);
	}

	@Override
	public DivRlDtl findByOid(String oid) {
		return find(oid);
	}

}
