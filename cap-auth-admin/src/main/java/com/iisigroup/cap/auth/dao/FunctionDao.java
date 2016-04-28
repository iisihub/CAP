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

import com.iisigroup.cap.auth.model.Function;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * IDao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version
 *          <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
public interface FunctionDao extends IGenericDao<Function> {
    /**
     * find All
     * 
     * @param system
     *            系統代碼
     * @return List<CodeItem>
     */
    List<Function> findAll(String system);

    List<Function> findBySysTypeAndLevel(String sysType, String level);

    Page<Map<String, Object>> findPageByRoleCode(String roleCode, int firstResult, int maxResults);

    Page<Map<String, Object>> findPageUnselected(String roleCode, String sysType, String pgmTyp, int firstResult, int maxResults);

    /**
     * 依交易代碼取得CodeItem
     * 
     * @since 2011/05/31
     * @author Fantasy
     */
    Function findByCodeAndSysType(int code, String sysType);

    /**
     * findByParentAndSteps
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<Function> findByParentAndLevels(String pgmDept, Set<String> roles, int parent, String sysType, int... levels);

    /**
     * findByStep
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<Function> findByLevels(Set<String> roles, String sysType, int... levels);

    /**
     * findByParent
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<Function> findBySysTypeAndParent(Set<String> roles, int parent, String sysType);

    /**
     * findByParentAndSteps
     * 
     * @since 2011/05/10
     * @author Fantasy
     */
    List<Function> findByParentAndLevels(Set<String> roles, int parent, String sysType, int... levels);

    List<Function> findMenuDataByRoles(Set<String> roles, String sysType);

    Function findByCode(int code);

}
