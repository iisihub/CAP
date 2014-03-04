/* 
 * RoleFunction.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;

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
@Table(name = "DEF_RLF", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ROLCODE", "PGMCODE" }))
public class RoleFunction extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String rolCode;

	@Id
	@Column(length = 6)
	private String pgmCode;

	@Column(length = 10)
	private String UPDATER;

	private Timestamp UPDTIME;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name = "rolCode", referencedColumnName = "rolCode", nullable = false, insertable = false, updatable = false) })
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name = "pgmCode", referencedColumnName = "pgmCode", nullable = false, insertable = false, updatable = false) })
	private CodeItem pgm;

	public String getRolCode() {
		return rolCode;
	}

	public void setRolCode(String rolCode) {
		this.rolCode = rolCode;
	}

	public String getPgmCode() {
		return pgmCode;
	}

	public void setPgmCode(String pgmCode) {
		this.pgmCode = pgmCode;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public CodeItem getPgm() {
		return pgm;
	}

	public void setPgm(CodeItem pgm) {
		this.pgm = pgm;
	}
}
