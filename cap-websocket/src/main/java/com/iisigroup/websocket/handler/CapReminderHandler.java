/* 
 * CapReminderHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.websocket.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.handler.MFormHandler;

/**
 * <pre>
 * 提醒通知
 * </pre>
 * 
 * @since 2014/1/30
 * @author tammy
 * @version <ul>
 *          <li>2014/1/30,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("reminderhandler")
public class CapReminderHandler extends MFormHandler {

}
