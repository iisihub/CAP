/* 
 * CommonServiceImpl.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.db.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.db.dao.CommonDao;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.db.service.CommonService;
import com.iisigroup.cap.db.utils.CapEntityUtil;
import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.utils.CapBeanUtil;

/**
 * <pre>
 * Common Service
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonDao commonDao;

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.service.ICommonService#findPage(java.lang.Class, com.iisigroup.cap.dao.utils.ISearch)
     */
    @Override
    public <T> Page<T> findPage(Class<T> clazz, SearchSetting search) {
        return commonDao.findPage(clazz, search);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.service.ICommonService#findById(java.lang.Class, java.lang.String)
     */
    @Override
    public <T> T findById(Class<T> clazz, String id) {
        return (T) commonDao.findById(clazz, id);
    }

    @Override
    public <T> void save(T model) {
        commonDao.save(model);
    }

    @Override
    public void save(List<?> models) {
        commonDao.save(models);
    }

    @Override
    public <T> void delete(T model) {
        commonDao.delete(model);
    }

    @Override
    public void delete(List<?> models) {
        commonDao.delete(models);
    }

    @Override
    public <T> List<T> list(Class<T> clazz) {
        return commonDao.find(clazz, commonDao.createSearchTemplete());
    }

    @Override
    public Map findMapById(Class<? extends GenericBean> clazz, String id) {
        GenericBean bean = this.findById(clazz, id);
        return CapBeanUtil.bean2Map(bean, CapEntityUtil.getColumnName(bean));
    }
}
