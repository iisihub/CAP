package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.PwdLogDao;
import com.iisigroup.cap.auth.model.PwdLog;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.dao.impl.GenericDaoImpl;

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
