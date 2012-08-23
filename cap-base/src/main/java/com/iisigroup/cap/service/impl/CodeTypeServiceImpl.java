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
package com.iisigroup.cap.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.CodeTypeDao;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.service.CodeTypeService;

/**
 * <pre>
 * CodeType Service
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/28,rodeschen,new
 *          </ul>
 */
@Service
public class CodeTypeServiceImpl extends AbstractService implements CodeTypeService {

	@Autowired
	private CodeTypeDao dao;

	/*
	 * (non-Javadoc)
	 * @see com.bqd.mci.service.CodeTypeService#saveCodeType(com.bqd.mci.model.CodeType)
	 */
	@Override
	public void saveCodeType(CodeType codeType) {
		dao.save(codeType);

	}

	/*
	 * (non-Javadoc)
	 * @see com.bqd.mci.service.CodeTypeService#getCodeTypeByType(java.lang.String)
	 */
	@Override
	public List<CodeType> getCodeTypeByType(String type) {
		return dao.findByCodeType(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.service.CodeTypeService#getCodeTypeByTypeAndValue(java.lang.String, java.lang.String)
	 */
	@Override
	public CodeType getCodeTypeByCodeTypeAndValue(String type, String value) {
		return dao.getByCodeTypeAndValue(type, value);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bqd.mci.service.CodeTypeService#getPage(com.iisi.cap.response.CapGridResult)
	 */
	@Override
	public GridResult getPage(GridResult capGridresult) {
		return dao.findPage(capGridresult);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bqd.mci.service.CodeTypeService#queryCodeTypeByType(java.lang.String)
	 */
	@Override
	public Map<String, String> queryCodeTypeByType(String type) {
		List<CodeType> codeList = dao.findByCodeType(type);
		Map<String, String> m = new LinkedHashMap<String, String>();
		if(!codeList.isEmpty()){
			for(CodeType c:codeList){
				m.put(c.getCdeVal(), c.getCdeDesc());
			}
		}
		return m;
	}
	
	/*
	 * (non-Javadoc) 
	 * @see com.bqd.mci.service.CodeTypeService#queryCodeTypeByTypes(java.lang.String[])
	 */
	public Map<String, Map<String,String>> queryCodeTypeByTypes(String[] types) {
		List<CodeType> codes = dao.findByCodeType(types);
		Map<String,Map<String,String>> m = new LinkedHashMap<String, Map<String,String>>();
		if(!codes.isEmpty()){
			for(int i=0;i<types.length;i++){
				Map<String,String> map = new LinkedHashMap<String, String>();
				for (CodeType c : codes) {
					if(types[i].equals(c.getCdeType())){
						map.put(c.getCdeVal(), c.getCdeDesc());
						m.put(types[i], map);
					}
				}
			}
		}
		return m;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bqd.mci.service.CodeTypeService#getCodeTypeByTypes(java.lang.String[])
	 */
	@Override
	public Map<String, AjaxFormResult> getCodeTypeByTypes(String[] types) {
		List<CodeType> codes = dao.findByCodeType(types);
		Map<String, AjaxFormResult> m = new LinkedHashMap<String, AjaxFormResult>();
		for (CodeType c : codes) {
			String type = c.getCdeType();
			AjaxFormResult sm = m.get(type);
			if (sm == null) {
				sm = new AjaxFormResult();
			}
			sm.set(c.getCdeVal(), c.getCdeDesc());
			m.put(type, sm);
		}
		return m;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bqd.mci.service.CodeTypeService#getCodeTypeById(java.lang.String)
	 */
	@Override
	public CodeType getCodeTypeById(String oid) {
		return dao.find(oid);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.bqd.mci.service.CodeTypeService#deleteCodeTypeById(java.lang.String)
	 */
	@Override
	public void deleteCodeTypeById(String oid) {
		CodeType codeType = dao.find(oid);
		if (codeType != null) {
			dao.delete(codeType);
		}
	}


}
