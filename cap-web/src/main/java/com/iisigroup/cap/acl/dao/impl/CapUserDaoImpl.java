/* 
 * CapUserDaoImpl.java
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

import com.iisigroup.cap.acl.dao.CapUserDao;
import com.iisigroup.cap.acl.model.CapUser;
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
public class CapUserDaoImpl extends CapJpaDao<CapUser> implements CapUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.security.dao.IUserDao#getUserByLoginId(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public CapUser getUserByLoginId(String loginId, String unitNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "userId", loginId);
		return findUniqueOrNone(search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.security.dao.IUserDao#getRoleByUser(com.iisigroup.cap
	 * .security.model.IUser)
	 */
	@Override
	public List<? extends IRole> getRoleByUser(CapUser user) {
		return user.getUserRoles();
	}

}
