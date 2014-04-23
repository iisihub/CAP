package com.iisigroup.cap.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.RoleSetDao;
import com.iisigroup.cap.base.model.RoleSet;
import com.iisigroup.cap.dao.impl.GenericDao;

@Repository
public class RoleSetDaoImpl extends GenericDao<RoleSet> implements RoleSetDao {

    @Override
    public int deleteByRoleCodeAndUserIds(String rolCode, List<String> delUsr) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", rolCode);
        param.put("delUsrs", delUsr);
        return getNamedJdbcTemplate().update("roleSet_deleteRlset", param);
    }
}
