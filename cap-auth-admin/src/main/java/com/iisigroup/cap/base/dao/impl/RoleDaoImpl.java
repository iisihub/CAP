/* 
 * RoleDaoImpl.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.RoleDao;
import com.iisigroup.cap.base.model.Role;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.security.dao.IRoleDao;

/**
 * <pre>
 * 使用者資訊Dao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
@Repository
public class RoleDaoImpl extends GenericDao<Role> implements IRoleDao<Role>,
        RoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findByUrl(String system, String url) {
        Query query = getEntityManager()
                .createNativeQuery(
                        "select rle.* from DEF_RLE rle inner join DEF_RLF rlf inner join DEF_PGM pgm on rlf.ROLCODE=rle.ROLCODE on rlf.PGMCODE=pgm.PGMCODE where rle.SYSTYP= ?1 and rle.STU='0' and pgm.PGMPATH= ?2",
                        Role.class);
        query.setParameter(1, system);
        query.setParameter(2, url);
        return (List<Role>) query.getResultList();
    }

    @Override
    public List<Role> findAll() {
        ISearch search = createSearchTemplete();
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("roleId");
        List<Role> list = find(search);
        return list;
    }

    @Override
    public Role findByRoleId(String roleId) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "roleId", roleId);
        return findUniqueOrNone(search);
    }

    @Override
    public List<Map<String, Object>> findAllWithSelectedByUserOid(String userOid) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userOid", userOid);
        return getNamedJdbcTemplate().query(
                "Role.findAllWithSelectedByUserOid", params);
    }

    @Override
    public int deleteByPgmCodeAndRoleCodes(String pgmCode, List<String> delRole) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pgmCode", pgmCode);
        param.put("delRole", delRole);
        return getNamedJdbcTemplate().update("pgmSet_deleteRlf", param);
    }

    @Override
    public Page<Map<String, Object>> findPageUnselectedBySysTypeAndPgmCode(
            String systyp, String pgmCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systyp", systyp);
        param.put("pgmCode", pgmCode);
        return getNamedJdbcTemplate().queryForPage("pgmSet_getEditRole", param,
                firstResult, maxResults);
    }

    @Override
    public Page<Map<String, Object>> findPageBySysTypeAndPgmCode(String systyp,
            String pgmCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systyp", systyp);
        param.put("pgmCode", pgmCode);
        return getNamedJdbcTemplate().queryForPage("pgmSet_role", param,
                firstResult, maxResults);
    }
}
