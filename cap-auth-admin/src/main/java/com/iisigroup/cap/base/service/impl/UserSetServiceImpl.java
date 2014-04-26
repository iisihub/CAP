package com.iisigroup.cap.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.CodeTypeDao;
import com.iisigroup.cap.base.dao.RoleSetDao;
import com.iisigroup.cap.base.dao.UserDao;
import com.iisigroup.cap.base.dao.UserPwdHistoryDao;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.model.RoleSet;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.base.model.UserPwdHistory;
import com.iisigroup.cap.base.service.UserSetService;
import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.SecConstants;
import com.iisigroup.cap.security.service.IPasswordService;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapWebUtil;

@Service
public class UserSetServiceImpl extends AbstractService implements
        UserSetService, IPasswordService {
    @Resource
    private UserDao userDao;
    @Resource
    private ICommonDao commonDao;
    @Resource
    private UserPwdHistoryDao userPwdHistoryDao;
    @Resource
    private RoleSetDao roleSetDao;
    @Resource
    private CodeTypeDao codeTypeDao;

    public void deleteUserByOid(String oid) {
        changeUserStatus(oid, "9");
    }

    public void createUser(String userId, String userName, String password,
            String email, String[] roleOids) {
        User user = new User();
        user.setStatus("1");
        user.setCreateTime(CapDate.getCurrentTimestamp());
        user.setCreator(CapSecurityContext.getUserId());
        user = setUserFields(user, userId, userName, password, email);
        user.setRlSet(createUserRoleData(userId, roleOids));
        userDao.save(user);
        createUserPwdHistory(user.getOid(), password);
    }

    public void updateUserByOid(String oid, String userId, String userName,
            boolean reset, String password, String email, String[] roleOids) {
        User user = userDao.find(oid);
        if (reset) {
            user.setStatus("1");
        }
        userDao.save(setUserFields(user, userId, userName, password, email));
        createUserRoleData(user.getOid(), roleOids);
        createUserPwdHistory(user.getOid(), password);
    }

    private User setUserFields(User user, String userId, String userName,
            String password, String email) {
        user.setUserId(userId);
        user.setUserName(userName);
        user.setEmail(email);
        if (!StringUtils.isBlank(password)) {
            user.setPassword(encodePassword(user.getUserId(), password));
        }
        user.setUpdateTime(CapDate.getCurrentTimestamp());
        user.setUpdater(CapSecurityContext.getUserId());
        return user;
    }

    private List<RoleSet> createUserRoleData(String userId, String[] roleOids) {
        List<RoleSet> rlSet = new ArrayList<RoleSet>();
        for (String roleOid : roleOids) {
            RoleSet roleSet = roleSetDao.findByStaffpidAndRoleCode(userId,
                    roleOid);
            if (roleSet == null) {
                roleSet = new RoleSet();
            }
            roleSet.setUserId(userId);
            roleSet.setRolCode(roleOid);
            roleSet.setUpdater(CapSecurityContext.getUserId());
            roleSet.setUpdateTime(CapDate.getCurrentTimestamp());
            rlSet.add(roleSet);
        }
        return rlSet;
    }

    private void createUserPwdHistory(String userOid, String password) {
        if (!StringUtils.isBlank(password)) {
            UserPwdHistory h = new UserPwdHistory();
            h.setUserOid(userOid);
            h.setPassword(password);
            h.setUpdateTime(CapDate.getCurrentTimestamp());
            userPwdHistoryDao.save(h);
        }
    }

    @Override
    public User findUserByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public Page<Map<String, Object>> findUser(String userId, String userName,
            String[] roleOids, String[] status, int maxResult, int firstResult) {
        return userDao.findPage(userId, userName, roleOids, status, maxResult,
                firstResult);
    }

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
    public void unlockUserByOid(String oid) {
        User user = userDao.find(oid);
        user.setStatus(user.getPreStatus());
        user.setUpdateTime(CapDate.getCurrentTimestamp());
        user.setUpdater(CapSecurityContext.getUserId());
        userDao.save(user);
    }

    private void changeUserStatus(String oid, String status) {
        User user = userDao.find(oid);
        user.setStatus(status);
        user.setUpdateTime(CapDate.getCurrentTimestamp());
        user.setUpdater(CapSecurityContext.getUserId());
        userDao.save(user);
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
        boolean tf = false;
        if (encodePassword(user.getUserId(), password).equalsIgnoreCase(
                user.getPassword())) {
            tf = true;
        }
        return tf;
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

    private String encodePassword(String userId, String password) {
        StandardPasswordEncoder spe = new StandardPasswordEncoder(userId);
        return spe.encode(password);
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
}
