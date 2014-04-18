package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.UserPwdHistory;
import com.iisigroup.cap.dao.IGenericDao;

public interface UserPwdHistoryDao extends IGenericDao<UserPwdHistory> {
    List<UserPwdHistory> findByUserOid(String userOid);
}
