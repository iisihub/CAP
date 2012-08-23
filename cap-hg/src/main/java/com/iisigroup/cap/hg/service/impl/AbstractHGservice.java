/* 
 * HGservice.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.hg.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.hg.service.IHGService;

/**<pre>
 * HGService
 * </pre>
 * @since  2011/12/12
 * @author rodeschen
 * @version <ul>
 *           <li>2011/12/12,rodeschen,new
 *          </ul>
 */
public abstract class AbstractHGservice implements IHGService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private Map<String, Object> properties;
	/* (non-Javadoc)
	 * @see com.iisi.cap.hg.service.IHGService#setProperties(java.util.Map)
	 */
	@Override
	public void setProperties(Map<String, Object> property) throws CapException {
		if (property == null) {
			throw new CapException("http property error", getClass());
		}
		if (this.properties == null) {
			this.properties = (Map<String, Object>) property;
		} else {
			this.properties.putAll((Map<String, Object>) property);
		}
	}

	/* (non-Javadoc)
	 * @see com.iisi.cap.hg.service.IHGService#setProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setProperty(String name, Object value) {
		if (properties == null) {
			properties = new HashMap<String, Object>();
		}
		properties.put(name, value);

	}

	/* (non-Javadoc)
	 * @see com.iisi.cap.hg.service.IHGService#getProperties(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProperty(Object name) throws CapException {
		return (T) (properties != null && properties.containsKey(name) ? properties
				.get(name) : null);
	}

}
