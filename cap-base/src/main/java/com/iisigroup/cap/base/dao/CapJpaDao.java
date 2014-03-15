/* 
 * CapJpaDao.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.dao;

import javax.persistence.EntityManager;

import com.iisigroup.cap.dao.impl.GenericDao;

/**
 * <pre>
 * CapJpaDao
 * </pre>
 * 
 * @since 2012/9/19
 * @author iristu
 * @version <ul>
 *          <li>2012/9/19,iristu,new
 *          </ul>
 * @param <T>
 *            bean
 */
public class CapJpaDao<T> extends GenericDao<T> {

	// @PersistenceContext(unitName = "pu-cap")
	private EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
