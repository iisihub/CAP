/* 
 * SampleHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.sample.handler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.report.enums.ContextTypeEnum;
import com.iisigroup.cap.report.service.SampleRptService;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.ByteArrayDownloadResult;
import com.iisigroup.cap.response.IResult;

/**
 * <pre>
 * Sample Handler
 * </pre>
 * 
 * @since 2012/9/24
 * @author iristu
 * @version <ul>
 *          <li>2012/9/24,iristu,new
 *          </ul>
 */
@Scope("request")
@Controller("samplehandler")
public class SampleHandler extends MFormHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(SampleHandler.class);

	@HandlerType(HandlerTypeEnum.FileUpload)
	public IResult upload(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		// String str = request.get("testStr");
		MultipartFile f = request.getFile("ufile");
		try {
			FileUtils.writeByteArrayToFile(new File("xxxx.txt"), f.getBytes());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		String fileName = f.getOriginalFilename();
		result.set(Constants.AJAX_NOTIFY_MESSAGE, fileName
				+ " upload file success!!");
		return result;
	}// ;

	@HandlerType(HandlerTypeEnum.FileDownload)
	public IResult dwnload(IRequest request) throws CapException {
		// String outputName = request.get("fileName", "CapLog.log");
		File file = new File("logs/CapLog.log");
		FileInputStream is = null;
		try {
			is = FileUtils.openInputStream(file);
			return new ByteArrayDownloadResult(request,
					IOUtils.toByteArray(is), "text/plain");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(is);
		}
		return null;
		// return new FileDownloadResult(request, "logs/CapLog.log", outputName,
		// "text/plain");
	}// ;
	@Resource
	private SampleRptService sampleRptService;
	
	@HandlerType(HandlerTypeEnum.FileDownload)
	public IResult dwnloadPdf(IRequest request) throws CapException {
		ByteArrayOutputStream file = null;
		try {
			file = sampleRptService.generateReport(request);
			return new ByteArrayDownloadResult(request, file.toByteArray(),
					ContextTypeEnum.pdf.toString(), "test.pdf");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(file);
		}
		return null;
		// return new FileDownloadResult(request, "logs/CapLog.log", outputName,
		// "text/plain");
	}// ;

	public IResult queryMenu(IRequest request) {
		return new AjaxFormResult(
				"{'menu':[{'name':'關於我們','url':'def','child':[{'name':'公司簡介','url':'about'}]},{'name':'系統設定','url':'system','child':[{'name':'代碼設定','url':'codetype'},{'name':'參數設定','url':'sysparm'},{'name':'流水號檢視','url':'sequence'}]},{'name':'系统功能','url':'sample','child':[{'name':'檔案上下傳','url':'fileUpdDwn'}, {'name':'WebSocket','url':'webSocket'}]},{'name':'排程管理','url':'batch','child':[{'name':'排程設定','url':'schedule'},{'name':'排程Job清單','url':'jobs'},{'name':'排程監控','url':'jobexecution'}]}]}");
	}
}
