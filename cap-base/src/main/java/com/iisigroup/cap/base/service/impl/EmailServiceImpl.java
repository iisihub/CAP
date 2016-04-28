/* 
 * EmailServiceImpl.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.service.impl;

import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import com.iisigroup.cap.base.service.EmailService;

/**
 * <pre>
 * send java email
 * </pre>
 * 
 * @since 2013/3/7
 * @author iristu
 * @version
 *          <ul>
 *          <li>2013/3/7,iristu,new
 *          </ul>
 */
public class EmailServiceImpl implements EmailService {

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private JavaMailSender mailSender;

    private String sendForm;

    @Override
    public void sendEmail(String[] sendTo, String subject, String sendContext) {
        sendEmail(sendForm, sendTo, subject, sendContext);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.base.service.EmailService#sendEmail(java.lang.String, java.lang.String, java.lang.String, java.util.Map)
     */
    @Override
    @Async
    public void sendEmail(final String sendFrom, final String[] sendTo, final String subject, final String sendContext) {
        try {
            MimeMessage mm = mailSender.createMimeMessage();
            MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "UTF-8");
            // 寄件人
            mmh.setFrom(sendFrom);
            // 收件人
            mmh.setTo(sendTo);
            // 主旨
            mmh.setSubject(subject);
            // html信件內容
            mmh.setText(sendContext, true);

            mailSender.send(mm);

            logger.debug("send mail from:{} to {} ,{}-{}", new String[] { sendFrom, Arrays.toString(sendTo), subject, sendContext });
        } catch (MessagingException e) {
            logger.error("send mail error from:{} to {} ,{}-{}", new String[] { sendFrom, Arrays.toString(sendTo), subject, sendContext });
            logger.error(e.getMessage(), e);
        }

    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSendForm(String sendForm) {
        this.sendForm = sendForm;
    }

}
