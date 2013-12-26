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

import com.iisigroup.cap.base.model.DivFtDtl;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * Division Factor Details IDao
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface DivFtDtlDao extends IGenericDao<DivFtDtl> {

	/**
	 * find by factorNo.
	 * 
	 * @param factorNo
	 *            因子代號
	 * @return T
	 */
	public DivFtDtl findByFactorNo(String factor);

	/**
	 * find by factorNos.
	 * 
	 * @param factorNos
	 *            多個因子代號
	 * @return T List
	 */
	public List<DivFtDtl> findByFactorNos(String[] factorNos);

	/**
	 * 查詢OID
	 * 
	 * @param oid
	 *            OID
	 * @return DivFtItm
	 */
	public DivFtDtl findByOid(String oid);

	/**
	 * Factor Detail data
	 * @param factorNo String
	 * @param rangeNo String
	 * @return
	 */
	DivFtDtl findByFactorNoAndRangeNo(String factorNo, String rangeNos);
	
	/**
	 * Factor Detail data
	 * @param factorNo String
	 * @param rangeNos String[]
	 * @return
	 */
	List<DivFtDtl> findByFactorNoAndRangeNos(String factorNo, String[] rangeNos);

}
