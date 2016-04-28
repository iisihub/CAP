/* 
 * CapRequestJSONMapper.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.sitemesh.mapper;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.UrlUtils;

import com.iisigroup.cap.component.CapSpringMVCRequest;
import com.iisigroup.cap.component.IRequest;
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
 * JavaScript設定request JSON
 * </pre>
 * 
 * @since 2013/4/15
 * @author iristu
 * @version
 *          <ul>
 *          <li>2013/4/15,iristu,new
 *          </ul>
 */
public class CapRequestJSONMapper extends AbstractDecoratorMapper {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final static String PROP_KEY = "reqJSON";
    private String ignorePathReg;
    private Set<String> ignoreParams;
    private Set<String> decoratorFile;

    public void init(Config config, Properties properties, DecoratorMapper parent) throws InstantiationException {
        super.init(config, properties, parent);
        ignorePathReg = properties.getProperty("ignorePathReg");
        String decorator = properties.getProperty("decoratorFile");
        if (!CapString.isEmpty(decorator)) {
            decoratorFile = new HashSet<String>();
            decoratorFile.addAll(Arrays.asList(decorator.split(",")));
        }
        String params = properties.getProperty("ignoreParams");
        if (!CapString.isEmpty(params)) {
            ignoreParams = new HashSet<String>();
            ignoreParams.addAll(Arrays.asList(params.split(",")));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Decorator getDecorator(HttpServletRequest request, Page page) {
        if ((decoratorFile == null || decoratorFile.contains(page.getProperties().get("meta.decorator")))
                && (ignorePathReg == null || !CapString.checkRegularMatch(UrlUtils.buildRequestUrl(request), ignorePathReg))) {
            IRequest req = getDefaultRequest();
            req.setRequestObject(request);
            Enumeration<String> fids = request.getParameterNames();
            HashMap<String, String> hm = new HashMap<String, String>();
            while (fids.hasMoreElements()) {
                String field = (String) fids.nextElement();
                if (!ignoreParams.contains(field)) {
                    String value = req.get(field);
                    hm.put(field, value);
                }
            }
            StringBuffer str = new StringBuffer("<script type=\"text/javascript\">var reqJSON=");
            str.append(JSONSerializer.toJSON(hm).toString()).append(";</script>");
            page.addProperty(PROP_KEY, str.toString());
        }
        return super.getDecorator(request, page);
    }

    private IRequest getDefaultRequest() {
        IRequest cr = CapAppContext.getBean("CapDefaultRequest");
        return cr != null ? cr : new CapSpringMVCRequest();
    }

}
