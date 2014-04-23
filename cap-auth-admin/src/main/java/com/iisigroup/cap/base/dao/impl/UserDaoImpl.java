package com.iisigroup.cap.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.UserDao;
import com.iisigroup.cap.base.model.Role;
import com.iisigroup.cap.base.model.User;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Map<String, Object>> findPage(String userId, String userName,
            String[] roleOids, String[] status, int maxResults, int firstResult) {
        // TODO Auto-generated method stub
        return null;
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
