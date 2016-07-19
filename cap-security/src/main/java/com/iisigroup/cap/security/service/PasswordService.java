package com.iisigroup.cap.security.service;

import java.util.Map;

public interface PasswordService {
    boolean checkPasswordRule(String userId, String password, String password2, boolean forcePwdChange);

    void changeUserPassword(String userId, String password);

    boolean validatePassword(String userId, String password);

    Map<String, String> getPasswordPolicy();

    int getPasswordChangeNotifyDay(String userId);

}
