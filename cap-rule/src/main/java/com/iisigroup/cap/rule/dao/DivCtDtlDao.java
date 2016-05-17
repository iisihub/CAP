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
import com.iisigroup.cap.rule.model.DivCtDtl;

/**
 * <pre>
 * Division Condition Details IDao
 * </pre>
 * 
 * @since 2013/12/20
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/20,TimChiang,new
 *          </ul>
 */
public interface DivCtDtlDao extends GenericDao<DivCtDtl> {

    /**
     * find by conditionNo.
     * 
     * @param conditionNo
     *            條件代號
     * @return T
     */
    public DivCtDtl findByConditionNo(String conditionNo);

    /**
     * find by conditionNo.
     * 
     * @param conditionNo
     *            多個條件代號
     * @return T List
     */
    public List<DivCtDtl> findByConditionNos(String[] conditionNos);

    /**
     * 查詢OID
     * 
     * @param oid
     *            OID
     * @return DivFtItm
     */
    public DivCtDtl findByOid(String oid);

    /**
     * 使用ConditionNo查詢Details，並且排序divCtSor
     * 
     * @param conditionNo
     *            String
     * @return
     */
    List<DivCtDtl> findCtDtlsByCtNoAndSort(String conditionNo);

}
