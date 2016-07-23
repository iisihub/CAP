/* 
 * LineContactDao.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.linebot.dao;

import com.iisigroup.cap.db.dao.GenericDao;
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
public interface LineContactDao extends GenericDao<LineContact> {
    /**
     * 根據 mid 取得聯絡人資訊
     * 
     * @param mid
     * @return
     */
    LineContact findByMid(String mid);
}
