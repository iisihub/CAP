/* 
 * CapJobExecutionlistener.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/11/16
 * @author iristu
 * @version <ul>
 *          <li>2012/11/16,iristu,new
 *          </ul>
 */
public class CapJobExecutionListener implements JobExecutionListener{

	private Logger log = LoggerFactory.getLogger(CapJobExecutionListener.class);

//	@AfterJob
	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("JOB COMPLETED with status {}", jobExecution.getStatus());
	}

//	@BeforeJob
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		
	}

}
