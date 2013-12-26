/* 
 * Role.java
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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.security.model.IRole;

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
@Table(name = "DEF_RLE", uniqueConstraints = @UniqueConstraint(columnNames = { "ROLCODE" }))
public class Role extends GenericBean implements IRole {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLCODE", length = 10)
	private String roleId;

	@Column(length = 48)
	private String roleName;

	@Column(length = 1)
	private String SYSTYP;

	@Column(length = 1)
	private String UNIT;

	@Column(length = 1)
	private String STU;

	@Column(length = 60)
	private String NOTE;

	@Column(length = 10)
	private String UPDATER;

	private Timestamp UPDTIME;

	@Column(length = 10)
	private String APPRID;

	private Timestamp APPRTIME;

	@Override
	public String getRoleId() {
		return roleId;
	}
	@Override
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public String getRoleName() {
		return roleName;
	}
	@Override
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getSYSTYP() {
		return SYSTYP;
	}

	public void setSYSTYP(String sYSTYP) {
		SYSTYP = sYSTYP;
	}

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}

	public String getSTU() {
		return STU;
	}

	public void setSTU(String sTU) {
		STU = sTU;
	}

	public String getNOTE() {
		return NOTE;
	}

	public void setNOTE(String nOTE) {
		NOTE = nOTE;
	}

	public String getUPDATER() {
		return UPDATER;
	}

	public void setUPDATER(String uPDATER) {
		UPDATER = uPDATER;
	}

	public Timestamp getUPDTIME() {
		return UPDTIME;
	}

	public void setUPDTIME(Timestamp uPDTIME) {
		UPDTIME = uPDTIME;
	}

	public String getAPPRID() {
		return APPRID;
	}

	public void setAPPRID(String aPPRID) {
		APPRID = aPPRID;
	}

	public Timestamp getAPPRTIME() {
		return APPRTIME;
	}

	public void setAPPRTIME(Timestamp aPPRTIME) {
		APPRTIME = aPPRTIME;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
