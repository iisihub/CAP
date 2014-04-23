package com.iisigroup.cap.base.dao;

import java.util.Map;

import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.Page;

public interface UserDao extends IGenericDao<User> {
    User findByUserId(String userId);

    Page<Map<String, Object>> findPage(String userId, String userName,
            String[] roleOids, String[] status, int maxResults, int firstResult);

    Page<Map<String, Object>> findPageByRoleCode(String roleCode,
            int firstResult, int maxResults);

    Page<Map<String, Object>> findPageUnselectedByRoleCodeAndUnitNo(
            String rolCode, String unitNo, int firstResult, int maxResults);

}
