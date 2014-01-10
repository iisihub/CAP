/* 
 * ErrorCode.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.StringUtils;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.utils.StrUtils;

/**
 * <pre>
 * 訊息代碼
 * </pre>
 * 
 * @since 2011/08/02
 * @author UFO
 * @version <ul>
 *          <li>2011/08/02,UFO,new
 *          </ul>
 */
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "CFG_ErrorCode", uniqueConstraints = @UniqueConstraint(columnNames = {
		"code", "locale" }))
public class ErrorCode extends GenericBean implements IDataObject {
	private static final long serialVersionUID = 1L;

	public static final String CODE_ALL = "EFDXXXX";

	private static final String SEPARATOR = "|";

	@Id
	@Column(unique = true, nullable = false, length = 32)
	private String oid;

	/**
	 * 狀況代碼
	 */
	@Column(unique = true, nullable = false, length = 20)
	private String code;

	/**
	 * 語言別
	 */
	@Column(nullable = false, length = 5)
	private String locale;

	/**
	 * 等級(INFO/ERROR/WARN)
	 */
	@Column(length = 5)
	private String severity;

	/**
	 * 狀況說明
	 */
	@Column(length = 1024)
	private String message;

	/**
	 * 建議處理方式
	 */
	@Column(length = 1024)
	private String suggestion;

	/**
	 * 系統別
	 */
	@Column(length = 5)
	private String sysId;

	/**
	 * 是否送監控
	 */
	@Column(length = 1)
	private String sendMon;

	/**
	 * Help URL
	 */
	@Column(length = 128)
	private String helpURL;

	/**
	 * 最後修改人
	 */
	@Column(length = 6)
	private String lastModifyBy;

	/**
	 * 最後修改時間
	 */
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp lastModifyTime;

	/**
	 * get the code
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * set the code
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * get the locale
	 * 
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * get the locale
	 * 
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * get the severity
	 * 
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * set the severity
	 * 
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * get the message
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * set the message
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * get the suggestion
	 * 
	 * @return the suggestion
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * set the suggestion
	 * 
	 * @param suggestion
	 *            the suggestion to set
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * get the lastmodif
	 * 
	 * @return the lastModifyTime
	 */
	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	/**
	 * set the lastModifyTime
	 * 
	 * @param lastModifyTime
	 *            the lastModiryTime to set
	 */
	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	/**
	 * get the lastModifyBy
	 * 
	 * @return the lastModifyBy
	 */
	public String getLastModifyBy() {
		return lastModifyBy;
	}

	/**
	 * set the lastModifyBy
	 * 
	 * @param lastModifyBy
	 *            the lastModifyBy to set
	 */
	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.model.IDataObject#getOid()
	 */
	public String getOid() {
		return this.oid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.model.IDataObject#setOid(java.lang.String)
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * get the sysId
	 * 
	 * @return the sysId
	 */
	public String getSysId() {
		return sysId;
	}

	/**
	 * @return the sendMon
	 */
	public String getSendMon() {
		return sendMon;
	}

	public boolean isSendMon() {
		return "Y".equalsIgnoreCase(StringUtils.trimToEmpty(this.sendMon));
	}

	/**
	 * @param sendMon
	 *            the sendMon to set
	 */
	public void setSendMon(String sendMon) {
		this.sendMon = sendMon;
	}

	/**
	 * @return the helpURL
	 */
	public String getHelpURL() {
		return helpURL;
	}

	/**
	 * @param helpURL
	 *            the helpURL to set
	 */
	public void setHelpURL(String helpURL) {
		this.helpURL = helpURL;
	}

	/**
	 * set the sysId
	 * 
	 * @param sysId
	 *            the sysId to set
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getMonitorHelpURL() {
		String tmpHelpUrl = StringUtils.trimToEmpty(this.helpURL);
		return "".equals(tmpHelpUrl) ? "N/A" : this.helpURL;
	}

	public String getMonitorSeverity() {
		String tmpSeverity = StringUtils.trimToEmpty(this.severity);
		return "".equals(tmpSeverity) || tmpSeverity.length() <= 0 ? "I"
				: tmpSeverity.substring(0, 1);
	}

	public String getI18nPropString() {
		return StrUtils.concat(this.severity, SEPARATOR, this.message,
				SEPARATOR, StringUtils.trimToEmpty(this.suggestion));
	}

}
