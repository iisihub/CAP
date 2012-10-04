/* 
 * CapFunctionDaoImpl.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.acl.dao.impl;

import java.util.List;

import com.iisigroup.cap.acl.dao.CapFunctionDao;
import com.iisigroup.cap.acl.model.CapFunction;
import com.iisigroup.cap.base.dao.CapJpaDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.security.model.IRole;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/10/3
 * @author iristu
 * @version <ul>
 *          <li>2012/10/3,iristu,new
 *          </ul>
 */
public class CapFunctionDaoImpl extends CapJpaDao<CapFunction> implements
		CapFunctionDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.security.dao.IFunctionDao#getFunctionByURL(java.lang
	 * .String)
	 */
	@Override
	public CapFunction getFunctionByURL(String url) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "funcUrl", url);
		return findUniqueOrNone(search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.security.dao.IFunctionDao#getRoleByFunction(com.iisigroup
	 * .cap.security.model.IFunction)
	 */
	@Override
	public List<? extends IRole> getRoleByFunction(CapFunction function) {
		if (function != null) {
			return function.getFuncRoles();
		} else {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.security.dao.IFunctionDao#getFunctionByName(java.lang
	 * .String)
	 */
	@Override
	public CapFunction getFunctionByName(String functionName) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "funcId",
				functionName);
		return findUniqueOrNone(search);
	}

}
