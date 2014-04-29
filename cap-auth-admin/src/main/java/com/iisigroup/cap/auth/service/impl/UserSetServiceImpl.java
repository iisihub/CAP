package com.iisigroup.cap.auth.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.RoleSetDao;
import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.dao.UserPwdHistoryDao;
import com.iisigroup.cap.auth.model.RoleSet;
import com.iisigroup.cap.auth.model.User;
import com.iisigroup.cap.auth.model.UserPwdHistory;
import com.iisigroup.cap.auth.service.UserSetService;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.SecConstants.PwdPloicyKeys;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapDate;

@Service
public class UserSetServiceImpl extends AbstractService implements
        UserSetService {
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
        createUserPwdHistory(user.getOid(), encodePassword(userId, password));
    }

    public void updateUserByOid(String oid, String userId, String userName,
            boolean reset, String password, String email, String[] roleOids) {
        User user = userDao.find(oid);
        if (reset) {
            user.setStatus("1");
        }
        user.setRlSet(createUserRoleData(userId, roleOids));
        userDao.save(setUserFields(user, userId, userName, password, email));
        createUserPwdHistory(user.getOid(), encodePassword(userId, password));
    }

    private User setUserFields(User user, String userId, String userName,
            String password, String email) {
        Date now = Calendar.getInstance().getTime();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setEmail(email);
        if (!StringUtils.isBlank(password)) {
            SysParm parmPwdExpiredDay = commonDao.findById(SysParm.class,
                    PwdPloicyKeys.PWD_EXPIRED_DAY.toString().toLowerCase());
            int expiredDay = Integer.parseInt(parmPwdExpiredDay.getParmValue());
            user.setPwdExpiredTime(new Timestamp(CapDate.shiftDays(now,
                    expiredDay).getTime()));
            user.setPassword(encodePassword(user.getUserId(), password));
        }
        user.setUpdateTime(new Timestamp(now.getTime()));
        user.setUpdater(CapSecurityContext.getUserId());
        return user;
    }

    private List<RoleSet> createUserRoleData(String userId, String[] roleOids) {
        roleSetDao.deleteByUserId(userId);
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

    private void createUserPwdHistory(String userOid, String encodedPassword) {
        if (!StringUtils.isBlank(encodedPassword)) {
            UserPwdHistory h = new UserPwdHistory();
            h.setUserOid(userOid);
            h.setPassword(encodedPassword);
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

    private String encodePassword(String userId, String password) {
        StandardPasswordEncoder spe = new StandardPasswordEncoder(userId);
        return spe.encode(password);
    }

    @Override
    public void lockUserByOid(String oid) {
        User user = userDao.find(oid);
        if (!"2".equals(user.getStatus())) {
            user.setPreStatus(user.getStatus());
            user.setStatus("2");
            user.setUpdateTime(CapDate.getCurrentTimestamp());
            user.setUpdater(CapSecurityContext.getUserId());
            userDao.save(user);
        }
    }

}
