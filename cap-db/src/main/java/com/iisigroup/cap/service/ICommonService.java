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
package com.iisigroup.cap.service;

import java.util.List;

import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

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
public interface ICommonService {

    <T> Page<T> findPage(Class<T> clazz, ISearch search);

    <T> List<T> list(Class<T> clazz);

    <T> T findById(Class<T> clazz, String id);

    <T> void save(T model);

    void save(List<?> models);

    <T> void delete(T model);

    void delete(List<?> models);

}
