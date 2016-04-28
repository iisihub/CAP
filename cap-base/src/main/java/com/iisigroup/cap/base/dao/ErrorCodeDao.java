/* 
 * ErrorCodeDao.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.ErrorCode;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * 訊息代碼Dao
 * </pre>
 * 
 * @since 2011/08/02
 * @author UFO
 * @version
 *          <ul>
 *          <li>2011/08/02,UFO,new
 *          </ul>
 */
public interface ErrorCodeDao extends IGenericDao<ErrorCode> {

    List<ErrorCode> findByAll();

    ErrorCode findByCode(String code, String locale);

    List<ErrorCode> findListBySysId(String sysId, String locale);

}
