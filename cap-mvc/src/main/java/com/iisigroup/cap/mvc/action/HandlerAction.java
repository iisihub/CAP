package com.iisigroup.cap.mvc.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.component.CapSpringMVCRequest;
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
 * HGServiceAction
 * </pre>
 * 
 * @since 2011/11/2
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/2,rodeschen,copy from cap
 *          </ul>
 */
@RequestMapping("/{handler}handler/{action}")
public class HandlerAction extends BaseActionController {

	/**
	 * default Action
	 * 
	 * @param handler
	 *            handlerName
	 * @param action
	 *            actionName
	 * @param locale
	 *            locale
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @throws Exception
	 */
	@RequestMapping
	public void defaultAction(@PathVariable String handler, @PathVariable String action, Locale locale, HttpServletRequest servletRequest, HttpServletResponse response) throws Exception {
		long st = System.currentTimeMillis();
		handler += "handler";
		if (logger.isTraceEnabled()) {
			logger.trace("Request Data: " + JSONObject.fromObject(servletRequest.getParameterMap()).toString());
		}
		IResult result = null;

		// String version = params.getString(PARAM_VERSION_KEY, "1.0.0");
		String version = "1.0.0";

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
			ByteArrayDownloadResult file = (ByteArrayDownloadResult) result;
			response.setContentType(file.getContentType());
			response.setContentLength(file.getByteArray().length);
			if (!CapString.isEmpty(file.getOutputName())) {
				response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getOutputName() + "\"");
			}
			FileCopyUtils.copy(file.getByteArray(), response.getOutputStream());
		} else {
			outJsonString(response, result.getResult());
		}

		if (logger.isTraceEnabled()) {
			logger.trace("response data : " + result.getLogMessage());
		}
		logger.info("total spand time : " + (System.currentTimeMillis() - st) + "ms");
	}

	private IErrorResult getDefaultErrorResult() {
		return CapAppContext.getBean("defaultErrorResult");
	}

	private IRequest getDefaultRequest() {
		IRequest cr = CapAppContext.getBean("CapDefaultRequest");
		return cr != null ? cr : new CapSpringMVCRequest();
	}

}
