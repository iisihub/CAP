/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.handler.FormHandler;
import com.iisigroup.cap.plugin.HandlerPlugin;
import com.iisigroup.cap.plugin.PluginManager;
import com.iisigroup.cap.response.ByteArrayDownloadResult;
import com.iisigroup.cap.response.ErrorResult;
import com.iisigroup.cap.response.IErrorResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * Cap handler Servlet
 * </pre>
 * 
 * @since 2012/9/3
 * @author rodeschen
 * @version <ul>
 *          <li>2012/9/3,rodeschen,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapHandlerServlet extends HttpServlet {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected static String VERSION = "1.0.0";
	protected static String DEFAULT_ERROR_RESULT = "defaultErrorResult";
	protected static String CAP_DEFAULT_REQUEST = "CapDefaultRequest";
	protected static String CONTENT_TYPE_JSON = "text/plain;charset=UTF-8";
	protected static String CONTENT_TYPE_XML = "text/xml;charset=UTF-8";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandlerAction(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandlerAction(req, resp);
	}

	protected void doHandlerAction(HttpServletRequest servletRequest, HttpServletResponse response) {
		//

		String handler =  (String) servletRequest.getAttribute("_handler");
		String action = (String) servletRequest.getAttribute("_action");
		//

 		long st = System.currentTimeMillis();
		//handler += "handler";
		if (logger.isTraceEnabled()) {
			logger.trace("Request Data: " + JSONObject.fromObject(servletRequest.getParameterMap()).toString());
		}
		IResult result = null;

		// String version = params.getString(PARAM_VERSION_KEY, "1.0.0");
		String version = VERSION;

		Logger pluginlogger = logger;
		IRequest request = getDefaultRequest();
		request.setRequestObject(servletRequest);
		try {

			request.setParameter(FormHandler.FORM_ACTION, action);
			PluginManager pluginMgr = (PluginManager) CapAppContext.getBean("CapPluginManager");

			logger.debug("handler:" + handler + " -receive data:" + request.toString());

			HandlerPlugin plugin = pluginMgr.getPlugin(handler, version);
			result = plugin.execute(request);
			pluginlogger = LoggerFactory.getLogger(plugin.getClass());

			if (result instanceof ByteArrayDownloadResult) {
				ByteArrayDownloadResult file = (ByteArrayDownloadResult) result;
				response.setContentType(file.getContentType());
				response.setContentLength(file.getByteArray().length);
				if (!CapString.isEmpty(file.getOutputName())) {
					response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getOutputName() + "\"");
				}
				FileCopyUtils.copy(file.getByteArray(), response.getOutputStream());
			}
		} catch (Exception e) {
			IErrorResult errorResult = getDefaultErrorResult();
			if (errorResult == null) {
				result = new ErrorResult(request, e);
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
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}

		}
		if (result instanceof ByteArrayDownloadResult) {
			// do nothing
		} else {
			outJsonString(response, result.getResult());
		}

		if (logger.isTraceEnabled()) {
			logger.trace("response data : " + result.getLogMessage());
		}
		logger.info("total spand time : " + (System.currentTimeMillis() - st) + "ms");
	}

	protected IErrorResult getDefaultErrorResult() {
		return CapAppContext.getBean(DEFAULT_ERROR_RESULT);
	}

	protected IRequest getDefaultRequest() {
		IRequest cr = CapAppContext.getBean(CAP_DEFAULT_REQUEST);
		return cr;
	}

	/**
	 * json 回传写入
	 * 
	 * @param response
	 *            response
	 * @param string
	 *            json String
	 */
	protected void outputString(HttpServletResponse response, String contentType, String string) {
		response.setContentType(contentType);
		try {
			response.setContentLength(string.getBytes(CharEncoding.UTF_8).length);
		} catch (UnsupportedEncodingException e1) {
			response.setContentLength(string.getBytes().length);
			logger.error(e1.getMessage(), e1);
		}
		try {
			PrintWriter out = response.getWriter();
			out.write(string);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * json 回传写入
	 * 
	 * @param response
	 *            response
	 * @param str
	 *            str
	 */
	protected void outJsonString(HttpServletResponse response, String str) {
		outputString(response, CONTENT_TYPE_JSON, str);
	}

	

	/**
	 * xml 回传写入
	 * 
	 * @param response
	 *            response
	 * @param str
	 *            str
	 */
	protected void outXmlString(HttpServletResponse response, String str) {
		outputString(response, CONTENT_TYPE_XML, str);
	}
}
