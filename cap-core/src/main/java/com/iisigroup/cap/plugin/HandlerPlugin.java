/*
 * AjaxHandlerPlugin.java
 *  
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.action.IAction;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.IHandler;
import com.iisigroup.cap.response.IResult;

/**
 * <pre>
 * HandlerPlugin
 * </pre>
 * 
 * @since 2011/11/22
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/22,rodeschen,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public abstract class HandlerPlugin implements IPlugin, IHandler {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * execute
	 * 
	 * @param params
	 *            Client 參數
	 * @return String
	 */
	public abstract IResult execute(IRequest params) throws CapException;

	IRequest request;

	public IRequest getRequest() {
		return request;
	}

	public void setRequest(IRequest request) {
		this.request = request;
	}

	@Override
	public String getPluginName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * get action
	 * 
	 * @param formAction
	 *            action name
	 * @return IAction
	 */
	public abstract IAction getAction(String formAction);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		// do nothing
	}

}
