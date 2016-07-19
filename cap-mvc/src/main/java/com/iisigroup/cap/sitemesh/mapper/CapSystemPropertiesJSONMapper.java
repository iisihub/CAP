/* 
 * CCSystemPropJSONMapper.java
 * 
 * Copyright (c) 2009-2014 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.sitemesh.mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;
import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.DecoratorMapper;
import com.opensymphony.module.sitemesh.Page;
import com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper;

import net.sf.json.JSONSerializer;

/**
 * <pre>
 * 實作 Sitemesh 的 JSONMapper，把系統參數帶到 page。
 * page 上對應的 properties 為 prop
 * </pre>
 * 
 * <code><meta name="decorator" content="control">
 * <decorator:getProperty property="prop" default="" /></code>
 * 
 * @since 2014/1/19
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2014/1/19,Sunkist Wang,new
 *          </ul>
 */
public class CapSystemPropertiesJSONMapper extends AbstractDecoratorMapper {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final static String PROP_KEY = "prop";
    private Set<String> searchKeys;
    private Set<String> decoratorFile;
    private Map<String, Object> sysProp;

    public void init(Config config, Properties properties, DecoratorMapper parent) throws InstantiationException {
        super.init(config, properties, parent);
        String decorator = properties.getProperty("decoratorFile");
        if (!CapString.isEmpty(decorator)) {
            decoratorFile = new HashSet<String>();
            decoratorFile.addAll(Arrays.asList(decorator.split(",")));
        }
        String params = properties.getProperty("searchKeys");
        if (!CapString.isEmpty(params)) {
            searchKeys = new HashSet<String>();
            searchKeys.addAll(Arrays.asList(params.split(",")));
        }
        sysProp = CapAppContext.getBean("sysProp");
    }

    @Override
    public Decorator getDecorator(HttpServletRequest request, Page page) {
        if (decoratorFile == null || decoratorFile.contains(page.getProperties().get("meta.decorator"))) {
            HashMap<String, Object> hm = new HashMap<String, Object>();
            if (searchKeys != null) {
                for (String sKey : searchKeys) {
                    String val = CapString.trimNull(sysProp.get(sKey));
                    Pattern pattern = Pattern.compile("(^true$|^false$)", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(val);
                    if (matcher.matches()) {
                        hm.put(sKey, Boolean.valueOf(val));
                    } else {
                        hm.put(sKey, val);
                    }
                }
            }
            StringBuffer str = new StringBuffer("<script type=\"text/javascript\">var prop=");
            str.append(JSONSerializer.toJSON(hm).toString()).append(";</script>");
            page.addProperty(PROP_KEY, str.toString());
        }
        return super.getDecorator(request, page);
    }

}
