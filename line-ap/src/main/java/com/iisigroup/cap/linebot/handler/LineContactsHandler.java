/* 
 * LineContactsHandler.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.linebot.handler;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.component.impl.BeanGridResult;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.BeanFormatter;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.formatter.impl.ADDateTimeFormatter;
import com.iisigroup.cap.linebot.model.LineContact;
import com.iisigroup.cap.linebot.service.LineMessageService;
import com.iisigroup.cap.mvc.handler.MFormHandler;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2016年7月23日
 * @author Lancelot
 * @version
 *          <ul>
 *          <li>2016年7月23日,Lancelot,new
 *          </ul>
 */
@Controller("linecontactshandler")
public class LineContactsHandler extends MFormHandler {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private LineMessageService lineMessageService;

    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult query(SearchSetting search, Request param) {
        Page<LineContact> list = lineMessageService.findLineContactForPage(search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("status", new BeanFormatter() {
            @Override
            public String reformat(Object in) {
                // TODO Auto-generated method stub
                String result = "";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                LineContact c = (LineContact) in;
                if ("1".equals(c.getBlocked())) {
                    result = "已於 " + sdf.format(c.getBlockedTime()) + " 封鎖";
                } else {
                    result = "友好";
                }
                return result;
            }
        });
        fmt.put("addTime", new ADDateTimeFormatter());
        return new BeanGridResult(list.getContent(), list.getPageSize(), fmt);
    }

    public Result sendMsg(Request param) {
        String mid = param.get("mid");
        String msg = param.get("msg");
        try {
            lineMessageService.sendMessage(mid, msg);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CapMessageException("發送訊息錯誤" + e.getMessage(), getClass());
        }
        return new AjaxFormResult();
    }

    public Result retrive(Request param) {
        String mid = param.get("mid");
        try {
            lineMessageService.retrive(mid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CapMessageException("重新取得聯絡人資訊錯誤" + e.getMessage(), getClass());
        }
        return new AjaxFormResult();
    }

    public Result broadcast(Request param) {
        String msg = param.get("msg");
        try {
            lineMessageService.broadcast(msg);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CapMessageException("廣播訊息錯誤" + e.getMessage(), getClass());
        }
        return new AjaxFormResult();
    }
}
