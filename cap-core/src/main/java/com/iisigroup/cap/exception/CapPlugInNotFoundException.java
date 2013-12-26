/*
 * PlugInNotFoundException.java
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
package com.iisigroup.cap.exception;

/**
 * <p>
 * PlugInNotFoundException.
 * </p>
 * 
 * @author Tony Wang
 * @version <ul>
 *          <li>2010/7/16,iristu,modify
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapPlugInNotFoundException extends CapException {

	/** The plugin name. */
	private String pluginName;

	/** The plugin id. */
	private String pluginId;

	/**
	 * Instantiates a new plug in not found exception.
	 * 
	 * @param pluginId
	 *            the plugin id
	 * @param pluginName
	 *            the plugin name
	 */
	public CapPlugInNotFoundException(String pluginId, String pluginName) {
		this.pluginId = pluginId;
		this.pluginName = pluginName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getLocalizedMessage()
	 */
	@Override
	public String getLocalizedMessage() {
		return new StringBuffer("Plugin id: ")
				.append(pluginId)
				.append(" name: ").append(pluginName).append(" not found.").toString(); 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return getLocalizedMessage();
	}
}
