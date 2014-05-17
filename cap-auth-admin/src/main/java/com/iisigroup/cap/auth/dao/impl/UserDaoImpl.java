package com.iisigroup.cap.auth.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.auth.model.User;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.security.dao.IUserDao;

/**
 * <pre>
 * 使用者資訊Dao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
@Repository
public class UserDaoImpl extends GenericDao<User> implements IUserDao<User>,
        UserDao {

    @Override
    public User getUserByLoginId(String loginId, String depCode) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", loginId);
        return findUniqueOrNone(search);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoleByUser(User user) {
        Query query = getEntityManager()
                .createNativeQuery(
                        "select r.* from DEF_ROLE r inner join DEF_USERROLE ur inner join DEF_USER u on u.code=ur.USERCODE on r.CODE=ur.ROLECODE where r.STATUS='0' and u.code=?1",
                        Role.class);
        // TODO: systemtype
        query.setParameter(1, user.getCode());
        return query.getResultList();
    }

    @Override
    public User findByCode(String code) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
        return findUniqueOrNone(search);
    }// ;

    @Override
    public Page<Map<String, Object>> findPage(String code, String name,
            String[] roleCodes, String[] status, int maxResults, int firstResult) {
        ISearch search = createSearchTemplete();
        search.setFirstResult(firstResult);
        search.setMaxResults(maxResults);
        search.addOrderBy("code");
        if (!StringUtils.isBlank(code)) {
            search.addSearchModeParameters(SearchMode.LIKE, "u.code", "%"
                    + code + "%");
        }
        if (!StringUtils.isBlank(name)) {
            search.addSearchModeParameters(SearchMode.LIKE, "u.name", "%"
                    + name + "%");
        }
        if (roleCodes != null && roleCodes.length > 0) {
            search.addSearchModeParameters(SearchMode.IS_NOT_NULL, "ur.usercode",
                    null);
            search.addSearchModeParameters(SearchMode.IN, "ur.rolecode",
                    roleCodes);
        }
        if (status != null && status.length > 0) {
            search.addSearchModeParameters(SearchMode.IN, "u.status", status);
        } else {
            search.addSearchModeParameters(SearchMode.NOT_EQUALS, "u.status",
                    "9");
        }
        return getNamedJdbcTemplate().queryForPage("user_find", search);
    }// ;

    @Override
    public Page<Map<String, Object>> findPageByRoleCode(String roleCode,
            int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        return getNamedJdbcTemplate().queryForPage("user_getUserByRoldeCode", param,
                firstResult, maxResults);
    }

    @Override
    public Page<Map<String, Object>> findPageUnselectedByRoleCodeAndDepCode(
            String roleCode, String depCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        param.put("depCode", depCode);
        return getNamedJdbcTemplate().queryForPage("user_getEditUserByRoleCode",
                param, firstResult, maxResults);
    }

}
