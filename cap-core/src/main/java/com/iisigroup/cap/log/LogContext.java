/*
 * CapLogContext.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */

package com.iisigroup.cap.log;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * set log4j MDC for log user information..
 * </p>
 * @author gabriellalau
 * @version<ul>
 *            <li>2011-11-23,gabriella,new
 *         </ul>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class LogContext extends InheritableThreadLocal {

	private static final Log logger = LogFactory.getLog(LogContext.class);

	private static ThreadLocal<Map> logContext = new InheritableThreadLocal<Map>();

	private static boolean useMDC = false;

	public static final String LOGIN = "login";

	public static final String SESSION_ID = "sessionId";
	
	public static final String IP = "ip";
	
	public static final String UUID = "uuid";
	
	public static final String REQUEST_URI = "reqURI";

	static {
		try {
			Class.forName("org.apache.log4j.MDC");
			useMDC = true;
		} catch (Throwable t) {
			if (logger.isDebugEnabled()) {
				logger.debug("org.apache.log4j.MDC was not found on the classpath, continue without");
			}
		}
	}

	@Override
	protected Object childValue(Object parentValue) {
		return new LinkedHashMap((Map) parentValue);
	}

	/**
	 * Get a map containing all the objects held by the current thread.
	 */
	private static Map getContext() {
		if (useMDC) {
			return org.apache.log4j.MDC.getContext();
		} else {
			Map m = logContext.get();
			if (m == null) {
				m = new LinkedHashMap();
				logContext.set(m);
			}
			return m;
		}
	}

	/**
	 * Get the context identified by the key parameter.
	 * 
	 * @param key
	 *            the key
	 * @return Object
	 */
	public static Object get(String key) {
		if (useMDC) {
			return org.apache.log4j.MDC.get(key);
		} else {
			return getContext().get(key);
		}
	}

	/**
	 * Put a context value (the o parameter) as identified with the key
	 * parameter into the current thread's context map.
	 * 
	 * @param key
	 *            the Key
	 * @param o
	 *            Object
	 */
	public static void put(String key, Object o) {
		if (useMDC) {
			org.apache.log4j.MDC.put(key, o);
		} else {
			getContext().put(key, o);
		}
	}

	/**
	 * Remove the the context identified by the key parameter.
	 * 
	 * @param key
	 *            the Key
	 */
	public static void remove(String key) {
		if (useMDC) {
			org.apache.log4j.MDC.remove(key);
		} else {
			getContext().remove(key);
		}
	}

	/**
	 * Remove all the object put in this thread context.
	 */
	public static void resetLogContext() {
		if (getContext() != null) {
			getContext().clear();
		}
	}

	/**
	 * Only used if jdk logging is used.
	 * 
	 * @return String
	 */
	public static String toLogPrefixString() {
		Map m = getContext();
		Iterator i = m.entrySet().iterator();

		StringBuilder sb = new StringBuilder("[");
		while (i.hasNext()) {
			Map.Entry e = (Map.Entry) i.next();
			sb.append((String) e.getKey()).append("=")
					.append(e.getValue().toString());
			if (i.hasNext()) {
				sb.append("&");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * set the given login in the map
	 * 
	 * @param login
	 *            the user Id
	 */
	public static void setLogin(String login) {
		put(LOGIN, login);
	}

	/**
	 * set the given IP in the map
	 * 
	 * @param ip
	 *            the user IP
	 */
	public static void setIp(String ip) {
		put(IP, ip);
	}
	
	/**
	 * set the given web session in the map
	 * 
	 * @param sessionId
	 *            the session id
	 */
	public static void setSessionId(String sessionId) {
		put(SESSION_ID, sessionId);
	}

	public static void setRequestURL(String url) {
		put(REQUEST_URI, url);
	}
	
	public static void setUUID(String uuid){
		put(UUID,uuid);
	}

}
