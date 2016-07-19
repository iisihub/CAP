package com.iisigroup.cap.auth.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.model.DefaultRole;
import com.iisigroup.cap.auth.model.DefaultUser;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.dao.impl.GenericDaoImpl;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.jdbc.support.CapSqlStatement;
import com.iisigroup.cap.security.dao.SecUserDao;
import com.iisigroup.cap.security.model.User;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;

/**
 * <pre>
 * 使用者資訊Dao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version
 *          <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<DefaultUser> implements SecUserDao<DefaultUser>, UserDao {

    @Override
    public DefaultUser getUserByLoginId(String loginId, String depCode) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", loginId);
        return findUniqueOrNone(search);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DefaultRole> getRoleByUser(User user) {
        Query query = getEntityManager().createNativeQuery(
                "select r.* from DEF_ROLE r inner join DEF_USERROLE ur inner join DEF_USER u on u.code=ur.USERCODE on r.CODE=ur.ROLECODE where r.STATUS='0' and u.code=?1", DefaultRole.class);
        // TODO: systemtype
        query.setParameter(1, user.getCode());
        return query.getResultList();
    }

    @Override
    public DefaultUser findByCode(String code) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
        return findUniqueOrNone(search);
    }

    @Override
    public Page<Map<String, Object>> findPage(String code, String name, String[] roleCodes, String[] status, int maxResults, int firstResult) {
        SearchSetting search = createSearchTemplete();
        search.setFirstResult(firstResult);
        search.setMaxResults(maxResults);
        search.addOrderBy("code");
        if (!StringUtils.isBlank(code)) {
            search.addSearchModeParameters(SearchMode.LIKE, "u.code", "%" + code + "%");
        }
        if (!StringUtils.isBlank(name)) {
            search.addSearchModeParameters(SearchMode.LIKE, "u.name", "%" + name + "%");
        }
        if (roleCodes != null && roleCodes.length > 0) {
            search.addSearchModeParameters(SearchMode.IS_NOT_NULL, "ur.usercode", null);
            search.addSearchModeParameters(SearchMode.IN, "ur.rolecode", roleCodes);
        }
        if (status != null && status.length > 0) {
            search.addSearchModeParameters(SearchMode.IN, "u.status", status);
        } else {
            search.addSearchModeParameters(SearchMode.NOT_EQUALS, "u.status", "9");
        }
        return getNamedJdbcTemplate().queryForPage("user_find", search);
    }

    @Override
    public Page<Map<String, Object>> findPageByRoleCode(String roleCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        return getNamedJdbcTemplate().queryForPage("user_getUserByRoldeCode", param, firstResult, maxResults);
    }

    @Override
    public Page<Map<String, Object>> findPageUnselectedByRoleCodeAndDepCode(String roleCode, String depCode, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleCode", roleCode);
        param.put("depCode", depCode);
        return getNamedJdbcTemplate().queryForPage("user_getEditUserByRoleCode", param, firstResult, maxResults);
    }

    @Override
    public void processUserStatus(int pwdExpiredDay, int pwdAccountDisable, int pwdAccountDelete) {
        Map<String, Object> param = new HashMap<String, Object>();
        CapSqlStatement sqlp = (CapSqlStatement) CapAppContext.getBean("userSqlStatement");
        List<Map<String, Object>> result = getNamedJdbcTemplate().queryForList((String) sqlp.getValue("pwdlog_lastpwd"), param);
        for (Map<String, Object> rec : result) {
            String userCode = (String) rec.get("usercode");
            Timestamp lastpwd = (Timestamp) rec.get("lastpwd");
            param.put("userCode", userCode);
            param.put("pwdExpiredTime", CapDate.shiftDays(lastpwd, pwdExpiredDay));
            getNamedJdbcTemplate().update("user_updatePwdExpiredTime", param);
        }
        param.put("pwdAccountDisable", pwdAccountDisable);
        getNamedJdbcTemplate().update("user_disableAccount", param);
        param.put("pwdAccountDelete", pwdAccountDisable);
        getNamedJdbcTemplate().update("user_disableDelete", param);
    }

}
