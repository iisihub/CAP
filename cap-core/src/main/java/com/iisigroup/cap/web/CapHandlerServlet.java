/*
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.web;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.component.ErrorResult;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.DefaultErrorResult;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.handler.Handler;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.plugin.HandlerPlugin;
import com.iisigroup.cap.plugin.PluginManager;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapWebUtil;

import net.sf.json.JSONObject;

/**
 * <pre>
 * Cap handler Servlet
 * </pre>
 * 
 * @since 2012/9/3
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2012/9/3,rodeschen,new
 *          <li>2012/9/18,iristu,modify
 *          <li>2013/2/28,rodeschen,add set request
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapHandlerServlet extends HttpServlet {

    protected final Logger logger = LoggerFactory.getLogger(CapHandlerServlet.class);
    public final String HANDLER = "_handler";
    public final String ACTION = "_action";

    protected String DEFAULT_ERROR_RESULT;
    protected String DEFAULT_REQUEST;

    protected PluginManager pluginMgr;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String manager = config.getInitParameter("pluginManager");
        pluginMgr = (PluginManager) CapAppContext.getBean(manager);
        DEFAULT_REQUEST = config.getInitParameter("defaultRequest");
        if (CapString.isEmpty(DEFAULT_REQUEST)) {
            DEFAULT_REQUEST = "CapDefaultRequest";
        }
        DEFAULT_ERROR_RESULT = config.getInitParameter("errorResult");
        if (CapString.isEmpty(DEFAULT_ERROR_RESULT)) {
            DEFAULT_ERROR_RESULT = "CapDefaultErrorResult";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandlerAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandlerAction(req, resp);
    }

    protected void doHandlerAction(HttpServletRequest req, HttpServletResponse resp) {
        SimpleContextHolder.resetContext();
        String handler = (String) req.getAttribute(HANDLER);
        String action = (String) req.getAttribute(ACTION);
        long st = System.currentTimeMillis();
        if (logger.isTraceEnabled()) {
            logger.trace("Request Data: {}", JSONObject.fromObject(req.getParameterMap()).toString());
        }
        Object locale = req.getSession().getAttribute(CapWebUtil.localeKey);
        if (locale != null) {
            SimpleContextHolder.put(CapWebUtil.localeKey, locale);
        } else {
            SimpleContextHolder.put(CapWebUtil.localeKey, Locale.getDefault());
        }
        Result result = null;
        Logger pluginlogger = logger;
        Request request = getDefaultRequest(req);
        try {
            request.setParameter(Handler.FORM_ACTION, action);
            HandlerPlugin plugin = pluginMgr.getPlugin(handler);
            logger.info("plugin:" + handler + " - " + plugin.getClass().getSimpleName() + " action:" + action);
            plugin.setRequest(request);
            pluginlogger = LoggerFactory.getLogger(plugin.getClass());
            result = plugin.execute(request);

        } catch (Exception e) {
            ErrorResult errorResult = getDefaultErrorResult();
            if (errorResult == null) {
                result = new DefaultErrorResult(request, e);
            } else {
                errorResult.putError(request, e);
                result = errorResult;
            }
            if (e instanceof CapMessageException) {
                pluginlogger.error(result.getResult().toString());
            } else if (e instanceof CapException && e.getCause() != null) {
                pluginlogger.error(result.getResult().toString(), e.getCause());
            } else {
                pluginlogger.error(result.getResult().toString(), e);
            }
            if (!"true".equals(request.get("iframe"))) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } finally {
            result.respondResult(resp);
            logger.debug("total spend time : {} ms", (System.currentTimeMillis() - st));
            if (logger.isTraceEnabled()) {
                logger.trace("Response Data : " + result.getLogMessage());
            }
            SimpleContextHolder.resetContext();
        }
    }

    protected ErrorResult getDefaultErrorResult() {
        return CapAppContext.getBean(DEFAULT_ERROR_RESULT);
    }

    protected Request getDefaultRequest(HttpServletRequest req) {
        Request cr = CapAppContext.getBean(DEFAULT_REQUEST);
        cr.setRequestObject(req);
        return cr;
    }

}
