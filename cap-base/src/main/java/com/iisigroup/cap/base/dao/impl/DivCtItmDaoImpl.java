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
import com.iisigroup.cap.base.dao.DivCtItmDao;
import com.iisigroup.cap.base.model.DivCtItm;
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
public class DivCtItmDaoImpl extends CapJpaDao<DivCtItm> implements DivCtItmDao {

	@Override
	public DivCtItm findByDivCtItmNo(String divCtNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", divCtNo);
		return findUniqueOrNone(search);
	}

	@Override
	public DivCtItm findByDivCtItmNoAndInputFlg(String divCtNo, String inputFlag) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", divCtNo);
		search.addSearchModeParameters(SearchMode.EQUALS, "inputFlag", inputFlag);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		return findUniqueOrNone(search);
	}

	@Override
	public List<DivCtItm> findByDivCtItmNo(String[] divCtNos) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", divCtNos);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("codeOrder");
		return find(search);
	}

	@Override
	public List<DivCtItm> findByDivCtItmNoAndInputFlg(String[] divRlNos,
			String inputFlag) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo", divRlNos);
		search.addSearchModeParameters(SearchMode.EQUALS, "inputFlag", inputFlag);
		return find(search);
	}

	@Override
	public DivCtItm findByOid(String oid) {
		return find(oid);
	}

}
