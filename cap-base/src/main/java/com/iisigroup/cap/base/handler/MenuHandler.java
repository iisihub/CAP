/* 
 * MenuHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.handler;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.base.service.MenuService;
import com.iisigroup.cap.base.service.impl.MenuServiceImpl.MenuItem;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;

/**
 * <pre>
 * Sample Handler
 * </pre>
 * 
 * @since 2012/9/24
 * @author iristu
 * @version <ul>
 *          <li>2012/9/24,iristu,new
 *          <li>2013/12/26,tammy,前端組menu修改
 *          </ul>
 */
@Scope("request")
@Controller("menuhandler")
public class MenuHandler extends MFormHandler {

	@Resource
	private MenuService menuSrv;

	private static final Logger logger = LoggerFactory
			.getLogger(MenuHandler.class);

	public IResult queryMenu(IRequest request) {

		MenuItem menu = menuSrv.getMenuByRoles(CapSecurityContext.getRoleIds());
		if (menu != null) {
			return new AjaxFormResult(JSONSerializer.toJSON(menu).toString());
		}
		return new AjaxFormResult();
	}

}
