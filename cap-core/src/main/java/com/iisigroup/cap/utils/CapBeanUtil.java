/*
 * CapBeanUtil.java
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
package com.iisigroup.cap.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.model.GenericBean;

/**
 * <p>
 * CapBeanUtil
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/19,iristu,new
 *          <li>2011/6/10,add getField(Class clazz, boolean containSuperClazz)
 *          <li>2011/7/28,增加bean2Map prefix method
 *          <li>2011/9/21, CP, 增加 JSONObject map2Json(Map<String, Object> map,
 *          String[] keyAry)</li>
 *          <li>2011/9/29,iristu,getField修改convert Date及Timestamp問題
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class CapBeanUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(CapBeanUtil.class);

	/**
	 * Copy Bean
	 * 
	 * @param <T>
	 *            the bean
	 * @param source
	 *            source bean
	 * @param destination
	 *            destination bean
	 * @param columns
	 *            要copy的欄位
	 * @return T
	 * @throws CapException
	 */
	public static <T extends GenericBean> T copyBean(T source, T destination,
			String[] columns) throws CapException {
		if (source instanceof GenericBean && destination instanceof GenericBean) {
			GenericBean s = (GenericBean) source;
			GenericBean d = (GenericBean) destination;
			for (String col : columns) {
				if (!CapString.isEmpty(col)) {
					d.set(col, s.get(col));
				}
			}
		}
		return destination;
	}// ;

	public static <T extends GenericBean> T copyBean(T source, T destination)
			throws CapException {
		return copyBean(source, destination,
				CapBeanUtil.getFieldName(destination.getClass(), true));
	}// ;

	/**
	 * bean transform map
	 * 
	 * @param <T>
	 *            the model extends GenericBean
	 * @param source
	 *            source bean
	 * @param columns
	 *            要transform的欄位
	 * @return Map<String, Object>
	 * @throws CapException
	 */
	public static <T extends GenericBean> Map<String, Object> bean2Map(
			T source, String[] columns) throws CapException {
		return bean2Map(source, columns, null);
	}// ;

	/**
	 * bean transform map
	 * 
	 * Map key：prefix+column
	 * 
	 * @param <T>
	 *            the model extends GenericBean
	 * @param prefix
	 *            前綴詞
	 * @param source
	 *            source bean
	 * @param columns
	 *            要transform的欄位
	 * @return Map<String, Object>
	 * @throws CapException
	 */
	public static <T extends GenericBean> Map<String, Object> bean2Map(
			T source, String[] columns, String prefix) throws CapException {
		return bean2Map(source, columns, prefix, true);
	}// ;

	/**
	 * bean transform map
	 * 
	 * Map key：prefix+column
	 * 
	 * @param <T>
	 *            the model extends GenericBean
	 * @param fixString
	 *            前(後)綴詞
	 * @param isPrefix
	 *            是否為前綴詞
	 * @param source
	 *            source bean
	 * @param columns
	 *            要transform的欄位
	 * @return Map<String, Object>
	 * @throws CapException
	 */
	public static <T extends GenericBean> Map<String, Object> bean2Map(
			T source, String[] columns, String fixString, boolean isPrefix)
			throws CapException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		GenericBean s = (GenericBean) source;
		for (String col : columns) {
			String key = (fixString == null) ? col : (isPrefix) ? fixString
					+ col : col + fixString;
			map.put(key, s.get(col));
		}
		return map;
	}// ;

	/**
	 * <pre>
	 * 將map值放入bean中
	 * </pre>
	 * 
	 * @param <T>
	 *            T extends GenericBean
	 * @param prefix
	 *            fieldId的前綴值
	 * @param map
	 *            {fieldId=fieldValue}
	 * @param entry
	 *            the bean
	 * @return T
	 */
	public static <T extends GenericBean> T map2Bean(String prefix,
			Map<String, Object> map, T entry) {
		return map2Bean(prefix, map, entry, entry.getClass());
	}// ;

	/**
	 * <pre>
	 * 將map值放入bean中
	 * </pre>
	 * 
	 * @param <T>
	 *            T extends GenericBean
	 * @param prefix
	 *            fieldId的前綴值
	 * @param map
	 *            {fieldId=fieldValue}
	 * @param entry
	 *            the bean
	 * @param clazz
	 *            the bean class
	 * @return T
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends GenericBean> T map2Bean(String prefix,
			Map<String, Object> map, T entry, Class clazz) {
		if (map != null && !map.isEmpty()) {
			Field[] cols = getField(clazz, true);
			for (Field f : cols) {
				String key = prefix + f.getName();
				if (map.containsKey(key)) {
					Object value;
					value = map.get(key);
					setField(entry, f.getName(), value);
				}
			}
		}
		return entry;
	}// ;

	/**
	 * <pre>
	 * 將map值放入bean中
	 * </pre>
	 * 
	 * @param <T>
	 *            T extends GenericBean
	 * @param map
	 *            {fieldId=fieldValue}
	 * @param entry
	 *            the bean
	 * @param cols
	 *            columns
	 * @return T
	 */
	public static <T extends GenericBean> T map2Bean(Map<String, Object> map,
			T entry, String[] cols) {
		if (map != null && !map.isEmpty()) {
			for (String f : cols) {
				String key = f;
				if (map.containsKey(key)) {
					Object value;
					value = map.get(key);
					setField(entry, f, value);
				}
			}
		}
		return entry;
	}// ;

	/**
	 * <pre>
	 * 將map值放入bean中
	 * </pre>
	 * 
	 * @param <T>
	 *            T extends GenericBean
	 * @param map
	 *            {fieldId=fieldValue}
	 * @param entry
	 *            bean
	 * @return T
	 */
	public static <T extends GenericBean> T map2Bean(Map<String, Object> map,
			T entry) {
		return map2Bean("", map, entry);
	}// ;

	/**
	 * <pre>
	 * 將map值放入bean中
	 * </pre>
	 * 
	 * @param <T>
	 *            T extends GenericBean
	 * @param map
	 *            {fieldId=fieldValue}
	 * @param entry
	 *            bean
	 * @param clazz
	 *            Class<T>
	 * @return T
	 */
	public static <T extends GenericBean> T map2Bean(Map<String, Object> map,
			T entry, Class<T> clazz) {
		return map2Bean("", map, entry, clazz);
	}// ;

	/**
	 * 取得傳入Clazz所有欄位(包含super class)
	 * 
	 * @param clazz
	 *            class
	 * @return List<Field>
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map<Class, Field[]> getAllFields(Class clazz) {
		Map<Class, Field[]> map = new LinkedHashMap<Class, Field[]>();
		Class searchClazz = clazz;
		while (!Object.class.equals(searchClazz) && searchClazz != null) {
			Field[] fields = searchClazz.getDeclaredFields();
			map.put(searchClazz, fields);
			searchClazz = searchClazz.getSuperclass();
		}
		return map;
	}// ;

	/**
	 * 取得傳入Clazz所有欄位(包含super class)
	 * 
	 * @param clazz
	 *            class
	 * @param containSuperClazz
	 *            是否包含繼承的Class欄位
	 * @return String[]
	 */
	@SuppressWarnings({ "rawtypes" })
	public static String[] getFieldName(Class clazz, boolean containSuperClazz) {
		Set<String> cols = new LinkedHashSet<String>();
		Class searchClazz = clazz;
		while (!Object.class.equals(searchClazz) && searchClazz != null) {
			Field[] fields = searchClazz.getDeclaredFields();
			for (Field f : fields) {
				if ("serialVersionUID".equals(f.getName()))
					continue;
				cols.add(f.getName());
			}
			searchClazz = containSuperClazz ? searchClazz.getSuperclass()
					: null;
		}
		return cols.toArray(new String[cols.size()]);
	}// ;

	/**
	 * 取得傳入Clazz所有欄位(包含super class)
	 * 
	 * @param clazz
	 *            class
	 * @param containSuperClazz
	 *            是否包含繼承的Class欄位
	 * @return Field[]
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Field[] getField(Class clazz, boolean containSuperClazz) {
		Set<Field> cols = new LinkedHashSet<Field>();
		Class searchClazz = clazz;
		while (!Object.class.equals(searchClazz) && searchClazz != null) {
			Field[] fields = searchClazz.getDeclaredFields();
			for (Field f : fields) {
				if ("serialVersionUID".equals(f.getName()))
					continue;
				cols.add(f);
			}
			searchClazz = containSuperClazz ? searchClazz.getSuperclass()
					: null;
		}
		return cols.toArray(new Field[] {});
	}// ;

	public static <T> T setField(T entry, String fieldId, Object value) {
		Field field = ReflectionUtils.findField(entry.getClass(), fieldId);
		if (field != null) {
			String setter = new StringBuffer("set")
					.append(String.valueOf(field.getName().charAt(0))
							.toUpperCase())
					.append(field.getName().substring(1)).toString();
			Method method = ReflectionUtils.findMethod(entry.getClass(),
					setter, new Class[] { field.getType() });
			if (method != null) {
				try {
					if (field.getType() != String.class && "".equals(value)) {
						value = null;
					} else if (field.getType() == BigDecimal.class) {
						value = CapMath.getBigDecimal(String.valueOf(value));
					} else if (value instanceof String) {
						if (field.getType() == java.util.Date.class
								|| field.getType() == java.sql.Date.class) {
							value = CapDate.parseDate((String) value);
						} else if (field.getType() == Timestamp.class) {
							value = CapDate
									.convertStringToTimestamp1((String) value);
						}
					}
					if (value == null) {
						method.invoke(entry, new Object[] { null });
					} else {
						method.invoke(entry,
								ConvertUtils.convert(value, field.getType()));
					}
				} catch (Exception e) {
					if (logger.isTraceEnabled()) {
						logger.trace(e.getMessage());
					} else {
						logger.warn(e.getMessage(), e);
					}
				}
			}
		}
		return entry;
	}

	/**
	 * <pre>
	 * 將 keyAry 所指定的 key 在 map 中取得 value 後串成 JSON 物件，該 key 於 map 中不存在時以 null 物件為 value。
	 * 若 keyAry 為 null 時，則將所有 map 的 key-value 串成 JSON 物件。
	 * ex: map={"a":1, "b":2, "c":null, "d":"ddd"}
	 * <li>keySet = null, JSONObject.toString()={"d":"ddd","b":2,"c":null,"a":1}</li>
	 * <li>keySet = new String[]{}, JSONObject.toString()={}</li>
	 * <li>keySet = new String[]{"a", "c", "d"}, JSONObject.toString()={"d":"ddd","c":null,"a":1}</li>
	 * <li>keySet = new String[]{"a", "c", "x"}, JSONObject.toString()={"c":null,"a":1,"x":null}</li>
	 * </pre>
	 * 
	 * @param map
	 *            map
	 * @param keyAry
	 *            null時回傳整個 map 所串成的 JSON 物件； not null 時依指定的 keyAry 串組。
	 * @return JSONObject
	 */
	public static JSONObject map2Json(Map<String, Object> map, String[] keyAry) {

		HashMap<String, Object> tmpMap = null;

		if (keyAry == null) {
			tmpMap = (HashMap<String, Object>) map;
		} else {
			tmpMap = new HashMap<String, Object>();
			for (String tmpKey : keyAry) {
				Object val = map.containsKey(tmpKey) ? map.get(tmpKey) : "";
				if (val instanceof Object[]) {
					Object[] v = (Object[]) val;
					if (v.length == 1)
						val = v[0];
				}
				tmpMap.put(tmpKey, val);
			}
		}

		return JSONObject.fromObject(tmpMap);
	}

}
