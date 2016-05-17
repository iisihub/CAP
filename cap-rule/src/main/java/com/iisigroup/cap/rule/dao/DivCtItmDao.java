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

import com.iisigroup.cap.db.dao.GenericDao;
import com.iisigroup.cap.rule.model.DivCtItm;

/**
 * <pre>
 * Division Condition Item IDao
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
public interface DivCtItmDao extends GenericDao<DivCtItm> {

    /**
     * find by DivCtItm.
     * 
     * @param divCtItmNo
     *            條件代碼
     * @return T
     */
    public DivCtItm findByDivCtItmNo(String divCtItmNo);

    /**
     * find by DivCtItm and inputFlag
     * 
     * @param divCtItmNo
     *            條件代碼
     * @param inputFlag
     *            是否啟用
     * @return T
     */
    public DivCtItm findByDivCtItmNoAndInputFlg(String divCtItmNo, String inputFlag);

    /**
     * find by DivCtNos.
     * 
     * @param divCtNos
     *            多個條件代碼
     * @return T List
     */
    public List<DivCtItm> findByDivCtItmNo(String[] divCtNos);

    /**
     * find by Division Rule Item Nos and inputFlag
     * 
     * @param divCtNos
     *            多個條件代碼
     * @param inputFlag
     *            是否啟用
     * @return DivCtItm
     */
    public List<DivCtItm> findByDivCtItmNoAndInputFlg(String[] divCtNos, String inputFlag);

    /**
     * 查詢OID
     * 
     * @param oid
     *            OID
     * @return DivCtItm
     */
    public DivCtItm findByOid(String oid);

}