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

import com.iisigroup.cap.auth.dao.FunctionDao;
import com.iisigroup.cap.auth.model.Function;
import com.iisigroup.cap.auth.support.FunctionRowMapper;
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
public class FunctionDaoImpl extends GenericDao<Function> implements
        FunctionDao {

    private static final int NO_PARENT = -1;

    @Override
    public List<Function> findAll(String system) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "sysType", system);
        search.addSearchModeParameters(SearchMode.EQUALS, "status", "1"); // 啟用
        search.addOrderBy("level");
        search.addOrderBy("parent");
        search.addOrderBy("sequence");
        return find(search);
    }

    @Override
    public List<Function> findBySysTypeAndLevel(String sysType, String level) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "sysType", sysType);
        search.addSearchModeParameters(SearchMode.EQUALS, "level", level);
        return find(search);
    }// ;

    @Override
    public Page<Map<String, Object>> findPageByRoleCode(String roleCode,
            int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        return getNamedJdbcTemplate().queryForPage("function_getFuncByRoldCode", param,
                firstResult, maxResults);
    }// ;

    @Override
    public Page<Map<String, Object>> findPageUnselected(String roleCode,
            String sysType, String parent, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        param.put("parent", parent);
        param.put("sysType", sysType);
        return getNamedJdbcTemplate().queryForPage("function_getEditFuncByRole",
                param, firstResult, maxResults);
    }// ;

    @Override
    public Function findByCodeAndSysType(int code, String sysType) {
        return getFuncsBySysType(sysType).get(code);
    }

    @Override
    public List<Function> findByParentAndLevels(String pgmDept,
            Set<String> roles, int parent, String sysType, int... levels) {

        Set<Integer> pSet = new HashSet<Integer>();
        pSet.add(parent);

        Set<Function> set = new HashSet<Function>();
        if (roles == null) {
            roles = Collections.emptySet();
        }
        Arrays.sort(levels);

        for (String role : roles) {
            for (int step : levels) {
                String key = getRoleStepKey(role, step);
                List<Function> stepCodes = getRoleLevelFuncsBySysType(sysType)
                        .get(key);

                if (stepCodes == null) {
                    continue;
                } else if (parent == NO_PARENT) {
                    set.addAll(stepCodes);
                    for (Function code : stepCodes) {
                        pSet.add(code.getCode());

                    }
                } else {
                    for (Function code : stepCodes) {
                        if (pSet.contains(code.getParent())) {
                            set.add(code);
                            pSet.add(code.getCode());
                        }
                    }
                }
            }
        }
        return Arrays.asList(set.toArray(new Function[set.size()]));
    }

    @Override
    public List<Function> findByLevels(Set<String> roles, String sysType,
            int... levels) {
        return findByParentAndLevels(roles, NO_PARENT, sysType, levels);
    }

    @Override
    public List<Function> findBySysTypeAndParent(Set<String> roles, int parent,
            String sysType) {
        int level = getFuncsBySysType(sysType).get(parent).getLevel() + 1;
        return findByParentAndLevels(roles, parent, sysType,
                new int[] { level });
    }

    @Override
    public List<Function> findByParentAndLevels(Set<String> roles, int parent,
            String sysType, int... levels) {
        Set<Integer> pSet = new HashSet<Integer>();
        pSet.add(parent);
        Set<Function> set = new HashSet<Function>();
        if (roles == null) {
            roles = Collections.emptySet();
        }
        Arrays.sort(levels);
        for (String role : roles) {
            for (int step : levels) {
                String key = getRoleStepKey(role, step);
                List<Function> stepCodes = getRoleLevelFuncsBySysType(sysType)
                        .get(key);

                if (stepCodes == null) {
                    continue;
                } else if (parent == NO_PARENT) {
                    set.addAll(stepCodes);
                    for (Function code : stepCodes) {
                        pSet.add(code.getCode());
                    }
                } else {
                    for (Function code : stepCodes) {
                        if (pSet.contains(code.getParent())) {
                            set.add(code);
                            pSet.add(code.getCode());
                        }
                    }
                }
            }
        }
        return Arrays.asList(set.toArray(new Function[set.size()]));
    }

    private String getRoleStepKey(String role, int level) {
        return role + "_" + level;
    }

    private Map<Integer, Function> getFuncsBySysType(String sysType) {
        Map<Integer, Function> result = new HashMap<Integer, Function>();
        List<Function> list = findAll(sysType);
        for (Function item : list) {
            result.put(item.getCode(), item);
        }
        return result;
    }

    private Map<String, List<Function>> getRoleLevelFuncsBySysType(
            String sysType) {
        Map<String, List<Function>> roleLevelCodes = new HashMap<String, List<Function>>();
        final Map<String, Map<Integer, Integer>> roleAuthes = new ConcurrentHashMap<String, Map<Integer, Integer>>();
        Map<String, Set<Integer>> roleSteps = new ConcurrentHashMap<String, Set<Integer>>();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("sysType", sysType);

        getNamedJdbcTemplate().query("function_auth", param,
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
            Set<Integer> levels = roleSteps.get(role);
            if (levels == null) {
                levels = new HashSet<Integer>();
                roleSteps.get(levels);
            }
            for (Integer auth : entry.getValue().keySet()) {
                Function code = getFuncsBySysType(sysType).get(auth);
                if (code == null)
                    continue;
                String key = getRoleStepKey(role, code.getLevel());
                List<Function> stepCodes = roleLevelCodes.get(key);
                if (stepCodes == null) {
                    stepCodes = new LinkedList<Function>();
                    roleLevelCodes.put(key, stepCodes);
                }
                stepCodes.add(code);
                levels.add(code.getLevel());
            }
            roleSteps.put(role, levels);
        }
        return roleLevelCodes;
    }

    @Override
    public List<Function> findMenuDataByRoles(Set<String> roles,
            String systemType) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCodes", roles);
        param.put("sysType", systemType);
        return getNamedJdbcTemplate().query("function_findMenu", "", param,
                new FunctionRowMapper());
    }

    @Override
    public Function findByCode(int code) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
        return findUniqueOrNone(search);
    }// ;

}
