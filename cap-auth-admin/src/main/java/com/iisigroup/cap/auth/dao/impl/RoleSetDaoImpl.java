package com.iisigroup.cap.auth.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.RoleSetDao;
import com.iisigroup.cap.auth.model.RoleSet;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

@Repository
public class RoleSetDaoImpl extends GenericDao<RoleSet> implements RoleSetDao {

    @Override
    public int deleteByRoleCodeAndUserIds(String rolCode, List<String> delUsr) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rolCode", rolCode);
        param.put("delUsrs", delUsr);
        return getNamedJdbcTemplate().update("roleSet_deleteRlset", param);
    }

    @Override
    public RoleSet findByStaffpidAndRoleCode(String staffpid, String roleCode) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userId", staffpid);
        search.addSearchModeParameters(SearchMode.EQUALS, "rolCode", roleCode);
        return findUniqueOrNone(search);
    }

    @Override
    public void deleteByUserId(String userId) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userId", userId);
        delete(find(search));
    }
}
