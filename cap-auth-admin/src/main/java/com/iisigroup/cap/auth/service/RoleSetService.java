package com.iisigroup.cap.auth.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * 系統功能維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
public interface RoleSetService {

    Page<Map<String, Object>> findPageUser(ISearch search, String roleCode);

    Page<Map<String, Object>> findPageEditUsr(ISearch search, String roleCode, String depCode);

    Page<Map<String, Object>> findPageFunc(ISearch search, String roleCode);

    Page<Map<String, Object>> findPageEditFunc(ISearch search, String roleCode, String sysType, String parent);

    Map<String, String> findAllDepartment();

    Map<String, String> findAllFunc(String sysType);

    int deleteUrList(String roleCode, List<String> delUsr);

    int deleteRfList(String roleCode, List<String> delFunc);

    List<Map<String, Object>> findAllRoleWithSelectedByUserCode(String userCode);

    Role findRoleByCode(String code);
}
