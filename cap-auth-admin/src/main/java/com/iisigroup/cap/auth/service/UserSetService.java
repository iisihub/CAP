package com.iisigroup.cap.auth.service;

import java.util.Map;

import com.iisigroup.cap.auth.model.User;
import com.iisigroup.cap.model.Page;

public interface UserSetService {
    void deleteUserByOids(String[] oids);

    void createUser(String userId, String userName, String password, String email, String[] roleOids);

    void updateUserByOid(String oid, String userId, String userName, boolean reset, String password, String email, String[] roleOids);

    Page<Map<String, Object>> findUser(String userId, String userName, String[] roleOids, String[] status, int maxResult, int firstResult);

    User findUserByUserCode(String userId);

    void unlockUserByOids(String[] oids);

    void lockUserByOids(String[] oids);

}
