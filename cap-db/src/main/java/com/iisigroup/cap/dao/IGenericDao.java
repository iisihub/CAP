/*
 *
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

/**
 * <p>
 * interface IGenericDao.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/7,iristu,new
 *          <li>2011/6/20,iristu,增加findPage
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 * @param <T>
 *            the model
 */
public interface IGenericDao<T> {

    void save(Object models);

    /**
     * Insert.
     * 
     * @param models
     *            the entity
     */
    void save(List<?> models);

    /**
     * Delete.
     * 
     * @param entity
     *            the entity
     */
    void delete(Object entity);

    void delete(List<?> entries);

    /**
     * Find.
     * 
     * @param pk
     *            the oid
     * 
     * @return the t
     */
    T find(Serializable pk);

    <S> List<S> find(Class<S> clazz, ISearch search);

    T find(T entity);

    T findUniqueOrNone(ISearch search);

    List<T> find(ISearch search);

    /**
     * Count.
     * 
     * @param search
     *            SearchSetting
     * @return the int
     */
    int count(ISearch search);

    Iterator<T> list(int first, int count);

    Page<T> findPage(ISearch search);

    <S> Page<S> findPage(Class<S> clazz, ISearch search);

    /**
     * create new search requirement
     * 
     * @return ISearch
     */
    ISearch createSearchTemplete();

    /**
     * flush
     */
    void flush();

    <S> S findById(Class<S> clazz, Serializable pk);

}
