/* 
 * CapCaptchaServlet.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.captcha.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iisigroup.cap.security.captcha.CapSecurityCaptcha;
import com.iisigroup.cap.utils.CapAppContext;

/**
 * <pre>
 * captcha create
 * </pre>
 * 
 * @since 2013/3/26
 * @author rodeschen
 * @version <ul>
 *          <li>2013/3/26,rodeschen,new
 *          <li>2013/7/16,rodeschen,fix error
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapCaptchaServlet extends HttpServlet {

	public static String DEF_RENDERER = "capCaptcha";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DEF_RENDERER = config.getInitParameter("captchaBean");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		CapSecurityCaptcha captcha = CapAppContext.getBean(DEF_RENDERER);
		BufferedImage img =  captcha.crateImage();
		resp.setContentType("image/jpeg");  
	    OutputStream os = resp.getOutputStream();  
	    ImageIO.write(img, "jpg", os);  
	    os.close();  
		
	}

}
