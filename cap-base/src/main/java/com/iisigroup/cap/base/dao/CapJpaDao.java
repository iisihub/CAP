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
import javax.persistence.PersistenceContext;

import com.iisigroup.cap.dao.impl.GenericDao;

/**<pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * @since  2012/9/19
 * @author iristu
 * @version <ul>
 *           <li>2012/9/19,iristu,new
 *          </ul>
 */
public class CapJpaDao<T> extends GenericDao<T> {
	
	@PersistenceContext(unitName = "pu-cap")
	protected EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
