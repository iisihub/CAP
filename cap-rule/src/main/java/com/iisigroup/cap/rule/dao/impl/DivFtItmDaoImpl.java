/*
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.rule.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.rule.dao.DivFtItmDao;
import com.iisigroup.cap.rule.model.DivFtItm;

/**
 * <pre>
 * Division Fator Item DAO Impl
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
@Repository
public class DivFtItmDaoImpl extends GenericDao<DivFtItm> implements DivFtItmDao {

    @Override
    public DivFtItm findByDivFtItmNo(String factorNo) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", factorNo);
        return findUniqueOrNone(search);
    }

    @Override
    public List<DivFtItm> findByDivFtItmNo(String[] divFtItmNos) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", divFtItmNos);
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("codeOrder");
        return find(search);
    }

    @Override
    public DivFtItm findByOid(String oid) {
        return find(oid);
    }

    @Override
    public List<DivFtItm> findAllFtItm() {
        ISearch search = createSearchTemplete();
        search.addOrderBy("factorNo");
        search.setDistinct(true);
        return find(search);
    }

}