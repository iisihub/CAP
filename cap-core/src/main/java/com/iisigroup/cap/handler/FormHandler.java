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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.iisigroup.cap.action.IAction;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.operation.Operation;
import com.iisigroup.cap.plugin.HandlerPlugin;
import com.iisigroup.cap.response.IResult;

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

	public static final String FORM_ACTION = "formAction";

	public static final String SIMPLE_OPERATION = "simpleOperation";

	/*
	 * (non-Javadoc)
	 * 
	 * @seetw.com.iisi.cap.plugin.AjaxHandlerPlugin#execute(org.apache.wicket.
	 * PageParameters, org.apache.wicket.Component)
	 */
	@Override
	public IResult execute(IRequest params) throws CapException {
		IResult result = null;
		Operation oper = getOperation();
		if (oper != null) {
			result = oper.execute(params, this);
		}
		return result;
	}

	public abstract IAction getAction(String formAction);

	public abstract String getOperationName();

	@Autowired
	private ApplicationContext context;

	public Operation getOperation() {
		return (Operation) context.getBean(getOperationName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.plugin.ICapPlugin#version()
	 */
	public String version() {
		return "1.0.0";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		// do nothing
	}

}// ~
