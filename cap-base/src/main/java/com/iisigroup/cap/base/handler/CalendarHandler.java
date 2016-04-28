/* 
 * CapCalendarHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.service.CalendarService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapEntityUtil;

/**
 * <pre>
 * 日曆
 * </pre>
 * 
 * @since 2014/1/30
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/30,tammy,new
 *          </ul>
 */
@Controller("calendarhandler")
public class CalendarHandler extends MFormHandler {

    @Resource
    private CalendarService calendarService;

    public IResult getCalendarData(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();

        String start = request.get("start");
        String end = request.get("end");
        String userId = CapSecurityContext.getUserId();

        List<Remind> reminds = calendarService.getCalendarData(userId, start, end);
        List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();
        for (Remind remind : reminds) {
            events.add(CapBeanUtil.bean2Map(remind, CapEntityUtil.getColumnName(remind)));
        }
        Map<String, Object> reEvents = new HashMap<String, Object>();
        reEvents.put("events", events);

        result.putAll(reEvents);

        return result;
    }

}
