/*
 * CapPluginManager.java 2009/9/9 上午 04:34:00
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc.
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
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.iisigroup.cap.exception.CapPlugInNotFoundException;

/**
 * <p>
 * class CapPluginManager.
 * </p>
 * 
 * @author Tony Wang
 * @version <ul>
 *          <li>2010/7/16,iristu,modify
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class PluginManager implements InitializingBean {

    private final static Logger logger = LoggerFactory.getLogger(PluginManager.class);

    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    /**
     * User Spring Bean Name to find Bean Class
     * 
     * @param <T>
     *            T
     * @param plugInBeanName
     *            plugInBeanName
     * @return T
     * @throws CapPlugInNotFoundException
     */
    @SuppressWarnings("unchecked")
    public <T> T getPlugin(String plugInBeanName) {
        T plugin = null;

        long start = System.currentTimeMillis();
        plugin = (T) context.getBean(plugInBeanName, IPlugin.class);
        if (logger.isTraceEnabled()) {
            logger.trace("Spring Find {} executed time: {}", plugInBeanName, (System.currentTimeMillis() - start));
        }
        if (plugin != null) {
            return plugin;
        } else {
            throw new CapPlugInNotFoundException(plugInBeanName, plugInBeanName);
        }
    }

    @SuppressWarnings("unchecked")
    public <R> R getDefaultErrorResult() {
        return (R) context.getBean("defaultErrorResult");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        String[] names = getAllPluginName();

        for (String name : names) {
            if (logger.isInfoEnabled()) {
                logger.info("Found Plugin Name: " + name);
            }
        }
    }

    /**
     * Gets the plugin name.
     * 
     * @return the plugin map
     */
    public String[] getAllPluginName() {
        return context.getBeanNamesForType(IPlugin.class);
    }

}
