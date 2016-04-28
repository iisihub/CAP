package com.iisigroup.cap.auth.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.DepartmentDao;
import com.iisigroup.cap.auth.dao.FunctionDao;
import com.iisigroup.cap.auth.dao.RoleDao;
import com.iisigroup.cap.auth.dao.RoleFunctionDao;
import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.dao.UserRoleDao;
import com.iisigroup.cap.auth.model.Department;
import com.iisigroup.cap.auth.model.Function;
import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.auth.service.RoleSetService;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.service.AbstractService;

/**
 * <pre>
 * 角色權限維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
@Service("roleSetService")
public class RoleSetServiceImpl extends AbstractService implements RoleSetService {

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private FunctionDao functionDao;

    @Resource
    private RoleFunctionDao roleFunctionDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private UserDao userDao;

    @Override
    public Page<Map<String, Object>> findPageUser(SearchSetting search, String roleCode) {
        return userDao.findPageByRoleCode(roleCode, search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findPageEditUsr(SearchSetting search, String roleCode, String depCode) {
        return userDao.findPageUnselectedByRoleCodeAndDepCode(roleCode, depCode, search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findPageEditFunc(SearchSetting search, String roleCode, String sysType, String parent) {
        return functionDao.findPageUnselected(roleCode, sysType, parent, search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findPageFunc(SearchSetting search, String code) {
        return functionDao.findPageByRoleCode(code, search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Map<String, String> findAllDepartment() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        List<Department> deps = departmentDao.findByAllDepartment();

        if (!CollectionUtils.isEmpty(deps)) {
            for (Department dep : deps) {
                map.put(dep.getCode(), dep.getName());
            }
        }
        return map;
    }

    @Override
    public Map<String, String> findAllFunc(String sysType) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        List<Function> funcs = functionDao.findBySysTypeAndLevel(sysType, "1");

        if (!CollectionUtils.isEmpty(funcs)) {
            for (Function func : funcs) {
                map.put(Integer.toString(func.getCode()), func.getName());
            }
        }
        return map;
    }

    @Override
    public int deleteUrList(String rolCode, List<String> delUsr) {
        return userRoleDao.deleteByRoleCodeAndUserCodes(rolCode, delUsr);
    }

    @Override
    public int deleteRfList(String rolCode, List<String> delFunc) {
        return roleFunctionDao.deleteByRoleCodeAndFuncCodes(rolCode, delFunc);
    }

    @Override
    public List<Map<String, Object>> findAllRoleWithSelectedByUserCode(String userCode) {
        return roleDao.findAllWithSelectedByUserCode(userCode);
    }

    @Override
    public Role findRoleByCode(String code) {
        return roleDao.findByCode(code);
    }

}
