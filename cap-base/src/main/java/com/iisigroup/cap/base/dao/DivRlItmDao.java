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

import com.iisigroup.cap.base.model.DivRlItm;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * Division Rule Item IDao
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface DivRlItmDao extends IGenericDao<DivRlItm> {

	/**
	 * find by DivRlItm.
	 * 
	 * @param divRlItmNo
	 *            規則代號
	 * @return T
	 */
	public DivRlItm findByDivRlItmNo(String divRlItmNo);

	/**
	 * find by DivRlItm and inputFlag
	 * 
	 * @param divRlItmNo
	 *            規則代號
	 * @param inputFlag
	 *            是否啟用
	 * @return T
	 */
	public DivRlItm findByDivRlItmNoAndInputFlg(String divRlItmNo, String inputFlag);

	/**
	 * find by DivRlItmNos.
	 * 
	 * @param divRlItmNos
	 *            多個規則代號
	 * @return T List
	 */
	public List<DivRlItm> findByDivRlItmNo(String[] divRlItmNos);

	/**
	 * find by Division Rule Item Nos and inputFlag
	 * 
	 * @param divRlItmNos
	 *            多個規則代號
	 * @param inputFlag
	 *            是否啟用
	 * @return DivRlItm
	 */
	public List<DivRlItm> findByDivRlItmNoAndInputFlg(String[] divRlItmNos,
			String inputFlag);

	/**
	 * 查詢OID
	 * 
	 * @param oid
	 *            OID
	 * @return DivRlItm
	 */
	public DivRlItm findByOid(String oid);

}
