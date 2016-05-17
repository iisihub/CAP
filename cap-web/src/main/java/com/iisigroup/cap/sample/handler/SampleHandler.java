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
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.component.impl.ByteArrayDownloadResult;
import com.iisigroup.cap.constants.Constants;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.report.constants.ContextTypeEnum;
import com.iisigroup.cap.report.service.impl.SampleRptService;
import com.iisigroup.cap.security.annotation.Captcha;

/**
 * <pre>
 * Sample Handler
 * </pre>
 * 
 * @since 2012/9/24
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/24,iristu,new
 *          </ul>
 */
@Controller("samplehandler")
public class SampleHandler extends MFormHandler {

    private final Logger logger = LoggerFactory.getLogger(SampleHandler.class);

    @HandlerType(HandlerTypeEnum.FileUpload)
    public Result upload(Request request) throws CapException {
        AjaxFormResult result = new AjaxFormResult();
        // String str = request.get("testStr");
        MultipartFile f = request.getFile("ufile");
        try {
            FileUtils.writeByteArrayToFile(new File("xxxx.txt"), f.getBytes());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        String fileName = f.getOriginalFilename();
        result.set(Constants.AJAX_NOTIFY_MESSAGE, fileName + " upload file success!!");
        return result;
    }

    @HandlerType(HandlerTypeEnum.FileDownload)
    public Result dwnload(Request request) throws CapException {
        // String outputName = request.get("fileName", "CapLog.log");
        File file = new File("logs/CapLog.log");
        FileInputStream is = null;
        try {
            is = FileUtils.openInputStream(file);
            return new ByteArrayDownloadResult(request, IOUtils.toByteArray(is), "text/plain");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return null;
        // return new FileDownloadResult(request, "logs/CapLog.log", outputName,
        // "text/plain");
    }

    @Resource
    private SampleRptService sampleRptService;

    @HandlerType(HandlerTypeEnum.FileDownload)
    public Result dwnloadPdf(Request request) throws CapException {
        ByteArrayOutputStream file = null;
        try {
            file = sampleRptService.generateReport(request);
            return new ByteArrayDownloadResult(request, file.toByteArray(), ContextTypeEnum.pdf.toString(), "test.pdf");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(file);
        }
        return null;
        // return new FileDownloadResult(request, "logs/CapLog.log", outputName,
        // "text/plain");
    }

    public Result queryMenu(Request request) {
        return new AjaxFormResult("{'child':[{'name':'關於我們','url':'def','child':[{'name':'公司簡介','url':'def/about'}]}"
                + ",{'name':'系統設定','url':'system','child':[{'name':'代碼設定','url':'system/codetype'}" + ",{'name':'參數設定','url':'system/sysparm'},{'name':'流水號檢視','url':'system/sequence'}]}"
                + ",{'name':'系统功能','url':'sample','child':[{'name':'檔案上下傳','url':'sample/fileUpdDwn'},{'name':'WebSocket','url':'sample/webSocket'}]}"
                + ",{'name':'分案管理','url':'division','child':[{'name':'因子維護','url':'division/factorMnt'},{'name':'條件維護','url':'division/conditionMnt'},{'name':'規則維護','url':'division/ruleTbMnt'},{'name':'計劃維護','url':'division/batchPlaneMnt'}]}"
                + ",{'name':'排程管理','url':'batch','child':[{'name':'排程控管','url':'','child':[{'name':'排程設定','url':'batch/schedule'},{'name':'排程Job清單','url':'batch/jobs'}]},{'name':'排程監控','url':'batch/jobexecution'}]}]}");
    }

    /**
     * 動態驗証測試 掛上 @Captcha 即可自動檢查 captcha 欄位
     * 
     * @param request
     * @return IResult
     */
    @Captcha
    public Result checkCaptcha(Request request) {
        return new AjaxFormResult().set(Constants.AJAX_NOTIFY_MESSAGE, "check ok!");
    }

}
