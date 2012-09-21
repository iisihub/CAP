/*
 * CapFormHandleOpStep.java
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
package com.iisigroup.cap.operation.step;

import com.iisigroup.cap.action.IAction;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.FormHandler;
import com.iisigroup.cap.response.IResult;

/**
 * <pre>
 * CapFormHandleOpStep
 * </pre>
 * 
 * @since 2010/7/23
 * @author iristu
 * @version <ul>
 *          <li>2010/7/23,iristu,new
 *          </ul>
 */
public class CapFormHandleOpStep extends AbstractCustomizeOpStep {

	@Override
	public String execute(IRequest params, FormHandler handler, IResult result)
			throws CapException {
		IResult rtn = null;
		@SuppressWarnings("static-access")
		String actionType = params.get(handler.FORM_ACTION);
		setName(handler.getPluginName() + "." + actionType);
		IAction action = handler.getAction(actionType);
		rtn = action.doWork(params);
		if (result == null) {
			result = rtn;
		} else if (rtn != null) {
			result.add(rtn);
		}
		return NEXT;
	}

}// ~
