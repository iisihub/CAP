/* 
 * RemindDao.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * 通知項目Dao
 * </pre>
 * 
 * @since 2014/1/27
 * @author tammy
 * @version <ul>
 *          <li>2014/1/27,tammy,new
 *          </ul>
 */
public interface RemindsDao extends IGenericDao<Reminds> {

    public List<Reminds> findCurrentRemindItem(String[] styleTyp, String locale);

    public void merge(Reminds entity);

}
