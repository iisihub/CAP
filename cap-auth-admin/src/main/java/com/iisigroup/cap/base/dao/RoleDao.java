package com.iisigroup.cap.base.dao;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.base.model.Role;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.Page;

public interface RoleDao extends IGenericDao<Role> {
    List<Role> findAll();

    Role findByRoleId(String roleId);

    List<Map<String, Object>> findAllWithSelectedByUserId(String userOid);

    Page<Map<String, Object>> findPageBySysTypeAndPgmCode(String systyp,
            String pgmCode, int firstResult, int maxResults);

    Page<Map<String, Object>> findPageUnselectedBySysTypeAndPgmCode(
            String systyp, String pgmCode, int firstResult, int maxResults);

    int deleteByPgmCodeAndRoleCodes(String pgmCode, List<String> delRole);
}
