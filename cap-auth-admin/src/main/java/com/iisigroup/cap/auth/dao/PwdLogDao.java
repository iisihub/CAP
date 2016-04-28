package com.iisigroup.cap.auth.dao;

import java.util.List;

import com.iisigroup.cap.auth.model.PwdLog;
import com.iisigroup.cap.dao.GenericDao;

public interface PwdLogDao extends GenericDao<PwdLog> {
    List<PwdLog> findByUserCode(String userCode, int maxHistory);
}
