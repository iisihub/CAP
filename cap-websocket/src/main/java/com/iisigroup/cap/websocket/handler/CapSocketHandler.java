/* 
 * CapSocketHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.websocket.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.websocket.constants.WebSocketConstants;
import com.iisigroup.cap.websocket.service.CapSocketService;

/**
 * <pre>
 * web socket handler
 * </pre>
 * 
 * @since 2014/1/30
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/30,tammy,new
 *          </ul>
 */
@Controller("sockethandler")
public class CapSocketHandler extends MFormHandler {

    @Resource
    private CapSocketService socketService;

    /**
     * 
     * @param request
     *            IRequest
     * @return {@link Result.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public Result initSession(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String id = request.get("socketId");

        CapUserDetails userDetails = CapSecurityContext.getUser();
        if (userDetails != null) {
            userDetails.getExtraAttrib().put(WebSocketConstants.SOCKET_CLIENT, socketService.onConnectHandler(id));
        }

        return result;
    }

}
