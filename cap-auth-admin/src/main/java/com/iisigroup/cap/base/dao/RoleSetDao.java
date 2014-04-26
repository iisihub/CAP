package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.RoleSet;
import com.iisigroup.cap.dao.IGenericDao;

public interface RoleSetDao extends IGenericDao<RoleSet> {

    int deleteByRoleCodeAndUserIds(String rolCode, List<String> delUsr);

    RoleSet findByStaffpidAndRoleCode(String staffpid, String roleCode);

    void deleteByUserId(String userId);
}
