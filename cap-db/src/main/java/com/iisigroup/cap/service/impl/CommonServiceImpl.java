/* 
 * CommonServiceImpl.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.service.impl;

import java.util.List;

import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.service.ICommonService;

/**
 * <pre>
 * Common Service
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public class CommonServiceImpl implements ICommonService {

	ICommonDao commonDao;

	public void setCommonDao(ICommonDao commonDao) {
		this.commonDao = commonDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.service.ICommonService#findPage(java.lang.Class,
	 * com.iisigroup.cap.dao.utils.ISearch)
	 */
	@Override
	public <T> Page<T> findPage(Class<T> clazz, ISearch search) {
		return commonDao.findPage(clazz, search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.service.ICommonService#findById(java.lang.Class,
	 * java.lang.String)
	 */
	@Override
	public <T> T findById(Class<T> clazz, String id) {
		return commonDao.findById(clazz, id);
	}

	@Override
	public <T> void save(T model) {
		commonDao.save(model);
	}

	@Override
	public void save(List<?> models) {
		commonDao.save(models);
	}

	@Override
	public <T> void delete(T model) {
		commonDao.delete(model);
	}

	@Override
	public void delete(List<?> models) {
		commonDao.delete(models);
	}

	@Override
	public <T> List<T> list(Class<T> clazz) {
		return commonDao.find(clazz, commonDao.createSearchTemplete());
	}

}
