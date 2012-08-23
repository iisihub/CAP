/*
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.CodeTypeDao;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.dao.impl.GenericDao;

/**
 * <pre>
 * 代碥表DAO
 * </pre>
 * 
 * @since 2010/12/9
 * @author iristu
 * @version <ul>
 *          <li>2010/12/9,iristu,new
 *          <li>2011/11/20,RodesChen,from cap
 *          </ul>
 */
@Repository
public class CodeTypeDaoImpl extends GenericDao<CodeType> implements CodeTypeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.dao.CodeTypeDao#getByCodeTypeAndValue(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public CodeType getByCodeTypeAndValue(String codeType, String codeValue) {
		Criteria ca = getCriteria();
		ca.add(Restrictions.eq("cdeType", codeType));
		ca.add(Restrictions.eq("cdeVal", codeValue));
		ca.add(Restrictions.not(Restrictions.eq("cdeOrd", -1)));
		return (CodeType) ca.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.dao.CodeTypeDao#findByCodeType(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CodeType> findByCodeType(String codeType) {
		return ((List<CodeType>) getCriteria().add(Restrictions.eq("cdeType", codeType)).list());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.dao.CodeTypeDao#findByCodeType(java.lang.String[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CodeType> findByCodeType(String[] codeType) {
		return ((List<CodeType>) getCriteria().add(Restrictions.in("cdeType", codeType)).list());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.dao.CodeTypeDao#findByCodeVal(java.lang.String)
	 */
	public CodeType findByCodeVal(String codeVal) {
		return (CodeType) getCriteria().add(Restrictions.eq("cdeVal", codeVal)).add(Restrictions.eq("cdeType", "CITY_TYPE")).list().get(0);
	}

}
