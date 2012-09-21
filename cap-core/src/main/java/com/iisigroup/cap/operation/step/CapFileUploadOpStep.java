/* 
 * CapFileUploadOpStep.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.operation.step;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.handler.FormHandler;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.utils.CapMath;

/**
 * <pre>
 * 檔案上傳
 * </pre>
 * 
 * @since 2010/7/23
 * @author iristu
 * @version <ul>
 *          <li>2010/7/23,iristu,new
 *          <li>2012/2/29,iristu,上傳檔案預設最大size(limitSize)，當接收檔案超出時，則拒絕接收。
 *          <li>2012/9/20,iristu,改用MultipartResolver接收檔用
 *          </ul>
 */
public class CapFileUploadOpStep extends AbstractCustomizeOpStep {

	protected static Log logger = LogFactory.getLog(CapFileUploadOpStep.class);

	private CommonsMultipartResolver multipartResolver;

	String fileSizeLimitErrorCode;

	public void setMultipartResolver(CommonsMultipartResolver multipartResolver) {
		this.multipartResolver = multipartResolver;
	}

	public void setFileSizeLimitErrorCode(String fileSizeLimitErrorCode) {
		this.fileSizeLimitErrorCode = fileSizeLimitErrorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iisigroup.cap.operation.OperationStep#execute(com.iisigroup.cap.component
	 * .IRequest, com.iisigroup.cap.handler.FormHandler,
	 * com.iisigroup.cap.response.IResult)
	 */
	@Override
	public String execute(IRequest params, FormHandler handler, IResult result)
			throws CapException {
		MultipartHttpServletRequest req = uploadFile(params);
		params.setRequestObject(req);
		return NEXT;
	}// ;

	protected MultipartHttpServletRequest uploadFile(IRequest params) {
		if (params.containsKey("limitSize")) {
			multipartResolver.setMaxUploadSize(params
					.getParamsAsInteger("limitSize"));
		}
		if (params.containsKey("fileEncoding")) {
			multipartResolver.setDefaultEncoding(params.get("fileEncoding"));
		}

		try {
			return multipartResolver
					.resolveMultipart((HttpServletRequest) params
							.getServletRequest());
		} catch (MaxUploadSizeExceededException fe) {
			CapMessageException me = new CapMessageException(
					fileSizeLimitErrorCode, getClass());
			Map<String, String> extra = new HashMap<String, String>();
			extra.put("fileSize",
					CapMath.divide(params.get("limitSize"), "1048576", 2));
			extra.put("actualSize", CapMath.divide(
					String.valueOf(fe.getMaxUploadSize()), "1048576"));
			me.setMessageKey(fileSizeLimitErrorCode);
			me.setExtraInformation(extra);
			throw me;
		} catch (MultipartException e) {
			throw new CapException(e, getClass());
		}

	}// ;
}
