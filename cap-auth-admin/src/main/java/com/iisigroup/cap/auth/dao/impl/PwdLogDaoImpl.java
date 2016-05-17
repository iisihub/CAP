package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.PwdLogDao;
import com.iisigroup.cap.auth.model.PwdLog;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.dao.impl.GenericDaoImpl;

@Repository
public class PwdLogDaoImpl extends GenericDaoImpl<PwdLog> implements PwdLogDao {

    @Override
    public List<PwdLog> findByUserCode(String userCode, int maxHistory) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "userCode", userCode);
        search.setMaxResults(maxHistory);
        search.addOrderBy("updateTime", true);
        return find(search);
    }

}
