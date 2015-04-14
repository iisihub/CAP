package com.iisigroup.cap.auth.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.RoleFunctionDao;
import com.iisigroup.cap.auth.model.RoleFunction;
import com.iisigroup.cap.dao.impl.GenericDao;

@Repository
public class RoleFunctionDaoImpl extends GenericDao<RoleFunction> implements RoleFunctionDao {
    @Override
    public int deleteByRoleCodeAndFuncCodes(String roleCode, List<String> delFunc) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        param.put("delFunc", delFunc);
        return getNamedJdbcTemplate().update("roleFunc_deleteRoleFunc", param);
    }

    @Override
    public int deleteByFuncCodeAndRoleCodes(String funcCode, List<String> delRole) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("funcCode", funcCode);
        param.put("delRole", delRole);
        return getNamedJdbcTemplate().update("roleFunc_deleteRoleFuncByFuncCodeAndRoleCodes", param);
    }// ;

}
