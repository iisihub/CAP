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

package com.iisigroup.cap.rule.dao;

import java.util.List;

import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.rule.model.DivFtItm;

/**
 * <pre>
 * Division Factor Item IDao
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface DivFtItmDao extends IGenericDao<DivFtItm> {

	/**
	 * find by DivFtItm.
	 * 
	 * @param divFtItmNo
	 *            因子代號
	 * @return T
	 */
	public DivFtItm findByDivFtItmNo(String divFtItmNo);

	/**
	 * find by factorNos.
	 * 
	 * @param factorNos
	 *            多個因子代號
	 * @return T List
	 */
	public List<DivFtItm> findByDivFtItmNo(String[] factorNos);


	/**
	 * 查詢OID
	 * 
	 * @param oid
	 *            OID
	 * @return DivFtItm
	 */
	public DivFtItm findByOid(String oid);

	/**
	 * 取得所有因子項目
	 * @return List<DivFtItm>
	 */
	List<DivFtItm> findAllFtItm();

}