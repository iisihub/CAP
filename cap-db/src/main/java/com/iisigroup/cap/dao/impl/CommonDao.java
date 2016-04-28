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

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * CommonDao
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 * @param <T>
 *            T extends IDataObject
 */
@Repository
public class CommonDao<T extends IDataObject> extends GenericDao<IDataObject> implements ICommonDao {
}
