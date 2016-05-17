/* 
 * CapEntityUtils.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.db.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Openjpa entity util
 * </pre>
 * 
 * @since 2011年8月19日
 * @author iristu
 * @version
 *          <ul>
 *          <li>2011年8月19日,iristu,new
 *          </ul>
 */
public class CapEntityUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CapEntityUtil.class);

    /**
     * 取得傳入entity所有欄位名稱
     * 
     * @param <T>
     *            entity
     * @param entity
     *            jpa entity
     * @return String[]
     */
    public static <T> String[] getColumnName(T entity) {
        Set<Class<? extends Annotation>> ignore = new HashSet<Class<? extends Annotation>>();
        ignore.add(OneToMany.class);
        ignore.add(OneToOne.class);
        ignore.add(ManyToMany.class);
        ignore.add(ManyToOne.class);
        return getColumnName(entity, ignore);
    }

    @SuppressWarnings({ "rawtypes" })
    public static <T> String[] getColumnName(T entity, Set<Class<? extends Annotation>> ignoreAnnotation) {
        Set<String> cols = new LinkedHashSet<String>();
        try {
            Class searchClazz = getEntityClass(entity);
            while (!Object.class.equals(searchClazz) && searchClazz != null) {
                Field[] fields = searchClazz.getDeclaredFields();
                f: for (Field field : fields) {
                    if (ignoreAnnotation != null) {
                        for (Class<? extends Annotation> ignore : ignoreAnnotation) {
                            if (field.isAnnotationPresent(ignore)) {
                                continue f;
                            }
                        }
                    }
                    cols.add(field.getName());
                }
                searchClazz = searchClazz.getSuperclass();
            }
            return cols.toArray(new String[cols.size()]);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * 取得傳入entity所有欄位名稱及型態
     * 
     * @param <T>
     *            entity
     * @param entity
     *            jpa entity
     * @return Map<String, Class>
     */
    @SuppressWarnings("rawtypes")
    public static <T> Map<String, Class> getColumnType(T entity) {
        Map<String, Class> cols = new HashMap<String, Class>();
        try {
            Class searchClazz = getEntityClass(entity);
            while (!Object.class.equals(searchClazz) && searchClazz != null) {
                Field[] fields = searchClazz.getDeclaredFields();
                for (Field field : fields) {
                    cols.put(field.getName(), field.getType());
                }
                searchClazz = searchClazz.getSuperclass();
            }
            return cols;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * 取得entity class
     * 
     * @param <T>
     *            entity
     * @param entity
     *            openjpa entity
     * @return Class
     * @throws ClassNotFoundException
     */
    @SuppressWarnings({ "unchecked" })
    public static <T> Class<T> getEntityClass(T entity) throws ClassNotFoundException {
        return (Class<T>) entity.getClass();
        // String entityName = PCEnhancer.toManagedTypeName(entity.getClass()
        // .getName());
        // return (Class<T>) Class.forName(entityName);
    }

    @SuppressWarnings("rawtypes")
    public static int getEntityFieldLength(Class clazz, String filedName, int defValue) {
        try {
            return clazz.getDeclaredField(filedName).getAnnotation(Column.class).length();
        } catch (Exception e) {
            e.printStackTrace();
            return defValue;
        }
    }
}
