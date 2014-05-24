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

import java.sql.Timestamp;
import java.util.List;

import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * 提醒通知Dao
 * </pre>
 * 
 * @since 2014/1/27
 * @author tammy
 * @version <ul>
 *          <li>2014/1/27,tammy,new
 *          </ul>
 */
public interface RemindDao extends IGenericDao<Remind> {

	public Remind findByPid(String pid);

	/**
	 * @param userId
	 *            登入者ID
	 * @param start
	 *            Timestamp
	 * @param end
	 *            Timestamp
	 * @param locale
	 *            語系
	 * @return
	 */
	public List<Remind> getCalendarData(String userId,
			Timestamp start, Timestamp end, String locale);

}
