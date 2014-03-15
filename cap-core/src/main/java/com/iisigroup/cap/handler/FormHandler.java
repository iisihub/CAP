/*
 * FormHandler.java
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
package com.iisigroup.cap.handler;

import com.iisigroup.cap.action.IAction;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.operation.OpStepContext;
import com.iisigroup.cap.operation.Operation;
import com.iisigroup.cap.operation.OperationStep;
import com.iisigroup.cap.plugin.HandlerPlugin;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.utils.CapAppContext;

/**
 * <pre>
 * FormHandler.
 * </pre>
 * 
 * @since 2010/07/20
 * @author iristu
 * @version <ul>
 *          <li>iristu,2010/07/20,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public abstract class FormHandler extends HandlerPlugin {

	
	public IResult execute(IRequest params) {
		Operation oper = getOperation();
		if (oper != null) {
			OpStepContext ctx = new OpStepContext(OperationStep.NEXT);
			oper.execute(ctx, params, this);
			return ctx.getResult();
		}
		return null;
	}

	public abstract IAction getAction(String formAction);

	public abstract String getOperationName();

	public Operation getOperation() {
		return (Operation) CapAppContext.getApplicationContext().getBean(
				getOperationName());
	}

	
	public String getHandlerName() {
		return getPluginName();
	}

}// ~
