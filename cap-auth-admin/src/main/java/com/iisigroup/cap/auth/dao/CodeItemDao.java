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

package com.iisigroup.cap.auth.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iisigroup.cap.auth.model.CodeItem;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * IDao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
public interface CodeItemDao extends IGenericDao<CodeItem> {
    /**
     * find All
     * 
     * @param system
     *            系統代碼
     * @return List<CodeItem>
     */
    List<CodeItem> findAll(String system);

    List<CodeItem> findBySystypAndStep(String systyp, String step);

    Page<Map<String, Object>> findPageByRoleCode(String roleCode,
            int firstResult, int maxResults);

    int deleteByRoleCodeAndPgmCodes(String rolCode, List<String> delFunc);

    Page<Map<String, Object>> findPageUnselected(String rolCode, String systyp,
            String pgmTyp, int firstResult, int maxResults);

    /**
     * 依交易代碼取得CodeItem
     * 
     * @since 2011/05/31
     * @author Fantasy
     */
    CodeItem getCodeItemByCodeAndSysType(int code, String sysType);

    /**
     * findByParentAndSteps
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<CodeItem> findByParentAndSteps(String pgmDept, Set<String> roles,
            int parent, String sysType, int... steps);

    /**
     * findByStep
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<CodeItem> findByStep(Set<String> roles, String sysType, int... step);

    /**
     * findByParent
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<CodeItem> findBySysTypeAndParent(Set<String> roles, int parent,
            String sysType);

    /**
     * findByParentAndSteps
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<CodeItem> findByParentAndSteps(Set<String> roles, int parent,
            String sysType, int... steps);

}
