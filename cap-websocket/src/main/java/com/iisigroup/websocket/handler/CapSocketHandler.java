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
package com.iisigroup.websocket.handler;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.websocket.service.CapSocketService;

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
@Scope("request")
@Controller("sockethandler")
public class CapSocketHandler extends MFormHandler {

    @Resource
    private CapSocketService socketService;

    /**
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult initSession(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String id = request.get("socketId");

        CapUserDetails userDetails = CapSecurityContext.getUser();
        if (userDetails != null) {
            userDetails.setSocketClient(socketService.onConnectHandler(id));
        }

        return result;
    }

}
