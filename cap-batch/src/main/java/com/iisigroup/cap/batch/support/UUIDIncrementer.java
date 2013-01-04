/* 
 * UUIDIncrementer.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.support;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import com.iisigroup.cap.utils.UUIDGenerator;

/**
 * <pre>
 * UUIDIncrementer
 * </pre>
 * 
 * @since 2012/11/14
 * @author iristu
 * @version <ul>
 *          <li>2012/11/14,iristu,new
 *          </ul>
 */
public class UUIDIncrementer implements JobParametersIncrementer {

	private static String ID_KEY = "uuid";

	private String key = ID_KEY;

	/**
	 * The name of the run id in the job parameters. Defaults to "run.id".
	 * 
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.batch.core.JobParametersIncrementer#getNext(org.
	 * springframework.batch.core.JobParameters)
	 */
	@Override
	public JobParameters getNext(JobParameters parameters) {
		JobParameters params = (parameters == null) ? new JobParameters()
				: parameters;
		return new JobParametersBuilder(params).addString(key,
				UUIDGenerator.getUUID()).toJobParameters();
	}
}
