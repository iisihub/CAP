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
import com.iisigroup.cap.base.dao.DivRlItmDao;
import com.iisigroup.cap.base.model.DivRlItm;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * Division Rule Item DAO Impl
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
//@Repository
public class DivRlItmDaoImpl extends CapJpaDao<DivRlItm> implements DivRlItmDao {

	@Override
	public DivRlItm findByDivRlItmNo(String divRlItmNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlItmNo", divRlItmNo);
		return findUniqueOrNone(search);
	}

	@Override
	public DivRlItm findByDivRlItmNoAndInputFlg(String divRlItmNo, String inputFlag) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlItmNo", divRlItmNo);
		search.addSearchModeParameters(SearchMode.EQUALS, "inputFlag", inputFlag);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		return findUniqueOrNone(search);
	}

	@Override
	public List<DivRlItm> findByDivRlItmNo(String[] divRlItmNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlItmNo", divRlItmNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("codeOrder");
		return find(search);
	}

	@Override
	public List<DivRlItm> findByDivRlItmNoAndInputFlg(String[] divRlItmNos,
			String inputFlag) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlItmNo", divRlItmNos);
		search.addSearchModeParameters(SearchMode.EQUALS, "inputFlag", inputFlag);
		return find(search);
	}

	@Override
	public DivRlItm findByOid(String oid) {
		return find(oid);
	}

}
