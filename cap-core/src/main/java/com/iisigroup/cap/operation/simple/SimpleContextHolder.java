/*
 * SimpleContextHolder.java
 *
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.operation.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * SimpleContextHolder.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/22,iristu,new
 *          </ul>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SimpleContextHolder extends InheritableThreadLocal {

    public static final String FORM_RESULT = "formResult";

    public static final String DATA_BEAN = "docData";

    protected static ThreadLocal<Map<String, Object>> keepContext = new InheritableThreadLocal<Map<String, Object>>();

    /**
     * Get a map containing all the objects held by the current thread.
     */
    private static Map getContext() {
        Map<String, Object> m = keepContext.get();
        if (m == null) {
            m = new HashMap<String, Object>();
            keepContext.set(m);
        }
        return m;
    }

    /**
     * Get the context identified by the key parameter.
     * 
     * @param <T>
     *            the model
     * @param key
     *            the key
     * @return Object
     */
    public static <T> T get(String key) {
        return (T) getContext().get(key);
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
        getContext().put(key, o);
    }

    public static boolean containKey(String key) {
        return getContext().containsKey(key);
    }

    /**
     * Remove the the context identified by the key parameter.
     * 
     * @param key
     *            the Key
     */
    public static void remove(String key) {
        getContext().remove(key);
    }

    /**
     * Remove all the object put in this thread context.
     */
    public static void resetContext() {
        if (keepContext.get() != null) {
            keepContext.get().clear();
            keepContext.remove();
        }
    }

}// ~
