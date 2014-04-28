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

package com.iisigroup.cap.auth.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.CodeItemDao;
import com.iisigroup.cap.auth.model.CodeItem;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.StringUtil;

/**
 * <pre>
 * DAO
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
@Repository
public class CodeItemDaoImpl extends GenericDao<CodeItem> implements
        CodeItemDao {

    private static final int NO_PARENT = -1;

    @Override
    public List<CodeItem> findAll(String system) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "sysTyp", system);
        search.addSearchModeParameters(SearchMode.EQUALS, "inputFlg", "1"); // 啟用
        search.addOrderBy("step");
        search.addOrderBy("parent");
        search.addOrderBy("seq");
        return find(search);
    }

    @Override
    public List<CodeItem> findBySystypAndStep(String systyp, String step) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "sysTyp", systyp);
        search.addSearchModeParameters(SearchMode.EQUALS, "step", step);
        return find(search);
    }

    @Override
    public Page<Map<String, Object>> findPageByRoleCode(String roleCode,
            int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", roleCode);
        return getNamedJdbcTemplate().queryForPage("roleSet_getFunc", param,
                firstResult, maxResults);
    }

    @Override
    public int deleteByRoleCodeAndPgmCodes(String rolCode, List<String> delFunc) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", rolCode);
        param.put("delFunc", delFunc);
        return getNamedJdbcTemplate().update("roleSet_deleteRlf", param);
    }

    @Override
    public Page<Map<String, Object>> findPageUnselected(String rolCode,
            String systyp, String pgmTyp, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", rolCode);
        param.put("pgmTyp", pgmTyp);
        param.put("sysTyp", systyp);
        return getNamedJdbcTemplate().queryForPage("roleSet_getEditFunc",
                param, firstResult, maxResults);
    }

    @Override
    public CodeItem getCodeItemByCodeAndSysType(int code, String sysType) {
        return getCodeItemsBySysType(sysType).get(code);
    }

    @Override
    public List<CodeItem> findByParentAndSteps(String pgmDept,
            Set<String> roles, int parent, String sysType, int... steps) {

        Set<Integer> pSet = new HashSet<Integer>();
        pSet.add(parent);

        Set<CodeItem> set = new HashSet<CodeItem>();
        if (roles == null) {
            roles = Collections.emptySet();
        }
        Arrays.sort(steps);

        for (String role : roles) {
            for (int step : steps) {
                String key = getRoleStepKey(role, step);
                List<CodeItem> stepCodes = getRoleStepCodeItemsBySysType(
                        sysType).get(key);

                if (stepCodes == null) {
                    continue;
                } else if (parent == NO_PARENT) {
                    set.addAll(stepCodes);
                    for (CodeItem code : stepCodes) {
                        pSet.add(code.getCode());

                    }
                } else {
                    for (CodeItem code : stepCodes) {
                        if (pSet.contains(code.getParent())) {
                            set.add(code);
                            pSet.add(code.getCode());
                        }
                    }
                }
            }
        }
        return Arrays.asList(set.toArray(new CodeItem[set.size()]));
    }

    @Override
    public List<CodeItem> findByStep(Set<String> roles, String sysType,
            int... step) {
        return findByParentAndSteps(roles, NO_PARENT, sysType, step);
    }

    @Override
    public List<CodeItem> findBySysTypeAndParent(Set<String> roles, int parent,
            String sysType) {
        int step = getCodeItemsBySysType(sysType).get(parent).getStep() + 1;
        return findByParentAndSteps(roles, parent, sysType, new int[] { step });
    }

    @Override
    public List<CodeItem> findByParentAndSteps(Set<String> roles, int parent,
            String sysType, int... steps) {
        Set<Integer> pSet = new HashSet<Integer>();
        pSet.add(parent);
        Set<CodeItem> set = new HashSet<CodeItem>();
        if (roles == null) {
            roles = Collections.emptySet();
        }
        Arrays.sort(steps);
        for (String role : roles) {
            for (int step : steps) {
                String key = getRoleStepKey(role, step);
                List<CodeItem> stepCodes = getRoleStepCodeItemsBySysType(
                        sysType).get(key);

                if (stepCodes == null) {
                    continue;
                } else if (parent == NO_PARENT) {
                    set.addAll(stepCodes);
                    for (CodeItem code : stepCodes) {
                        pSet.add(code.getCode());
                    }
                } else {
                    for (CodeItem code : stepCodes) {
                        if (pSet.contains(code.getParent())) {
                            set.add(code);
                            pSet.add(code.getCode());
                        }
                    }
                }
            }
        }
        return Arrays.asList(set.toArray(new CodeItem[set.size()]));
    }

    private String getRoleStepKey(String role, int step) {
        return role + "_" + step;
    }

    private Map<Integer, CodeItem> getCodeItemsBySysType(String sysType) {
        Map<Integer, CodeItem> result = new HashMap<Integer, CodeItem>();
        List<CodeItem> list = findAll(sysType);
        for (CodeItem item : list) {
            result.put(item.getCode(), item);
        }
        return result;
    }

    private Map<String, List<CodeItem>> getRoleStepCodeItemsBySysType(
            String sysType) {
        Map<String, List<CodeItem>> roleStepCodes = new HashMap<String, List<CodeItem>>();
        final Map<String, Map<Integer, Integer>> roleAuthes = new ConcurrentHashMap<String, Map<Integer, Integer>>();
        Map<String, Set<Integer>> roleSteps = new ConcurrentHashMap<String, Set<Integer>>();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("system", sysType);

        getNamedJdbcTemplate().query("Role.auth", param,
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        String role = StringUtil.trim(rs.getString("ROLE"));
                        Map<Integer, Integer> authes = roleAuthes.get(role);
                        if (authes == null) {
                            authes = new HashMap<Integer, Integer>();
                            roleAuthes.put(role, authes);
                        }
                        authes.put(rs.getInt("AUTHCODE"), rs.getInt("AUTHCODE"));
                    }
                });

        for (Entry<String, Map<Integer, Integer>> entry : roleAuthes.entrySet()) {
            String role = entry.getKey();
            Set<Integer> steps = roleSteps.get(role);
            if (steps == null) {
                steps = new HashSet<Integer>();
                roleSteps.get(steps);
            }
            for (Integer auth : entry.getValue().keySet()) {
                CodeItem code = getCodeItemsBySysType(sysType).get(auth);
                if (code == null)
                    continue;
                String key = getRoleStepKey(role, code.getStep());
                List<CodeItem> stepCodes = roleStepCodes.get(key);
                if (stepCodes == null) {
                    stepCodes = new LinkedList<CodeItem>();
                    roleStepCodes.put(key, stepCodes);
                }
                stepCodes.add(code);
                steps.add(code.getStep());
            }
            roleSteps.put(role, steps);
        }
        return roleStepCodes;
    }

}
