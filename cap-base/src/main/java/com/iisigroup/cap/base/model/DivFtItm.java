/* 
 * CodeType.java
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
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * Division Factor Item
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DIVFTITM", uniqueConstraints = @UniqueConstraint(columnNames = {
		"factorNo" }))
public class DivFtItm extends GenericBean implements IDataObject {

	@Id
	@Column(nullable = false, length = 32)
	private String oid;

	@NotNull
	@Column(length = 10, nullable = false)
	private String factorNo;

	@Column(length = 60)
	private String factorNm;

//	/** DB資料表 */
//	@Column(length = 20)
//	private String tableNm;

//	/** DB欄位 */
//	@Column(length = 20)
//	private String columnNm;

	/** 屬性 */
	@Column(length = 1)
	private String dataType;

//	/** 摘要 */
//	@Column(length = 200)
//	private String factorEm;

	/** 值域 */
	@Column(length = 60)
	private String factJson;
	
//	@Column(length = 1)
//	private String inputFlg;

	@Column(length = 6)
	private String updater;

	@Column
	private Timestamp updateTime;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getFactorNo() {
		return factorNo;
	}

	public void setFactorNo(String factorNo) {
		this.factorNo = factorNo;
	}

	public String getFactorNm() {
		return factorNm;
	}

	public void setFactorNm(String factorNm) {
		this.factorNm = factorNm;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return 值域JSON
	 */
	public String getFactJson() {
		return factJson;
	}

	/**
	 * 值域JSON
	 * @param factJson
	 */
	public void setFactJson(String factJson) {
		this.factJson = factJson;
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
