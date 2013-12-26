/* 
 * CapParameter.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.context;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.formatter.IFormatter;

/**
 * <pre>
 * CapParameter
 * </pre>
 * 
 * @since 2011/6/30
 * @author iristu
 * @version <ul>
 *          <li>2011/6/30,iristu,new
 *          </ul>
 */
public class CapParameter {

	final Map<String, Object> parameter;

	IFormatter formatter;

	public CapParameter(Map<String, Object> map) {
		this.parameter = map;
	}

	public CapParameter(Collection<Map<String, Object>> collection) {
		this.parameter = new HashMap<String, Object>();
		for (Map<String, Object> map : collection) {
			parameter.putAll(map);
		}
	}

	public Map<String, Object> getParameter() {
		return parameter;
	}

	public void setFormatter(IFormatter formatter) {
		this.formatter = formatter;
	}

	@SuppressWarnings("unchecked")
	public <T> T getValue(String key, T defaultValue) {
		if (parameter.containsKey(key)) {
			Object obj = parameter.get(key);
			if (formatter != null) {
				try {
					return (T) formatter.reformat(obj);
				} catch (CapFormatException e) {
					return (T) obj;
				}
			} else {
				return (T) obj;
			}
		}
		return defaultValue;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getValue(String key) {
		if (parameter.containsKey(key)) {
			Object obj = parameter.get(key);
			if (formatter != null) {
				try {
					return (T) formatter.reformat(obj);
				} catch (CapFormatException e) {
					return (T) obj;
				}
			} else {
				return (T) obj;
			}
		}
		return null;
	}

	public boolean containsKey(String key) {
		return parameter.containsKey(key);
	}

}
