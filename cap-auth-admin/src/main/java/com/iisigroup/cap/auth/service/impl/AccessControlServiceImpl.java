package com.iisigroup.cap.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.iisigroup.cap.auth.dao.RoleDao;
import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.model.DefaultUser;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.constants.CheckStatus;
import com.iisigroup.cap.security.filter.CaptchaCaptureFilter;
import com.iisigroup.cap.security.model.Role;
import com.iisigroup.cap.security.service.AccessControlService;
import com.iisigroup.cap.security.service.CheckCodeService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;

//@Service
public class AccessControlServiceImpl implements AccessControlService {

    @Resource
    private RoleDao dao;

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
    public List<Role> getAuthRolesByUrl(String url) {
        // FIXME
        url = url.replaceAll("/page/", "");
        if (url.indexOf("_") > 0) {
            url = url.substring(0, url.lastIndexOf("_"));
        }
        return dao.findBySysTypeAndPath(systemType, url);
    }

    @Override
    public void lockUserByUserId(String userId) {
        DefaultUser user = userDao.findByCode(userId);
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
        DefaultUser user = userDao.findByCode(userId);
        user.setLastLoginTime(CapDate.getCurrentTimestamp());
        userDao.save(user);
    }

    public boolean checkCaptcha() {
        String captchaData = ((CaptchaCaptureFilter) CapAppContext.getBean("captchaCaptureFilter")).getRequest().getParameter("captcha");
        CheckCodeService captcha = CapAppContext.getBean("capCaptcha");
        return CheckStatus.SUCCESS.equals(captcha.valid(captchaData));
    }

}
