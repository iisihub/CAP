/**
 * IAction.java
 *
 * Copyright (c) 2009 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.action;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.response.IResult;


/**
 * <p>
 * 動作.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/20,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface IAction {

	IResult doWork(IRequest params) throws CapException;

}
