package com.iisigroup.cap.linebot.handler;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.mvc.handler.MFormHandler;

@Controller("linebothandler")
public class LineBotHandler extends MFormHandler {
    public Result ask(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        result.set("msg", "ok");
        return result;
    }
}
