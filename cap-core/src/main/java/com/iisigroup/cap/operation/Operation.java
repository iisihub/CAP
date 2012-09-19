/*
 * Operation.java
 *
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.operation;

import java.util.Map;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.FormHandler;
import com.iisigroup.cap.response.IResult;

/**
 * <p>
 * Operation.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/22,iristu,new
 *          </ul>
 */
public interface Operation {

	String getName();

	void setName(String name);

	Map<String, OperationStep> getRuleMap();

	void setRuleMap(Map<String, OperationStep> ruleMap);

	IResult execute(IRequest params, FormHandler handler)
			throws CapException;

}
