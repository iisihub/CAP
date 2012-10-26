/* 
 * ICommonDao.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.dao;

import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 *  Common Dao
 * </pre>
 * 
 * @since 2011/11/30
 * @author iristu
 * @version <ul>
 *          <li>2011/11/30,iristu,new
 *          </ul>
 */
public interface ICommonDao extends IGenericDao<IDataObject> {

	<T> Page<T> findPage(Class<T> clazz, ISearch search);

	<T> T findById(Class<T> clazz, String id);

}
