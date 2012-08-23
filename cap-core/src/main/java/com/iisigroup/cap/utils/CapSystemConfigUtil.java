/* 
 * CapSystemConfigUtil.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.utils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.iisigroup.cap.Constants;

/**
 * <pre>
 * System config util
 * </pre>
 * 
 * @since 2011/12/26
 * @author rodeschen
 * @version <ul>
 *          <li>2011/12/26,rodeschen,new
 *          </ul>
 */
public class CapSystemConfigUtil {
	private static CapSystemConfigUtil util;

	private static CapSystemConfigUtil getSystemConfigUtil() {
		if (util == null) {
			util = AppContext.getBean(Constants.SYSTEM_CONFIG);
		}
		return util;
	}

	public static String getProperty(String key) {
		return getSystemConfigUtil().getProperties().getProperty(key);
	}

	private Properties properties = new Properties();

	public void setProps(List<String> properties) {
		for (Object prod : properties) {
			try {
				this.properties.load(AppContext.getApplicationContext().getResource(String.valueOf(prod)).getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Properties getProperties() {
		return properties;
	}
}
