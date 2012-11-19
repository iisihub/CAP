/* 
 * JobLauncherDetail.java
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

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.iisigroup.cap.batch.constants.CapBatchConstants;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;

/**
 * <pre>
 * JobLauncherDetail
 * </pre>
 * 
 * @since 2012/11/1
 * @author iristu
 * @version <ul>
 *          <li>2012/11/1,iristu,new
 *          </ul>
 */
public class JobLauncherDetail extends QuartzJobBean implements
		CapBatchConstants {

	private static Logger logger = LoggerFactory
			.getLogger(JobLauncherDetail.class);

	private JobLocator jobLocator;
	private JobLauncher jobLauncher;
	private JobParametersIncrementer defaultIncrementer;
	private BatchJobService batchService;
	private BatchSchedule batchSchedule;
	private CapBatchNotify batchNotify;

	@SuppressWarnings("rawtypes")
	protected void executeInternal(JobExecutionContext context) {
		Map jobDataMap = context.getMergedJobDataMap();
		String jobName = (String) jobDataMap.get(JOB_NAME);
		logger.info("Quartz trigger firing with Spring Batch jobName="
				+ jobName);
		JobParameters jobParameters = getJobParametersFromJobMap(jobDataMap);
		JobExecution jobExecution = null;
		try {
			// 放入defaultIncrementer要確保不會有重覆的Parameters出現
			jobParameters = defaultIncrementer.getNext(jobParameters);
			Job job = jobLocator.getJob(jobName);
			if (job.getJobParametersIncrementer() != null) {
				jobParameters = job.getJobParametersIncrementer().getNext(
						jobParameters);
			}
			jobExecution = jobLauncher.run(job, jobParameters);
		} catch (JobExecutionException e) {
			logger.error("Could not execute job.", e);
		} finally {
			if (jobExecution != null) {
				Long exId = jobExecution.getId();
				batchService.updateExecution(exId,
						(String) jobDataMap.get(EXECUTOR));
				batchNotify.notify(batchSchedule, jobExecution);
			}
		}
	}

	/**
	 * Copy parameters that are of the correct type over to
	 * {@link JobParameters}, ignoring jobName.
	 * 
	 * @return a {@link JobParameters} instance
	 */
	@SuppressWarnings("rawtypes")
	private JobParameters getJobParametersFromJobMap(Map jobDataMap) {
		Field[] fields = this.getClass().getDeclaredFields();
		Set<String> ignores = new HashSet<String>(fields.length);
		for (Field f : fields) {
			ignores.add(f.getName());
		}
		ignores.add(JOB_NAME);
		ignores.add(EXECUTOR);
		JobParametersBuilder builder = new JobParametersBuilder();
		for (Iterator iterator = jobDataMap.entrySet().iterator(); iterator
				.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if (ignores.contains(key)) {
				continue;
			}
			if (value instanceof String) {
				builder.addString(key, (String) value);
			} else if (value instanceof Float || value instanceof Double) {
				builder.addDouble(key, (Double) value);
			} else if (value instanceof Integer || value instanceof Long) {
				builder.addLong(key, (Long) value);
			} else if (value instanceof Date) {
				builder.addDate(key, (Date) value);
			} else {
				logger.debug("JobDataMap contains values which are not job parameters (ignoring).");
			}
		}
		return builder.toJobParameters();
	}

	/**
	 * Public setter for the {@link JobLocator}.
	 * 
	 * @param jobLocator
	 *            the {@link JobLocator} to set
	 */
	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	/**
	 * Public setter for the {@link JobLauncher}.
	 * 
	 * @param jobLauncher
	 *            the {@link JobLauncher} to set
	 */
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public void setBatchService(BatchJobService batchService) {
		this.batchService = batchService;
	}

	public void setDefaultIncrementer(
			JobParametersIncrementer defaultIncrementer) {
		this.defaultIncrementer = defaultIncrementer;
	}

	public void setBatchSchedule(BatchSchedule batchSchedule) {
		this.batchSchedule = batchSchedule;
	}

	public void setBatchNotify(CapBatchNotify batchNotify) {
		this.batchNotify = batchNotify;
	}

}
