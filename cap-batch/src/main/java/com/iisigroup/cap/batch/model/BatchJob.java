/* 
 * BatchJob.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.model;

import java.sql.Timestamp;

import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * 排程JOB資訊檔
 * </pre>
 * 
 * @since 2012/11/5
 * @author iristu
 * @version <ul>
 *          <li>2012/11/5,iristu,new
 *          </ul>
 */
public class BatchJob extends GenericBean {

	private String jobId;
	/** job說明 */
	private String jobDesc;
	/** job設定檔 */
	private String jobResource;
	/** 修改操作者 */
	private String updater;
	/** 修改時間 */
	private Timestamp updateTime;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobResource() {
		return jobResource;
	}

	public void setJobResource(String jobResource) {
		this.jobResource = jobResource;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
