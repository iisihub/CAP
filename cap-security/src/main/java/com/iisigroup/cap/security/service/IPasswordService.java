package com.iisigroup.cap.security.service;

import java.util.Map;

public interface IPasswordService {
    boolean checkPasswordRule(String userId, String password, String password2);

    void changeUserPassword(String password);

    boolean validatePassword(String password);
    
    Map<String, String> getPassworPolicy();

    void lockUserByUserId(String userId);

}
