/* 
 * ErrorCodeDaoImpl.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.ErrorCodeDao;
import com.iisigroup.cap.base.model.ErrorCode;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * 訊息代碼Dao
 * </pre>
 * 
 * @since 2011/08/02
 * @author UFO
 * @version <ul>
 *          <li>2011/08/02,UFO,new
 *          </ul>
 */
@Repository
public class ErrorCodeDaoImpl extends GenericDao<ErrorCode> implements
		ErrorCodeDao {

	@Override
	public List<ErrorCode> findByAll() {
		ISearch search = createSearchTemplete();
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("code");
		return find(search);
	}

	@Override
	public ErrorCode findByCode(String code, String locale) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
		search.addSearchModeParameters(SearchMode.EQUALS, "locale", locale);
		return findUniqueOrNone(search);
	}

	@Override
	public List<ErrorCode> findListBySysId(String sysId, String locale) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "sysId", sysId);
		search.addSearchModeParameters(SearchMode.EQUALS, "locale", locale);
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		return find(search);
	}

}
