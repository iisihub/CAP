/* 
 * EmailService.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.service;

/**
 * <pre>
 * send email
 * </pre>
 * 
 * @since 2013/3/7
 * @author iristu
 * @version
 *          <ul>
 *          <li>2013/3/7,iristu,new
 *          </ul>
 */
public interface EmailService {

    void sendEmail(String[] sendTo, String subject, String sendContext);

    void sendEmail(String sendFrom, String[] sendTo, String subject, String sendContext);

}
