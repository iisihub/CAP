/* 
 * LineContactDaoImpl.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.linebot.dao.impl;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.dao.impl.GenericDaoImpl;
import com.iisigroup.cap.linebot.dao.LineContactDao;
import com.iisigroup.cap.linebot.model.LineContact;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2016年7月22日
 * @author Lancelot
 * @version
 *          <ul>
 *          <li>2016年7月22日,Lancelot,new
 *          </ul>
 */
@Repository
public class LineContactDaoImpl extends GenericDaoImpl<LineContact> implements LineContactDao {
    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.linebot.dao.LineContactDao#findByMid(java.lang.String)
     */
    @Override
    public LineContact findByMid(String mid) {
        SearchSetting s = createSearchTemplete();
        s.addSearchModeParameters(SearchMode.EQUALS, "mid", mid);
        return findUniqueOrNone(s);
    }

}
