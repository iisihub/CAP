/* 
 * CommonDao.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.dao.impl;

import javax.persistence.EntityManager;

import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * CommonDao
 * </pre>
 * 
 * @param <T>
 *            T
 * 
 * @since 2012/9/21
 * @author iristu
 * @version <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public class CommonDao<T extends IDataObject> extends GenericDao<IDataObject>
		implements ICommonDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T findById(Class<T> clazz, String id) {
		return getEntityManager().find(clazz, id);
	}

}
