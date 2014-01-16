/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.CodeTypeDao;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapWebUtil;

/**
 * <pre>
 * CodeType Service
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/28,rodeschen,new
 *          <li>2013/4/10,rodeschen,增加預設語系
 *          </ul>
 */
@Service
public class CodeTypeServiceImpl extends AbstractService implements
		CodeTypeService {

	@Resource
	private CodeTypeDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bqd.mci.service.CodeTypeService#saveCodeType(com.bqd.mci.model.CodeType
	 * )
	 */
	@Override
	public void saveCodeType(CodeType codeType) {
		dao.save(codeType);
	}

	@Override
	public Map<String, String> findByCodeType(String codeType, String locale) {
		List<CodeType> codeList = dao.findByCodeType(codeType, locale);
		Map<String, String> m = new LinkedHashMap<String, String>();
		if (!codeList.isEmpty()) {
			for (CodeType c : codeList) {
				m.put(c.getCodeType(), c.getCodeDesc());
			}
		}
		return m;
	}

	@Override
	public Map<String, Map<String, String>> findByCodeTypes(String[] types,
			String locale) {
		List<CodeType> codes = dao.findByCodeType(types, locale);
		Map<String, Map<String, String>> m = new LinkedHashMap<String, Map<String, String>>();
		if (!codes.isEmpty()) {
			for (int i = 0; i < types.length; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				for (CodeType c : codes) {
					if (types[i].equals(c.getCodeType())) {
						map.put(c.getCodeValue(), c.getCodeDesc());
						m.put(types[i], map);
					}
				}
			}
		}
		return m;
	}

	@Override
	public Map<String, AjaxFormResult> getCodeTypeByTypes(String[] types,
			String locale) {
		List<CodeType> codes = dao.findByCodeType(types, locale);
		Map<String, AjaxFormResult> m = new LinkedHashMap<String, AjaxFormResult>();
		for (CodeType c : codes) {
			String type = c.getCodeType();
			AjaxFormResult sm = m.get(type);
			if (sm == null) {
				sm = new AjaxFormResult();
			}
			sm.set(c.getCodeValue(), c.getCodeDesc());
			m.put(type, sm);
		}
		return m;
	}

	@Override
	public CodeType getByCodeTypeAndValue(String type, String value,
			String locale) {
		return dao.findByCodeTypeAndCodeValue(type, value, locale);
	}

	@Override
	public CodeType getById(String oid) {
		return dao.find(oid);
	}

	@Override
	public void deleteById(String oid) {
		CodeType codeType = dao.find(oid);
		if (codeType != null) {
			dao.delete(codeType);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.base.service.CodeTypeService#findByCodeType(java.lang
	 * .String)
	 */
	@Override
	public Map<String, String> findByCodeType(String codeType) {
		return findByCodeType(codeType,
				SimpleContextHolder.get(CapWebUtil.localeKey).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.base.service.CodeTypeService#findByCodeTypes(java.lang
	 * .String[])
	 */
	@Override
	public Map<String, Map<String, String>> findByCodeTypes(String[] types) {
		return findByCodeTypes(types,
				SimpleContextHolder.get(CapWebUtil.localeKey).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.base.service.CodeTypeService#getCodeTypeByTypes(java
	 * .lang.String[])
	 */
	@Override
	public Map<String, AjaxFormResult> getCodeTypeByTypes(String[] types) {
		return getCodeTypeByTypes(types,
				SimpleContextHolder.get(CapWebUtil.localeKey).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.base.service.CodeTypeService#getByCodeTypeAndValue(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public CodeType getByCodeTypeAndValue(String type, String value) {
		return getByCodeTypeAndValue(type, value,
				SimpleContextHolder.get(CapWebUtil.localeKey).toString());
	}
}
