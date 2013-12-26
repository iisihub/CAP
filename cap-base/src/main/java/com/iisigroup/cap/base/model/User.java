/* 
 * ElsUser.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.model.IUser;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 使用者資訊
 * </pre>
 * 
 * @since 2013/12/23
 * @author tammy
 * @version <ul>
 *          <li>2013/12/23,tammy,new
 *          </ul>
 */

@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_USR")
public class User extends GenericBean implements IUser {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, length = 32)
	private String oid;

	@Column(name = "STAFFPID", length = 10)
	private String userId;

	@Column(name = "STAFFPNM", length = 12)
	private String userName;

	@Column(name = "DEPARTNO", length = 4)
	private String unitNo;

	@Column(length = 1)
	private String APPLYYNF;

	@Column(length = 30)
	private String APPLYREM;

	@Column(precision = 5, scale = 2)
	private BigDecimal WEIGHTS;

	@Column(length = 6)
	private String UPDATER;

	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp UPDATETIME;

	/**
	 * @return Oid
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * @param oid
	 *            oid
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		userName = CapString.trimFullSpace(userName);
		this.userName = userName;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	@Override
	public String getAPPLYYNF() {
		return APPLYYNF;
	}

	public void setAPPLYYNF(String aPPLYYNF) {
		APPLYYNF = aPPLYYNF;
	}

	@Override
	public String getAPPLYREM() {
		return APPLYREM;
	}

	public void setAPPLYREM(String aPPLYREM) {
		APPLYREM = aPPLYREM;
	}

	@Override
	public BigDecimal getWEIGHTS() {
		return WEIGHTS;
	}

	public void setWEIGHTS(BigDecimal wEIGHTS) {
		WEIGHTS = wEIGHTS;
	}

	@Override
	public String getUPDATER() {
		return UPDATER;
	}

	public void setUPDATER(String uPDATER) {
		UPDATER = uPDATER;
	}

	@Override
	public Timestamp getUPDATETIME() {
		return UPDATETIME;
	}

	public void setUPDATETIME(Timestamp uPDATETIME) {
		UPDATETIME = uPDATETIME;
	}

	@Override
	public List<? extends IRole> getRoles() {
		return null;
	}

	@Override
	public Locale getLocale() {
		return null;
	}
}
