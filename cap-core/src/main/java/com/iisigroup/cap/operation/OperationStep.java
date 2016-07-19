/*
 * OperationStep.java
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

import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.handler.Handler;
import com.iisigroup.cap.model.OpStepContext;

/**
 * <p>
 * OperationStep.
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/23,iristu,new
 *          </ul>
 */
public interface OperationStep {

    static final String NEXT = "next";

    static final String ERROR = "error";

    static final String RETURN = "return";

    String getName();

    void setName(String name);

    OpStepContext execute(OpStepContext ctx, Request params, Handler handler);

    OpStepContext handleException(OpStepContext ctx, Exception e);

}
