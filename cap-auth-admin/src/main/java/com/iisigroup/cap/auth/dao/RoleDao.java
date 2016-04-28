package com.iisigroup.cap.auth.dao;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.dao.GenericDao;
import com.iisigroup.cap.model.Page;

public interface RoleDao extends GenericDao<Role> {
    List<Role> findAll();

    Role findByCode(String code);

    List<Map<String, Object>> findAllWithSelectedByUserCode(String userCode);

    Page<Map<String, Object>> findPageBySysTypeAndFuncCode(String sysType, String funcCode, int firstResult, int maxResults);

    Page<Map<String, Object>> findPageUnselectedBySysTypeAndFuncCode(String sysType, String funcCode, int firstResult, int maxResults);
}
