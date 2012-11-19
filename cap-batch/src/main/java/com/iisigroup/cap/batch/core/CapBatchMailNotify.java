/* 
 * CapBatchStatusNotify.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.core;

import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.admin.web.JobParametersExtractor;
import org.springframework.batch.core.JobExecution;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;
import com.iisigroup.cap.formatter.ADDateTimeFormatter;
import com.iisigroup.cap.formatter.DurationFormatter;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapSystemConfig;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * <pre>
 * 排程執行結果通知
 * </pre>
 * 
 * @since 2012/11/16
 * @author iristu
 * @version <ul>
 *          <li>2012/11/16,iristu,new
 *          </ul>
 */
public class CapBatchMailNotify implements CapBatchNotify {

	private final Logger logger = LoggerFactory
			.getLogger(CapBatchMailNotify.class);

	private BatchJobService batchSerivce;
	private JavaMailSender mailSender;
	private CapSystemConfig config;
	private String messageTemplate;
	private JobParametersExtractor jobParametersExtractor = new JobParametersExtractor();

	public void notify(final BatchSchedule sch, final JobExecution job) {
		if (sch.isNotify() && !CapString.isEmpty(sch.getNotifyStatus())
				&& !CapString.isEmpty(sch.getNotifyTo())) {
			for (String status : sch.getNotifyStatus().split(",")) {
				if (CapString.trimNull(status).equals(
						job.getExitStatus().getExitCode())) {

					MimeMessagePreparator preparator = new MimeMessagePreparator() {
						public void prepare(MimeMessage mimeMessage)
								throws Exception {
							MimeMessageHelper mail = new MimeMessageHelper(
									mimeMessage, true, "utf-8");
							// 寄件人
							mail.setFrom(config.getProperty("mail.sender"));
							// 收件人
							mail.setTo(sch.getNotifyTo().split(","));
							String subject = MessageFormat
									.format(config
											.getProperty("batch.notifySubject"),
											new Object[] {
													sch.getSchId(),
													sch.getSchDesc(),
													job.getExitStatus()
															.getExitCode() });
							// 主旨
							mail.setSubject(subject);
							mail.setText(buildText(job), true);
						}
					};
					mailSender.send(preparator);
					logger.debug("send to {} ,{}-{}-{}",
							new String[] { sch.getNotifyTo(), sch.getSchId(),
									String.valueOf(job.getId()),
									job.getExitStatus().getExitCode() });
					break;
				}
			}
		}
	}// ;

	protected String buildText(JobExecution job) {
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(getClass(), "/");
		Map<String, Object> result = getExecutionResult(job);
		try {
			Template t = configuration.getTemplate(messageTemplate);
			Writer writer = new StringWriter();
			t.process(getExecutionResult(job), writer);
			return writer.toString();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "<html><body>" + result.toString().replace(",", ",<br/>")
				+ "</body></html>";
	}// ;

	private DurationFormatter durationFmt = new DurationFormatter("START_TIME",
			"END_TIME", "HH:mm:ss.SSS");

	private Map<String, Object> getExecutionResult(JobExecution job) {
		String exeId = String.valueOf(job.getId());
		Map<String, Object> map = batchSerivce.findExecutionDetail(exeId);
		map.put("duration", durationFmt.reformat(map));
		map.put("START_TIME",
				new ADDateTimeFormatter().reformat(map.get("START_TIME")));
		String jobParams = jobParametersExtractor
				.fromJobParameters(batchSerivce.findJobParams(exeId));
		map.put("jobParams", jobParams);
		List<Map<String, Object>> steps = batchSerivce.findSteps(exeId);
		for (Map<String, Object> step : steps) {
			step.put("duration", durationFmt.reformat(step));
		}
		map.put("stepInfos", steps);
		return map;
	}// ;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setConfig(CapSystemConfig config) {
		this.config = config;
	}

	public void setBatchSerivce(BatchJobService batchSerivce) {
		this.batchSerivce = batchSerivce;
	}

	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

}// ~
