/* 
 * SysParm.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;

/**
 * <p>
 * 系統參數檔.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/9/6,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CFG_SYSPARM", uniqueConstraints = @UniqueConstraint(columnNames = "parmId"))
public class SysParm extends GenericBean implements IDataObject {

	/** 參數id */
	@Id
	@Column(length = 30, nullable = false)
	private String parmId;
	/** 參數數值 */
	@Column(length = 300, nullable = false)
	private String parmValue;
	/** 參數描述 */
	@Column(length = 300)
	private String parmDesc;
	/** 修改操作者 */
	@Column(length = 10)
	private String updater;
	/** 修改時間 */
	private Timestamp updateTime;

	public String getParmId() {
		return parmId;
	}

	public void setParmId(String parmId) {
		this.parmId = parmId;
	}

	public String getParmValue() {
		return parmValue;
	}

	public void setParmValue(String parmValue) {
		this.parmValue = parmValue;
	}

	public String getParmDesc() {
		return parmDesc;
	}

	public void setParmDesc(String parmDesc) {
		this.parmDesc = parmDesc;
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

	@Override
	public String getOid() {
		return this.parmId;
	}

	@Override
	public void setOid(String oid) {
		this.parmId = oid;
	}

}
