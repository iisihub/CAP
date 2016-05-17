/* 
 * RoleDaoImpl.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.auth.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.RoleDao;
import com.iisigroup.cap.auth.model.DefaultRole;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.dao.impl.GenericDaoImpl;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.security.model.Role;

/**
 * <pre>
 * 角色者資訊Dao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version
 *          <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
@Repository
public class RoleDaoImpl extends GenericDaoImpl<DefaultRole> implements RoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findBySysTypeAndPath(String sysType, String path) {
        Query query = getEntityManager().createNativeQuery(
                "select r.* from DEF_ROLE r inner join DEF_ROLEFUNC rf on rf.ROLECODE=r.CODE inner join DEF_FUNC func on rf.FUNCCODE=func.CODE where r.SYSTYPE= ?1 and r.STATUS='0' and func.PATH= ?2",
                DefaultRole.class);
        query.setParameter(1, sysType);
        query.setParameter(2, path);
        return (List<Role>) query.getResultList();
    }

    @Override
    public List<DefaultRole> findAll() {
        SearchSetting search = createSearchTemplete();
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("code");
        List<DefaultRole> list = find(search);
        return list;
    }

    @Override
    public DefaultRole findByCode(String code) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
        return findUniqueOrNone(search);
    }

    @Override
    public List<Map<String, Object>> findAllWithSelectedByUserCode(String userCode) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userCode", userCode);
        return getNamedJdbcTemplate().query("role_findAllWithSelectedByUserCode", params);
    }

    @Override
    public Page<Map<String, Object>> findPageUnselectedBySysTypeAndFuncCode(String sysType, String funcCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("sysType", sysType);
        param.put("funcCode", funcCode);
        return getNamedJdbcTemplate().queryForPage("role_findUnSelectedRoleByFuncCode", param, firstResult, maxResults);
    }

    @Override
    public Page<Map<String, Object>> findPageBySysTypeAndFuncCode(String sysType, String funcCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("sysType", sysType);
        param.put("funcCode", funcCode);
        return getNamedJdbcTemplate().queryForPage("role_findRoleByFuncCode", param, firstResult, maxResults);
    }
}
