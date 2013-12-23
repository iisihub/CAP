/*_
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.DivRlDtl;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * Division Rule Details IDao
 * </pre>
 * 
 * @since 2013/12/20
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/20,TimChiang,new
 *          </ul>
 */
public interface DivRlDtlDao extends IGenericDao<DivRlDtl> {

	/**
	 * find by ruleNo.
	 * 
	 * @param ruleNo
	 *            規則代號
	 * @return T
	 */
	public DivRlDtl findByRuleNo(String ruleNo);

	/**
	 * find by ruleNos.
	 * 
	 * @param ruleNos
	 *            多個規則代號
	 * @return T List
	 */
	public List<DivRlDtl> findByRuleNos(String[] ruleNos);

	/**
	 * 查詢OID
	 * 
	 * @param oid
	 *            OID
	 * @return DivFtItm
	 */
	public DivRlDtl findByOid(String oid);

}
