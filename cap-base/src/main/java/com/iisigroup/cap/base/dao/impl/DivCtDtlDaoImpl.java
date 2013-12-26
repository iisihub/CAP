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
import com.iisigroup.cap.base.dao.DivCtDtlDao;
import com.iisigroup.cap.base.model.DivCtDtl;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * Division Condition Details DAO Impl
 * </pre>
 * 
 * @since 2013/12/19
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/19,TimChiang,new
 *          </ul>
 */
//@Repository
public class DivCtDtlDaoImpl extends CapJpaDao<DivCtDtl> implements DivCtDtlDao {

	@Override
	public DivCtDtl findByConditionNo(String conditionNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "conditionNo", conditionNo);
		return findUniqueOrNone(search);
	}

	@Override
	public List<DivCtDtl> findByConditionNos(String[] conditionNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "conditionNo", conditionNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("codeOrder");
		return find(search);
	}

	@Override
	public DivCtDtl findByOid(String oid) {
		return find(oid);
	}

}
