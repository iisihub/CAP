/* 
 * Bulletin.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <p>
 * 通告訊息管理.
 * </p>
 * 
 * @author tammy
 * @version <ul>
 *          <li>2014/1/27,tammy,new
 *          </ul>
 */
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "CFG_Bulletin", uniqueConstraints = @UniqueConstraint(columnNames = "oid"))
public class Bulletin extends GenericBean implements IDataObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 32)
	private String oid;

	@Column(length = 300)
	private String title;

	@Column(length = 2000)
	private String content;

	private int level;

	@Column(columnDefinition = "DATE")
	private Date startDate;

	@Column(columnDefinition = "DATE")
	private Date endDate;

	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp crTime;

	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp updTime;

	@Column(length = 10)
	private String updater;

	@Column(length = 1)
	private String status;

	@Column(length = 5)
	private String locale;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Timestamp getCrTime() {
		return crTime;
	}

	public void setCrTime(Timestamp crTime) {
		this.crTime = crTime;
	}

	public Timestamp getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Timestamp updTime) {
		this.updTime = updTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
