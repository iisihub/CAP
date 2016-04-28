/* 
 * CapReminderTimerTask.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.websocket.timer;

import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.corundumstudio.socketio.SocketIOClient;
import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.base.service.EmailService;
import com.iisigroup.cap.formatter.ADDateTimeFormatter;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.websocket.RemindEnum;
import com.iisigroup.websocket.bean.NotifyObject;
import com.iisigroup.websocket.service.CapRemindService;

/**
 */
public class CapReminderTimerTask extends TimerTask {

    private final Logger logger = LoggerFactory.getLogger(CapReminderTimerTask.class);

    @Resource
    private CapRemindService reminderService;
    @Resource
    private EmailService emailService;

    @Override
    public void run() {
        List<Reminds> reminds = reminderService.getRemindItems(new String[] { RemindEnum.TEXT.getCode(), RemindEnum.POPUP.getCode() }, null);// 0.文字
                                                                                                                                             // 1.彈出對話框
        if (!CollectionUtils.isEmpty(reminds)) {
            sendEvent(reminds);
        } else {
            logger.debug("remind items TYPE[0,1] are empty! Not Execute");
        }

        reminds = null;
        reminds = reminderService.getRemindItems(new String[] { RemindEnum.MAIL.getCode() }, null);// 2.電子郵件
        if (!CollectionUtils.isEmpty(reminds)) {
            sendEmail(reminds);
        } else {
            logger.debug("remind items TYPE[2] are empty! Not Execute");
        }
    }

    public void sendEvent(List<Reminds> reminds) {
        ADDateTimeFormatter formatter = new ADDateTimeFormatter();
        HashMap<String, CapUserDetails> allPrincipal = reminderService.getCurrentUser();
        if (CollectionUtils.isEmpty(allPrincipal)) {
            logger.debug("principals are empty!");
            return;
        }
        for (Reminds remind : reminds) {
            Remind content = reminderService.findRemind(remind.getPid());
            try {
                NotifyObject data = new NotifyObject();
                data.setTargetId(remind.getScopePid());
                data.setStartTime(formatter.reformat(content.getStartDate()));
                data.setEndTime(formatter.reformat(content.getEndDate()));
                data.setContent(content.getContent());

                CapUserDetails userDetail = allPrincipal.get(data.getTargetId());
                if (userDetail != null) {
                    SocketIOClient client = userDetail.getSocketClient();
                    if (client != null) {
                        String event = remind.getStyleTyp().equals(RemindEnum.TEXT.getCode()) ? "textEvent" : "popUpEvent";
                        client.sendEvent(event, data);
                        logger.debug("remind item to user : " + remind.getScopePid() + " " + event + " send");
                    }
                }

                remind.setYnFlag("1");// 已完成
                reminderService.saveReminds(remind);

            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void sendEmail(List<Reminds> reminds) {
        ADDateTimeFormatter formatter = new ADDateTimeFormatter();
        for (Reminds remind : reminds) {
            Remind content = reminderService.findRemind(remind.getPid());
            // 主旨
            StringBuffer subject = new StringBuffer();
            subject.append(CapAppContext.getMessage("remind.subject1"));
            subject.append(formatter.reformat(content.getStartDate()));
            subject.append(" ");
            subject.append(CapAppContext.getMessage("remind.subject2"));
            subject.append(CapString.isEmpty(content.getContent()) ? "" : content.getContent().substring(0, content.getContent().length() > 40 ? 40 : content.getContent().length()));
            // 內文
            StringBuffer sendContext = new StringBuffer();
            sendContext.append(CapAppContext.getMessage("remind.startDate"));
            sendContext.append(formatter.reformat(content.getStartDate()));
            sendContext.append("<br/>");
            sendContext.append(CapAppContext.getMessage("remind.endDate"));
            sendContext.append(formatter.reformat(content.getEndDate()));
            sendContext.append("<br/>");
            sendContext.append(CapAppContext.getMessage("remind.subject2"));
            sendContext.append(formatter.reformat(content.getContent()));

            String email = reminderService.getUsrEmail(remind.getScopePid());
            if (email != null) {
                emailService.sendEmail(new String[] { email }, subject.toString(), sendContext.toString());
                remind.setYnFlag("1");// 已完成
                reminderService.saveReminds(remind);
            }
        }
    }
}
