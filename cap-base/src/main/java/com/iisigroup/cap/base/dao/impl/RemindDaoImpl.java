/* 
 * RemindDaoImpl.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.RemindDao;
import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.dao.impl.GenericDaoImpl;

/**
 * <pre>
 * 提醒通知Dao
 * </pre>
 * 
 * @since 2014/1/27
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/27,tammy,new
 *          </ul>
 */
@Repository
public class RemindDaoImpl extends GenericDaoImpl<Remind> implements RemindDao {

    @Override
    public Remind findByPid(String pid) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "oid", pid);
        return findUniqueOrNone(search);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Remind> getCalendarData(String userId, Timestamp start, Timestamp end, String locale) {
        Query query = getEntityManager().createNativeQuery(
                "select distinct r.* from CFG_remind r inner join CFG_reminds s on r.oid = s.pid where r.endDate > :start and r.startDate < :end and (s.scopePid=:userId or r.scopePid=:userId) and r.LOCALE = :locale",
                Remind.class);
        query.setParameter("start", start);
        query.setParameter("end", end);
        query.setParameter("userId", userId);
        query.setParameter("locale", locale);
        return (List<Remind>) query.getResultList();
    }
}
