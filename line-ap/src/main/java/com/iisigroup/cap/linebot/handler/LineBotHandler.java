package com.iisigroup.cap.linebot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.mvc.handler.MFormHandler;

@Controller("linebothandler")
public class LineBotHandler extends MFormHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Result ask(Request request) {
        logger.info("========= LINE BOT BEGIN =========");
        logger.info(request.toString());
        logger.info("========= LINE BOT END =========");
        AjaxFormResult result = new AjaxFormResult();
        result.set("msg", "ok");
        return result;
    }
}
