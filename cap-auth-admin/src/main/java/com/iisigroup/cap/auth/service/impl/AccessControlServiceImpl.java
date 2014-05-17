package com.iisigroup.cap.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.model.User;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.dao.IRoleDao;
import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.service.IAccessControlService;
import com.iisigroup.cap.utils.CapDate;

//@Service
public class AccessControlServiceImpl implements IAccessControlService {

    @Resource
    private IRoleDao<IRole> dao;

    @Resource
    private UserDao userDao;

    private String systemType;

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public AccessControlServiceImpl() {
        super();
    }

    @Override
    public List<IRole> getAuthRolesByUrl(String url) {
        // FIXME
        url = url.replaceAll("/page/", "");
        if (url.indexOf("_") > 0) {
            url = url.substring(0, url.lastIndexOf("_"));
        }
        return dao.findBySysTypeAndPath(systemType, url);
    }

    @Override
    public void lockUserByUserId(String userId) {
        User user = userDao.findByCode(userId);
        if (!"2".equals(user.getStatus())) {
            user.setPreStatus(user.getStatus());
            user.setStatus("2");
            user.setUpdateTime(CapDate.getCurrentTimestamp());
            user.setUpdater(CapSecurityContext.getUserId());
            userDao.save(user);
        }
    }

    @Override
    public void login(String userId) {
        User user = userDao.findByCode(userId);
        user.setLastLoginTime(CapDate.getCurrentTimestamp());
        userDao.save(user);
    }

}
