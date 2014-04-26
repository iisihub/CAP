package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.UserPwdHistoryDao;
import com.iisigroup.cap.auth.model.UserPwdHistory;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

@Repository
public class UserPwdHistoryDaoImpl extends GenericDao<UserPwdHistory> implements
        UserPwdHistoryDao {

    @Override
    public List<UserPwdHistory> findByUserOid(String userOid) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userOid", userOid);
        search.addOrderBy("updateTime", true);
        return find(search);
    }

}
