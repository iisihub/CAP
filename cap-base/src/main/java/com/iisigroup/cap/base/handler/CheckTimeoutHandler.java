/* 
 * CCCheckRouteHandler.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.base.CapSystemProperties;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * Check timeout handler
 * </pre>
 * 
 * @since 2014/4/2
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2014/4/2,new
 *          <li>2014/4/18,Sunkist Wang,update get sysProp
 *          </ul>
 */
@Controller("checktimeouthandler")
public class CheckTimeoutHandler extends MFormHandler {

    @Resource
    private CapSystemProperties sysProp;

    private static final String TIME_OUT = "TIME_OUT";

    public Result check(Request request) throws CapException {
        AjaxFormResult result = new AjaxFormResult();
        HttpServletRequest sreq = (HttpServletRequest) request.getServletRequest();
        // String path = sreq.getPathInfo();
        // boolean isNewSes = sreq.getSession(false).isNew();
        long time1 = sreq.getSession(false).getLastAccessedTime();
        long time2 = CapDate.getCurrentTimestamp().getTime();
        // session設定時間
        long time3 = sreq.getSession(false).getMaxInactiveInterval();
        // 讀取後台db設定（單位為分鐘）
        sysProp.remove(TIME_OUT);
        String stout = sysProp.get(TIME_OUT);
        if (!CapString.isEmpty(stout)) {
            time3 = Long.parseLong(stout);
            time3 = time3 * 60;
        }
        String isContinues = request.get("isContinues");
        // Calculate difference in milliseconds
        long diff = time2 - time1;
        // Difference in seconds
        long diffSec = diff / 1000;
        // session timeout 導向 error page
        String refPath = sreq.getHeader("referer");
        refPath = StringEscapeUtils.unescapeHtml(refPath);
        if ((diffSec > time3 && refPath.lastIndexOf("error") < 0 && refPath.lastIndexOf("timeout") < 0) || "false".equals(isContinues)) {
            // if(!isNewSes){
            result.set("errorPage", "/cap-web/page/timeout");
            sreq.getSession(false).invalidate();
            // }
        }
        result.set("msg", "cccheked");
        return result;
    }
}
