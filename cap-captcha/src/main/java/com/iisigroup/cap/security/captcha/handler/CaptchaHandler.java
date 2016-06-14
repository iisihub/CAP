/* 
 * CaptchaHandler.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.captcha.handler;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.ByteArrayDownloadResult;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.security.service.CheckCodeService;
import com.iisigroup.cap.utils.CapAppContext;

/**
 * <pre>
 * create captcha handler
 * </pre>
 * 
 * @since 2016年6月14日
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2016年6月14日,Sunkist Wang,new
 *          </ul>
 */
@Controller("captcha.png")
public class CaptchaHandler extends MFormHandler {

    public static String DEFAULT_RENDER = "capCaptcha";

    /**
     * create captcha image
     * 
     * @throws IOException
     */
    public Result doWork(Request request) {
        CheckCodeService captcha = CapAppContext.getBean(DEFAULT_RENDER);
        BufferedImage img = captcha.createCheckCode();
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                }
            }
        }
        return new ByteArrayDownloadResult(request, baos.toByteArray(), "image");
    }
}
