package com.iisigroup.cap.base.service;

import java.util.Map;

import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.model.Page;

public interface UserSetService {
    void deleteUserByOid(String oid);

    void createUser(String userId, String userName, String password,
            String email, String[] roleOids);

    void updateUserByOid(String oid, String userId, String userName,
            boolean reset, String password, String email, String[] roleOids);

    void deleteUserRoleByUserOid(String userOid);

    Page<Map<String, Object>> findUser(String userId, String userName,
            String[] roleOids, String[] status, int maxResult, int firstResult);

    User findUserByUserId(String userId);

    void lockUserByOid(String oid);

    void unlockUserByOid(String oid);

    boolean checkPasswordRule(String userId, String password, String password2,
            String ruleType, int minLen, int maxHistory);

    boolean validatePassword(String password);

    void changeUserPassword(String password);

}
