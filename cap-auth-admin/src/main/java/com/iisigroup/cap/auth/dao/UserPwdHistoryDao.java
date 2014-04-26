package com.iisigroup.cap.auth.dao;

import java.util.List;

import com.iisigroup.cap.auth.model.UserPwdHistory;
import com.iisigroup.cap.dao.IGenericDao;

public interface UserPwdHistoryDao extends IGenericDao<UserPwdHistory> {
    List<UserPwdHistory> findByUserOid(String userOid);
}
