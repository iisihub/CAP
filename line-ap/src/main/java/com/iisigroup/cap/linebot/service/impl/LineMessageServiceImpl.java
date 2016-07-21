package com.iisigroup.cap.linebot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.linebot.client.LineResource;
import com.iisigroup.cap.linebot.service.LineMessageService;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.client.exception.LineBotAPIJsonProcessingException;
import com.linecorp.bot.model.callback.CallbackRequest;
import com.linecorp.bot.model.callback.Event;
import com.linecorp.bot.model.content.Content;
import com.linecorp.bot.model.content.TextContent;

@Service
public class LineMessageServiceImpl implements LineMessageService {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void echo(byte[] req) {
        try {
            CallbackRequest request = LineResource.getLineBotClient().readCallbackRequest(req);
            List<Event> events = request.getResult();
            for (Event event : events) {
                Content content = event.getContent();
                if (content instanceof TextContent) {
                    TextContent textContent = (TextContent) content;
                    LineResource.getLineBotClient().sendText(textContent.getFrom(), textContent.getText());
                    logger.debug("send text to " + textContent.getFrom() + ": " + textContent.getText());
                }
            }
        } catch (LineBotAPIJsonProcessingException e) {
            logger.error(e.getMessage(), e);
        } catch (LineBotAPIException e) {
            logger.error(e.getMessage(), e);
        }

    }

}
