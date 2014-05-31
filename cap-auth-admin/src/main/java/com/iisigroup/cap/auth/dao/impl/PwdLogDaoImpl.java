package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.PwdLogDao;
import com.iisigroup.cap.auth.model.PwdLog;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

@Repository
public class PwdLogDaoImpl extends GenericDao<PwdLog> implements
        PwdLogDao {

    @Override
    public List<PwdLog> findByUserCode(String userCode, int maxHistory) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userCode", userCode);
        search.setMaxResults(maxHistory);
        search.addOrderBy("updateTime", true);
        return find(search);
    }

}
