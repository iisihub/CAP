/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.sitemesh.mapper;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.iisigroup.cap.mvc.i18n.MessageBundleScriptCreator;
import com.iisigroup.cap.utils.CapString;
import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.DecoratorMapper;
import com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper;

/**
 * <pre>
 * i18n Decorator
 * </pre>
 * 
 * @since 2012/9/28
 * @author rodeschen
 * @version <ul>
 *          <li>2012/9/28,rodeschen,new
 *          </ul>
 */
public class CapI18nMapper extends AbstractDecoratorMapper {

	private final static String PROP_I18N = "i18n";
	private String ignorePathReg;

	public void init(Config config, Properties properties, DecoratorMapper parent)
			throws InstantiationException {
		super.init(config, properties, parent);
		ignorePathReg = properties.getProperty("ignorePathReg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper#getDecorator
	 * (javax.servlet.http.HttpServletRequest,
	 * com.opensymphony.module.sitemesh.Page)
	 */
	@Override
	public Decorator getDecorator(HttpServletRequest request,
			com.opensymphony.module.sitemesh.Page page) {
		if (!CapString.checkRegularMatch(request.getPathInfo(), ignorePathReg)) {
			page.addProperty(
					PROP_I18N,
					MessageBundleScriptCreator.createScript(request.getPathInfo().replaceAll("^/",
							"")));
		}
		return super.getDecorator(request, page);
	}

}
