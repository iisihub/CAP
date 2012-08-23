/**
 * PlugInNotFoundException.java
 * 
 * 2009/9/9 上午 04:34:00
 * 
 * Copyright (c) 2009 International Integrated System, Inc.
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
 * <p> PlugInNotFoundException.</p>
 * <pre>
 * $Date: 2010-08-03 17:38:52 +0800 (星期二, 03 八月 2010) $
 * $Author: iris $
 * $Revision: 26 $
 * $HeadURL: svn://192.168.0.1/MICB_ISDOC/cap/cap-core/src/main/java/tw/com/iisi/cap/exception/PlugInNotFoundException.java $
 * </pre>
 *
 * @author Tony Wang
 * @version $Revision: 26 $
 * @version <ul>
 *           <li>2010/7/16,iristu,modify
 *           <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapPlugInNotFoundException extends CapException {

	/** The plugin name. */
	private String pluginName;

	/** The version. */
	private String version;

	/** The plugin id. */
	private String pluginId;

	/**
	 * Instantiates a new plug in not found exception.
	 * 
	 * @param pluginId
	 *            the plugin id
	 * @param pluginName
	 *            the plugin name
	 * @param version
	 *            the version
	 */
	public CapPlugInNotFoundException(String pluginId, String pluginName,
			String version) {
		this.pluginId = pluginId;
		this.pluginName = pluginName;
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getLocalizedMessage()
	 */
	@Override
	public String getLocalizedMessage() {
		return "Plugin id: " + pluginId + " name: " + pluginName + " version: " + version + " not found."; //$NON-NLS-1$
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
