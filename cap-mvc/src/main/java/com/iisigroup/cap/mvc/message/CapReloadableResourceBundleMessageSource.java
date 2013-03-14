/* 
 * CapReloadableResourceBundleMessageSource.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.mvc.message;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * ReloadableResourceBundleMessageSource
 * </pre>
 * 
 * @since 2011/12/23
 * @author rodeschen
 * @version <ul>
 *          <li>2011/12/23,rodeschen,new
 *          <li>2011/12/29,rodeschen,fix windows reg
 *          <li>2013/1/23,roodeschen,fix weglogic deployment error
 *          </ul>
 */
public class CapReloadableResourceBundleMessageSource
		extends
		org.springframework.context.support.ReloadableResourceBundleMessageSource
		implements ApplicationContextAware, InitializingBean {

	protected final Logger logger = LoggerFactory
			.getLogger(CapReloadableResourceBundleMessageSource.class);
	private final String i18nFileREG = "(_zh_CN|_en|_zh_TW).properties$";
	private final String i18nPattern = "classpath:/i18n/**/*.properties";

	@Override
	public void setApplicationContext(ApplicationContext ctx) {
		applicationContext = ctx;
	}

	private static ApplicationContext applicationContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Set<String> l = new HashSet<String>();
		try {
			Resource[] resources = applicationContext.getResources(i18nPattern);
			for (Resource resource : resources) {
				String path = resource.getURI().toString();
				if (CapString.checkRegularMatch(path, i18nFileREG)) {
					path = path
							.replaceAll(i18nFileREG, "")
							.replaceAll(".*/i18n/", "classpath:/i18n/")
							// for windows
							.replaceAll(".*\\\\i18n\\\\",
									"classpath:\\\\i18n\\\\")
							.replaceAll("\\\\", "/");
					l.add(path);
				}
				logger.debug("set message path:" + path);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		super.setBasenames(l.toArray(new String[l.size()]));

	}
}
