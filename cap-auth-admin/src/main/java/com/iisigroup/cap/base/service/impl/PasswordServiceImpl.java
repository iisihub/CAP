package com.iisigroup.cap.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.CodeTypeDao;
import com.iisigroup.cap.base.dao.UserDao;
import com.iisigroup.cap.base.dao.UserPwdHistoryDao;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.base.model.UserPwdHistory;
import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.SecConstants;
import com.iisigroup.cap.security.service.IPasswordService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapWebUtil;

@Service
public class PasswordServiceImpl implements IPasswordService {

    @Resource
    private UserDao userDao;
    @Resource
    private ICommonDao commonDao;
    @Resource
    private UserPwdHistoryDao userPwdHistoryDao;
    @Resource
    private CodeTypeDao codeTypeDao;

    @Override
    public void lockUserByUserId(String userId) {
        User user = userDao.findByUserId(userId);
        if (!"2".equals(user.getStatus())) {
            user.setPreStatus(user.getStatus());
            user.setStatus("2");
            user.setUpdateTime(CapDate.getCurrentTimestamp());
            user.setUpdater(CapSecurityContext.getUserId());
            userDao.save(user);
        }
    }

    @Override
    public boolean checkPasswordRule(String userId, String password,
            String password2) {
        SysParm parmPwdRule = commonDao.findById(SysParm.class, "pwd_rule");
        SysParm parmPwdMinLen = commonDao.findById(SysParm.class,
                "pwd_min_length");
        SysParm parmPwdMaxHistory = commonDao.findById(SysParm.class,
                "pwd_max_history");
        int minLen = Integer.parseInt(parmPwdMinLen.getParmValue());
        int maxHistory = Integer.parseInt(parmPwdMaxHistory.getParmValue());
        String ruleType = parmPwdRule.getParmValue();
        CodeType rule = codeTypeDao.findByCodeTypeAndCodeValue("pwdrule",
                ruleType, SimpleContextHolder.get(CapWebUtil.localeKey)
                        .toString());
        if (StringUtils.isBlank(password) || StringUtils.isBlank(password2)) {
            throw new CapMessageException(CapAppContext.getMessage("error.001",
                    new Object[] {}), getClass());
        }
        if (!password.equals(password2) || password.length() < minLen) {
            throw new CapMessageException(CapAppContext.getMessage("error.002",
                    new Object[] { minLen }), getClass());
        }
        // pwd history validate
        if (userId != null) {
            User user = userDao.findByUserId(userId);
            List<UserPwdHistory> list = userPwdHistoryDao.findByUserOid(user
                    .getOid());
            int i = 0;
            for (UserPwdHistory h : list) {
                if (encodePassword(user.getUserId(), password)
                        .equalsIgnoreCase(h.getPassword())) {
                    throw new CapMessageException(CapAppContext.getMessage(
                            "error.003", new Object[] { maxHistory }),
                            getClass());
                }
                i++;
                if (i >= maxHistory) {
                    break;
                }
            }
        }
        String pattern = null;
        switch (Integer.parseInt(ruleType)) {
        case 1:
            pattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{" + minLen + ",}$";
            break;
        case 2:
            pattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&()_-])(?=\\S+$).{"
                    + minLen + ",}$";
            break;
        case 3:
            pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{" + minLen
                    + ",}$";
            break;
        case 4:
            pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&()_-])(?=\\S+$).{"
                    + minLen + ",}$";
            break;
        }
        if (pattern != null && !password.matches(pattern)) {
            throw new CapMessageException(CapAppContext.getMessage("error.008",
                    new Object[] { rule.getCodeDesc() }), getClass());
        }
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        String userId = CapSecurityContext.getUserId();
        User user = userDao.findByUserId(userId);
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder(userId);
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public void changeUserPassword(String password) {
        String userId = CapSecurityContext.getUserId();
        User user = userDao.findByUserId(userId);
        String pwdHash = encodePassword(user.getUserId(), password);
        user.setPassword(pwdHash);
        userDao.save(user);
        // insert pwd history
        UserPwdHistory uph = new UserPwdHistory();
        uph.setUserOid(user.getOid());
        uph.setPassword(pwdHash);
        uph.setUpdateTime(CapDate.getCurrentTimestamp());
        userPwdHistoryDao.save(uph);
    }

    @Override
    public Map<String, String> getPassworPolicy() {
        Map<String, String> result = new HashMap<String, String>();
        SysParm parmPwdRule = commonDao.findById(SysParm.class,
                SecConstants.PWD_RULE);
        SysParm parmPwdMinLen = commonDao.findById(SysParm.class,
                SecConstants.PWD_MIN_LENGTH);
        SysParm parmPwdMaxHistory = commonDao.findById(SysParm.class,
                SecConstants.PWD_MAX_HISTORY);
        SysParm pwdExpiredDay = commonDao.findById(SysParm.class,
                SecConstants.PWD_EXPIRED_DAY);
        SysParm pwdCaptchaEnable = commonDao.findById(SysParm.class,
                SecConstants.PWD_CAPTCHA_ENABLE);
        SysParm pwdAccountLock = commonDao.findById(SysParm.class,
                SecConstants.PWD_ACCOUNT_LOCK);
        SysParm pwdForceChangePwd = commonDao.findById(SysParm.class,
                SecConstants.PWD_FORCE_CHANGE_PWD);
        result.put(SecConstants.PWD_RULE, parmPwdRule.getParmValue());
        result.put(SecConstants.PWD_MIN_LENGTH, parmPwdMinLen.getParmValue());
        result.put(SecConstants.PWD_MAX_HISTORY,
                parmPwdMaxHistory.getParmValue());
        result.put(SecConstants.PWD_EXPIRED_DAY, pwdExpiredDay.getParmValue());
        result.put(SecConstants.PWD_CAPTCHA_ENABLE,
                pwdCaptchaEnable.getParmValue());
        result.put(SecConstants.PWD_ACCOUNT_LOCK, pwdAccountLock.getParmValue());
        result.put(SecConstants.PWD_FORCE_CHANGE_PWD,
                pwdForceChangePwd.getParmValue());
        return result;
    }

    private String encodePassword(String userId, String password) {
        StandardPasswordEncoder spe = new StandardPasswordEncoder(userId);
        return spe.encode(password);
    }

}
