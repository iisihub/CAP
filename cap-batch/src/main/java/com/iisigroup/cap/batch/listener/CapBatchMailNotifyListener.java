/* 
 * CapBatchMailNotifyListener.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.listener;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.admin.web.JobParametersExtractor;
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.iisigroup.cap.base.service.EmailService;
import com.iisigroup.cap.batch.constants.CapBatchConstants;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;
import com.iisigroup.cap.formatter.impl.ADDateTimeFormatter;
import com.iisigroup.cap.formatter.impl.DurationFormatter;
import com.iisigroup.cap.utils.CapString;

import freemarker.template.Template;

/**
 * <pre>
 * email傳送排程結果
 * </pre>
 * 
 * @since 2012/11/27
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/11/27,iristu,new
 *          </ul>
 */
public class CapBatchMailNotifyListener implements JobListener, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(CapBatchMailNotifyListener.class);

    private BatchJobService batchSerivce;
    private EmailService mailSender;
    private JobParametersExtractor jobParametersExtractor;

    private FreeMarkerConfigurer fmConfg;
    private String messageTemplate;

    private String mailSubject;

    /*
     * (non-Javadoc)
     * 
     * @see org.quartz.JobListener#jobWasExecuted(org.quartz.JobExecutionContext, org.quartz.JobExecutionException)
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        String jobName = context.getJobDetail().getKey().getName();
        final BatchSchedule sch = batchSerivce.findSchById(jobName);
        final JobExecution job = (JobExecution) context.get(CapBatchConstants.K_JobExecution);
        if (sch != null && job != null) {
            if (sch.isNotify() && !CapString.isEmpty(sch.getNotifyStatus()) && !CapString.isEmpty(sch.getNotifyTo())) {
                for (String status : sch.getNotifyStatus().split(",")) {
                    if (CapString.trimNull(status).equals(job.getExitStatus().getExitCode())) {
                        // 主旨
                        String subject = MessageFormat.format(mailSubject, new Object[] { sch.getSchId(), sch.getSchDesc(), job.getExitStatus().getExitCode() });
                        mailSender.sendEmail(sch.getNotifyTo().split(","), subject, buildText(job));
                        break;
                    }
                }
            }
        }
    }

    protected String buildText(JobExecution job) {
        Map<String, Object> result = getExecutionResult(job);
        try {
            Template t = fmConfg.getConfiguration().getTemplate(messageTemplate);
            return FreeMarkerTemplateUtils.processTemplateIntoString(t, result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new StringBuffer("<html><body>").append(result.toString().replace(",", ",<br/>")).append("</body></html>").toString();
    }

    private DurationFormatter durationFmt = new DurationFormatter("START_TIME", "END_TIME", "HH:mm:ss.SSS");

    private Map<String, Object> getExecutionResult(JobExecution job) {
        String exeId = String.valueOf(job.getId());
        Map<String, Object> map = batchSerivce.findExecutionDetail(exeId);
        map.put("duration", durationFmt.reformat(map));
        map.put("START_TIME", new ADDateTimeFormatter().reformat(map.get("START_TIME")));
        String jobParams = jobParametersExtractor.fromJobParameters(batchSerivce.findJobParams(exeId));
        map.put("jobParams", jobParams);
        List<Map<String, Object>> steps = batchSerivce.findSteps(exeId);
        for (Map<String, Object> step : steps) {
            step.put("duration", durationFmt.reformat(step));
        }
        map.put("stepInfos", steps);
        return map;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.quartz.JobListener#getName()
     */
    @Override
    public String getName() {
        return "CapBatchMailNotifyListener";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.quartz.JobListener#jobToBeExecuted(org.quartz.JobExecutionContext)
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.debug("Job : {} is going to start...", new String[] { context.getJobDetail().getKey().getName() });
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.quartz.JobListener#jobExecutionVetoed(org.quartz.JobExecutionContext)
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.debug("Job : {} execution vetoed", new String[] { context.getJobDetail().getKey().getName() });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jobParametersExtractor = new JobParametersExtractor();
    }

    public void setBatchSerivce(BatchJobService batchSerivce) {
        this.batchSerivce = batchSerivce;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public void setMailSender(EmailService mailSender) {
        this.mailSender = mailSender;
    }

    public void setFmConfg(FreeMarkerConfigurer fmConfg) {
        this.fmConfg = fmConfg;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

}
