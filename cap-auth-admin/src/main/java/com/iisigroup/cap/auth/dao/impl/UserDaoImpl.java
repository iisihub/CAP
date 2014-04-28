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
    public User getUserByLoginId(String loginId, String unitNo) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userId", loginId);
        return findUniqueOrNone(search);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoleByUser(User user) {
        // select rle.* from DEF_RLE rle inner join DEF_RLSET rls inner join
        // DEF_USR usr on usr.STAFFPID=rls.STAFFPID on rle.ROLCODE=rls.ROLCODE
        // where rle.STU='0' and usr.STAFFPID=:userId
        Query query = getEntityManager()
                .createNativeQuery(
                        "select rle.* from DEF_RLE rle inner join DEF_RLSET rls inner join DEF_USR usr on usr.STAFFPID=rls.STAFFPID on rle.ROLCODE=rls.ROLCODE where rle.STU='0' and usr.STAFFPID=?1",
                        Role.class);
        // TODO: systemtype
        query.setParameter(1, user.getUserId());
        return query.getResultList();
    }

    @Override
    public User findByUserId(String userId) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userId", userId);
        return findUniqueOrNone(search);
    }

    @Override
    public Page<Map<String, Object>> findPage(String userId, String userName,
            String[] roleOids, String[] status, int maxResults, int firstResult) {
        ISearch search = createSearchTemplete();
        search.setFirstResult(firstResult);
        search.setMaxResults(maxResults);
        search.addOrderBy("staffpid");
        if (!StringUtils.isBlank(userId)) {
            search.addSearchModeParameters(SearchMode.LIKE, "u.staffpid", "%"
                    + userId + "%");
        }
        if (!StringUtils.isBlank(userName)) {
            search.addSearchModeParameters(SearchMode.LIKE, "u.staffpnm", "%"
                    + userName + "%");
        }
        if (roleOids != null && roleOids.length > 0) {
            search.addSearchModeParameters(SearchMode.IS_NOT_NULL,
                    "ur.staffpid", null);
            search.addSearchModeParameters(SearchMode.IN, "ur.rolecode", roleOids);
        }
        if (status != null && status.length > 0) {
            search.addSearchModeParameters(SearchMode.IN, "u.status", status);
        } else {
            search.addSearchModeParameters(SearchMode.NOT_EQUALS, "u.status", "9");
        }
        return getNamedJdbcTemplate().queryForPage("User.find", search);
    }

    @Override
    public Page<Map<String, Object>> findPageByRoleCode(String roleCode,
            int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", roleCode);
        return getNamedJdbcTemplate().queryForPage("roleSet_getUser", param,
                firstResult, maxResults);
    }

    @Override
    public Page<Map<String, Object>> findPageUnselectedByRoleCodeAndUnitNo(
            String rolCode, String unitNo, int firstResult, int maxResults) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", rolCode);
        param.put("unitNo", unitNo);
        return getNamedJdbcTemplate().queryForPage("roleSet_getEditUser",
                param, firstResult, maxResults);
    }

}
