package com.iisigroup.cap.base.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.RoleSetDao;
import com.iisigroup.cap.base.dao.UserDao;
import com.iisigroup.cap.base.dao.UserPwdHistoryDao;
import com.iisigroup.cap.base.model.RoleSet;
import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.base.model.UserPwdHistory;
import com.iisigroup.cap.base.service.UserSetService;
import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;

@Service
public class UserSetServiceImpl extends AbstractService implements UserSetService {
    @Resource
    private UserDao userDao;
    @Resource
    private ICommonDao commonDao;
    @Resource
    private UserPwdHistoryDao userPwdHistoryDao;
    @Resource
    private RoleSetDao roleSetDao;

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
            user.setPassword(hash(password.getBytes()));
        }
        user.setUpdateTime(CapDate.getCurrentTimestamp());
        user.setUpdater(CapSecurityContext.getUserId());
        return user;
    }

    private List<RoleSet> createUserRoleData(String userId, String[] roleOids) {
        List<RoleSet> rlSet = new ArrayList<RoleSet>();
        for(String roleOid : roleOids) {
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
    public void lockUserByOid(String oid) {
        User user = userDao.find(oid);
        user.setPreStatus(user.getStatus());
        user.setStatus("2");
        user.setUpdateTime(CapDate.getCurrentTimestamp());
        user.setUpdater(CapSecurityContext.getUserId());
        userDao.save(user);
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
            String password2, String ruleType, int minLen, int maxHistory) {
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
                if (hash(password.getBytes()).equalsIgnoreCase(
                        h.getPassword())) {
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
            return false;
        }
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        String userId = CapSecurityContext.getUserId();
        User user = userDao.findByUserId(userId);
        boolean tf = false;
        if (hash(password.getBytes()).equalsIgnoreCase(
                user.getPassword())) {
            tf = true;
        }
        return tf;
    }

    @Override
    public void changeUserPassword(String password) {
        String userId = CapSecurityContext.getUserId();
        User user = userDao.findByUserId(userId);
        String pwdHash = hash(password.getBytes());
        user.setPassword(pwdHash);
        userDao.save(user);
        // insert pwd history
        UserPwdHistory uph = new UserPwdHistory();
        uph.setUserOid(user.getOid());
        uph.setPassword(pwdHash);
        uph.setUpdateTime(CapDate.getCurrentTimestamp());
        userPwdHistoryDao.save(uph);
    }

    private String hash(byte[] data) {
        byte[] hash = null;
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("sha-256");
            md.update(data);
            hash = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return new String(Hex.encodeHex(hash));
    }
}
