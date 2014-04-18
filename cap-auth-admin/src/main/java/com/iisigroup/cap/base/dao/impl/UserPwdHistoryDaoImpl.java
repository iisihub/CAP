package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.BaseDao;
import com.iisigroup.cap.base.dao.UserPwdHistoryDao;
import com.iisigroup.cap.base.model.UserPwdHistory;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

@Repository
public class UserPwdHistoryDaoImpl extends BaseDao<UserPwdHistory> implements
        UserPwdHistoryDao {

    @Override
    public List<UserPwdHistory> findByUserOid(String userOid) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userOid", userOid);
        search.addOrderBy("updateTime", true);
        return find(search);
    }

}
