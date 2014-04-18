package com.iisigroup.cap.base.dao;

import java.util.Map;

import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.Page;

public interface UserDao extends IGenericDao<User> {
    User findByUserId(String userId);

    Page<Map<String, Object>> find(String userId, String userName,
            String[] roleOids, String[] status, int maxResults, int firstResult);
}
