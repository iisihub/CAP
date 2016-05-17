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

import com.iisigroup.cap.auth.dao.PwdLogDao;
import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.dao.UserRoleDao;
import com.iisigroup.cap.auth.model.DefaultUser;
import com.iisigroup.cap.auth.model.PwdLog;
import com.iisigroup.cap.auth.model.UserRole;
import com.iisigroup.cap.auth.service.UserSetService;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.db.dao.CommonDao;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.constatns.SecConstants.PwdPloicyKeys;
import com.iisigroup.cap.utils.CapDate;

@Service
public class UserSetServiceImpl implements UserSetService {
    @Resource
    private UserDao userDao;
    @Resource
    private CommonDao commonDao;
    @Resource
    private PwdLogDao userPwdHistoryDao;
    @Resource
    private UserRoleDao roleSetDao;

    public void deleteUserByOids(String[] oids) {
        for (String oid : oids) {
            changeUserStatus(oid, "9");
        }
    }

    public void createUser(String userId, String userName, String password, String email, String[] roleOids) {
        DefaultUser user = new DefaultUser();
        user.setStatus("1");
        // 建立使用者時就塞 last login time，方便排程篩選資料
        user.setLastLoginTime(CapDate.getCurrentTimestamp());
        user.setCreateTime(CapDate.getCurrentTimestamp());
        user.setCreator(CapSecurityContext.getUserId());
        user = setUserFields(user, userId, userName, password, email);
        user.setUrList(createUserRoleData(userId, roleOids));
        userDao.save(user);
        createUserPwdHistory(user.getCode(), encodePassword(userId, password));
    }

    public void updateUserByOid(String oid, String code, String name, boolean reset, String password, String email, String[] roleCodes) {
        DefaultUser user = userDao.find(oid);
        if (reset) {
            user.setStatus("1");
        }
        user.setUrList(createUserRoleData(code, roleCodes));
        userDao.save(setUserFields(user, code, name, password, email));
        createUserPwdHistory(user.getCode(), encodePassword(code, password));
    }

    private DefaultUser setUserFields(DefaultUser user, String code, String name, String password, String email) {
        Date now = Calendar.getInstance().getTime();
        user.setCode(code);
        user.setName(name);
        user.setEmail(email);
        if (!StringUtils.isBlank(password)) {
            SysParm parmPwdExpiredDay = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_EXPIRED_DAY.toString().toLowerCase());
            int expiredDay = Integer.parseInt(parmPwdExpiredDay.getParmValue());
            user.setPwdExpiredTime(new Timestamp(CapDate.shiftDays(now, expiredDay).getTime()));
            user.setPassword(encodePassword(user.getCode(), password));
        }
        user.setUpdateTime(new Timestamp(now.getTime()));
        user.setUpdater(CapSecurityContext.getUserId());
        return user;
    }

    private List<UserRole> createUserRoleData(String userCode, String[] roleCodes) {
        roleSetDao.deleteByUserCode(userCode);
        List<UserRole> rlSet = new ArrayList<UserRole>();
        for (String roleCode : roleCodes) {
            UserRole userRole = roleSetDao.findByUserCodeAndRoleCode(userCode, roleCode);
            if (userRole == null) {
                userRole = new UserRole();
            }
            userRole.setUserCode(userCode);
            userRole.setRoleCode(roleCode);
            userRole.setUpdater(CapSecurityContext.getUserId());
            userRole.setUpdateTime(CapDate.getCurrentTimestamp());
            rlSet.add(userRole);
        }
        return rlSet;
    }

    private void createUserPwdHistory(String userCode, String encodedPassword) {
        if (!StringUtils.isBlank(encodedPassword)) {
            PwdLog h = new PwdLog();
            h.setUserCode(userCode);
            h.setPassword(encodedPassword);
            h.setUpdateTime(CapDate.getCurrentTimestamp());
            userPwdHistoryDao.save(h);
        }
    }

    @Override
    public DefaultUser findUserByUserCode(String code) {
        return userDao.findByCode(code);
    }

    @Override
    public Page<Map<String, Object>> findUser(String userId, String userName, String[] roleCodes, String[] status, int maxResult, int firstResult) {
        return userDao.findPage(userId, userName, roleCodes, status, maxResult, firstResult);
    }

    @Override
    public void unlockUserByOids(String[] oids) {
        for (String oid : oids) {
            DefaultUser user = userDao.find(oid);
            user.setStatus(user.getPreStatus());
            user.setUpdateTime(CapDate.getCurrentTimestamp());
            user.setUpdater(CapSecurityContext.getUserId());
            userDao.save(user);
        }
    }

    private void changeUserStatus(String oid, String status) {
        DefaultUser user = userDao.find(oid);
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
    public void lockUserByOids(String[] oids) {
        for (String oid : oids) {
            DefaultUser user = userDao.find(oid);
            if (!"2".equals(user.getStatus())) {
                user.setPreStatus(user.getStatus());
                user.setStatus("2");
                user.setUpdateTime(CapDate.getCurrentTimestamp());
                user.setUpdater(CapSecurityContext.getUserId());
                userDao.save(user);
            }
        }
    }

}
