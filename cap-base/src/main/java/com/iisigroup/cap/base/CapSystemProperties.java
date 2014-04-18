/* 
 * SystemProperties.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * JSP bean, let jsp show what system properties is.
 * add SysParm information into this.
 * 順序是 System properties -> SysParm
 * </pre>
 * 
 * @since 2013/11/6
 * @author Sunkist Wang
 * @version <ul>
 *          <li>2013/11/6,Sunkist Wang,new
 *          <li>2014/1/17,Sunkist Wang,update
 *          <li>2014/4/18,Sunkist Wang,update get commonSrv
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapSystemProperties extends HashMap<String, String> {

	private List<String> ignoreCache;

	@Resource
	private ICommonService commonSrv;

	@Override
	public String get(Object key) {

		if (super.get(key) != null && (ignoreCache == null || !ignoreCache.contains(key))) {
			return super.get(key);
		}

		String sKey = key != null ? key.toString() : null;
		if (CapString.isEmpty(sKey)) {
			return null;
		}

		String val = null;
		val = System.getProperty(sKey);

		if (!CapString.isEmpty(val)) {
			put(sKey, val);
			return val;
		}

		SysParm sysParm = commonSrv.findById(SysParm.class, sKey);
		val = sysParm != null ? sysParm.getParmValue() : null;
		put(sKey, val);
		return val;
	}

	public void setIgnoreCache(List<String> ignoreCache) {
		this.ignoreCache = ignoreCache;
	}
}
