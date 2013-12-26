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

import com.iisigroup.cap.base.dao.BaseDao;
import com.iisigroup.cap.base.dao.CodeItemDao;
import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * DAO
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
// @Repository
public class CodeItemDaoImpl extends BaseDao<CodeItem> implements CodeItemDao {

	@Override
	public List<CodeItem> findAll(String system) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "sysTyp", system);
		search.addSearchModeParameters(SearchMode.EQUALS, "inputFlg", "1"); //啟用
		search.addOrderBy("step");
		search.addOrderBy("parent");
		search.addOrderBy("seq");
		return find(search);
	}
}
