/* 
 * CapBatchNotify.java
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

import org.springframework.batch.core.JobExecution;

import com.iisigroup.cap.batch.model.BatchSchedule;

/**
 * <pre>
 * CapBatchNotify
 * </pre>
 * 
 * @since 2012/11/16
 * @author iristu
 * @version <ul>
 *          <li>2012/11/16,iristu,new
 *          </ul>
 */
public interface CapBatchNotify {

	public void notify(BatchSchedule sch, JobExecution job);

}
