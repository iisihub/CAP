/* 
 * IHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.handler;

import com.iisigroup.cap.action.Action;

/**
 * <pre>
 * IHandler
 * </pre>
 * 
 * @since 2012/9/24
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/24,iristu,new
 *          </ul>
 */
public interface Handler {

    String FORM_ACTION = "formAction";

    String SIMPLE_OPERATION = "simpleOperation";

    String getHandlerName();

    Action getAction(String actionType);

}
