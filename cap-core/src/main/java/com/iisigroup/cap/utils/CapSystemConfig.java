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
import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;

/**
 * <pre>
 * System config util
 * </pre>
 * 
 * @since 2011/12/26
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/12/26,rodeschen,new
 *          </ul>
 */
public class CapSystemConfig implements InitializingBean {

    private Properties properties = new Properties();

    public CapSystemConfig() {
    }

    public CapSystemConfig(Properties properties) throws IOException {
        this.properties = properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defValue) {
        return properties.getProperty(key, defValue);
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // do nothing
    }
}
