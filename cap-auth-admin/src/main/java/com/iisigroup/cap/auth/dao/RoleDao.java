package com.iisigroup.cap.auth.dao;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.auth.model.DefaultRole;
import com.iisigroup.cap.db.dao.GenericDao;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.security.model.Role;

public interface RoleDao extends GenericDao<DefaultRole> {
    List<DefaultRole> findAll();

    DefaultRole findByCode(String code);

    List<Map<String, Object>> findAllWithSelectedByUserCode(String userCode);

    Page<Map<String, Object>> findPageBySysTypeAndFuncCode(String sysType, String funcCode, int firstResult, int maxResults);

    Page<Map<String, Object>> findPageUnselectedBySysTypeAndFuncCode(String sysType, String funcCode, int firstResult, int maxResults);

    /**
     * findByUrl
     * 
     * @param system
     *            系統代碼
     * @param url
     *            系統代碼
     * @return List<IRole>
     */
    public List<Role> findBySysTypeAndPath(String system, String url);
}
