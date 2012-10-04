/* 
 * AccessControlServiceImpl.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.acl.service.impl;

import java.util.List;

import com.iisigroup.cap.acl.dao.CapFunctionDao;
import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.service.ISecurityService;

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
public class AccessControlServiceImpl implements ISecurityService {

	CapFunctionDao funcDao;

	public void setFuncDao(CapFunctionDao funcDao) {
		this.funcDao = funcDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.security.service.ISecurityService#getAuthRolesByUrl
	 * (java.lang.String)
	 */
	@Override
	public List<? extends IRole> getAuthRolesByUrl(String url) {
		return funcDao.getRoleByFunction(funcDao.getFunctionByURL(url));
	}
}
