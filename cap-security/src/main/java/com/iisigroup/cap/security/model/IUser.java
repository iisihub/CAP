/*
 * IUser.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.security.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

/**
 * <p>
 * 使用者資料.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/26,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface IUser extends Serializable {

    String getUserId();

    String getUserName();

    String getUnitNo();

    String getApplyNf();

    String getApplyRem();

    BigDecimal getWeights();

    String getUpdater();

    Timestamp getUpdateTime();

    List<? extends IRole> getRoles();

    Locale getLocale();

    String getPassword();

}
