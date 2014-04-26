package com.iisigroup.cap.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.iisigroup.cap.security.dao.IRoleDao;
import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.service.ISecurityService;

//@Service
public class AccessControlServiceImpl implements ISecurityService {

    @Resource
    private IRoleDao<IRole> dao;

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
        return dao.findByUrl(systemType, url);
    }
}
