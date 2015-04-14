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

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.RemindsDao;
import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.dao.impl.GenericDao;

/**
 * <pre>
 * 提醒通知Dao
 * </pre>
 * 
 * @since 2014/1/27
 * @author tammy
 * @version <ul>
 *          <li>2014/1/27,tammy,new
 *          </ul>
 */
@Repository
public class RemindsDaoImpl extends GenericDao<Reminds> implements RemindsDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Reminds> findCurrentRemindItem(String[] styleTyp, String locale) {
        Query query = getEntityManager()
                .createNativeQuery(
                        "select s.* from CFG_remind r inner join CFG_reminds s on r.oid = s.pid where datediff('SECOND', current timestamp, r.STARTDATE) < s.STYLE*s.unit+30 and datediff('SECOND', current timestamp, r.STARTDATE) >= s.STYLE*s.unit and s.YNFLAG = '0' and s.STYLETYP in (:styleTyp) and r.LOCALE = :locale",
                        Reminds.class);
        query.setParameter("styleTyp", Arrays.asList(styleTyp));
        query.setParameter("locale", locale);
        return (List<Reminds>) query.getResultList();
    }

    @Override
    public void merge(Reminds entity) {
        super.merge(entity);
    }
}
