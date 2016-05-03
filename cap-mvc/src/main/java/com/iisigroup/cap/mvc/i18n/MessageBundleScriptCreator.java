/*
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
package com.iisigroup.cap.mvc.i18n;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.constants.Constants;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <p>
 * MessageBundleScriptCreator.
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/12,iristu,new
 *          </ul>
 */
public class MessageBundleScriptCreator {
    protected final static Logger logger = LoggerFactory.getLogger(MessageBundleScriptCreator.class);

    protected final static String I18NKEY_REG = "\\w+$";
    protected static Set<String> defaultFilter;

    static {
        defaultFilter = new HashSet<String>();
        defaultFilter.add("js.");
    }

    /**
     * 將properties轉成json格式
     * 
     * @param i18nPath
     *            i18nPath
     * @return String
     */
    public static String generateJson(String i18nPath) {
        return generateJson(loadProperties(i18nPath), null);

    }

    /**
     * 將properties轉成json格式
     * 
     * @param i18nPath
     *            i18nPath
     * @param filterList
     *            filter字串
     * @return String
     */
    public static String generateJson(String i18nPath, Set<String> filterList) {
        return generateJson(loadProperties(i18nPath), filterList);

    }

    /**
     * 將properties轉成json格式
     * 
     * @param props
     *            properties
     * @param filterList
     *            filter字串
     * @return String
     */
    public static String generateJson(Properties props, Set<String> filterList) {
        AjaxFormResult result = new AjaxFormResult();
        String filterReg = generateFilterReg(filterList);
        if (props != null && !props.isEmpty()) {
            if (CapString.isEmpty(filterReg)) {
                for (Entry<Object, Object> entry : props.entrySet()) {
                    result.set((String) entry.getKey(), (String) entry.getValue());
                }
            } else {
                for (Entry<Object, Object> entry : props.entrySet()) {
                    if (CapString.checkRegularMatch((String) entry.getKey(), filterReg)) {
                        result.set(((String) entry.getKey()).replaceAll("js.", ""), (String) entry.getValue());
                    }
                }
            }
        }
        return result.getResult();
    }

    /**
     * 將properties轉成json格式
     * 
     * @param i18nKeyName
     *            i18n key name
     * @param props
     *            properties
     * @return String
     */
    public static String createScript(String i18nKeyName, Properties props) {
        return createScript(i18nKeyName, props, null);
    }

    /**
     * 將properties轉成json格式
     * 
     * @param i18nKeyName
     *            i18n key name
     * @param props
     *            properties
     * @param filterList
     *            filter字串
     * @return String
     */
    public static String createScript(String i18nKeyName, Properties props, Set<String> filterList) {

        String message = generateJson(props, filterList);
        if (CapString.isEmpty(message)) {
            return null;
        }
        StringBuffer script = new StringBuffer();
        script.append("<script type='text/javascript'> require(['cust-common'], function(){i18n.set(\"").append(i18nKeyName).append("\",").append(message).append(");});</script>");
        return script.toString();
    }

    /**
     * 將properties轉成json格式
     * 
     * @param i18nPath
     *            i18n Path
     * @return String
     */
    public static String createScript(String i18nPath) {
        return createScript(CapString.getRegularMatch(i18nPath, I18NKEY_REG), loadProperties(i18nPath), null);
    }

    /**
     * 將properties轉成json格式
     * 
     * @param i18nPath
     *            i18n Path
     * @param filterList
     *            filter字串
     * @return String
     */
    public static String createScript(String i18nPath, Set<String> filterList) {
        return createScript(CapString.getRegularMatch(i18nPath, I18NKEY_REG), loadProperties(i18nPath), filterList);
    }

    /**
     * 讀取 i18n 檔案
     * 
     * @param i18nPath
     *            i18nPath
     * @return Properties
     */
    private static Properties loadProperties(String i18nPath) {
        Properties prop = new Properties();
        Locale locale = null;
        try {
            locale = CapSecurityContext.getLocale();
            if (locale == null) {
                locale = Locale.getDefault();
            }
        } catch (Exception e) {
            locale = Locale.getDefault();
        }
        String i18nFile = null;
        InputStream is = null;
        try {
            i18nFile = new StringBuffer("classpath:/i18n/").append(i18nPath).append("_").append(locale.toString()).append(".properties").toString();
            Resource rs = CapAppContext.getApplicationContext().getResource(i18nFile);
            if (rs != null) {
                is = rs.getInputStream();
                prop.load(is);
            } else {
                i18nFile = new StringBuffer("classpath:/i18n/").append(i18nPath).append("_").append(".properties").toString();
                rs = CapAppContext.getApplicationContext().getResource(i18nFile);
                if (rs != null) {
                    is = rs.getInputStream();
                    prop.load(is);
                }
            }

        } catch (Exception e) {
            logger.error("can't load " + i18nPath);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return prop;
    }

    /**
     * 產生 filter 比對表示式
     * 
     * @param filterList
     *            filter list
     * @return String
     */
    private static String generateFilterReg(Set<String> filterList) {
        if (filterList == null) {
            filterList = defaultFilter;
        }
        if (!filterList.isEmpty()) {
            StringBuffer regSb = new StringBuffer("^(");
            for (Iterator<String> it = filterList.iterator(); it.hasNext();) {
                regSb.append(it.next()).append(Constants.VALUES_SEPARATOR);
            }
            regSb.deleteCharAt(regSb.length() - 1).append(")");
            return regSb.toString();
        } else {
            return null;
        }

    }
}
