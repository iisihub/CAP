/* 
 * OpenAcct.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.bqd.poc.sample;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * 預約開戶
 * </pre>
 * 
 * @since 2013/5/7
 * @author iristu
 * @version <ul>
 *          <li>2013/5/7,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "OpenAcct", uniqueConstraints = @UniqueConstraint(columnNames = { "custId" }))
public class OpenAcct extends GenericBean implements IDataObject {

	@Id
	@Column(length = 20, nullable = false)
	private String custId;

	@Column
	@Lob
	private String jsonData;

	private Timestamp updateTime;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String getOid() {
		return custId;
	}

	@Override
	public void setOid(String oid) {

	}

}
