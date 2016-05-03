/*
 * IResult.java
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
package com.iisigroup.cap.component;

import java.io.Serializable;

import javax.servlet.ServletResponse;

/**
 * <p>
 * IResult.
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/11/23,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface Result extends Serializable {

    String getResult();

    void respondResult(ServletResponse response);

    String getLogMessage();

    void add(Result result);

    String getContextType();

    void setContextType(String cxtType);

    String getEncoding();

    void setEncoding(String encoding);

}
