/* 
 * ICommonService.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.db.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * CommonService
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public interface CommonService {

    <T> Page<T> findPage(Class<T> clazz, SearchSetting search);

    <T> List<T> list(Class<T> clazz);

    <T> T findById(Class<T> clazz, String id);

    <T> void save(T model);

    void save(List<?> models);

    <T> void delete(T model);

    void delete(List<?> models);

    Map findMapById(Class<? extends GenericBean> clazz, String id);
}
