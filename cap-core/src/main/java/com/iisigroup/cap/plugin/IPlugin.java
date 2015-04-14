/*
 * ICapPlugin.java 2009/9/9 上午 04:34:00
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

import org.springframework.beans.factory.InitializingBean;

/**
 * <p>
 * interface ICapPlugin extends InitializingBean.
 * </p>
 * 
 * @author Tony Wang
 * @version <ul>
 *          <li>2010/7/16,iristu,modify
 *          <li>2011/1/28,iristu,增加可設定default回傳的IResult
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface IPlugin extends InitializingBean {

    /** The Constant PLUGIN_NOT_FOUND_MSG. */
    public static final String PLUGIN_NOT_FOUND_MSG = "cap.core.pluginNotFound";

    /**
     * Gets the plugin name.
     * 
     * @return the plugin name
     */
    public String getPluginName();

}
