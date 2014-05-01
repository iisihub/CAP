/* 
 * RoleFunction.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.auth.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="discriminator",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="P")
public class RoleFunction extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String rolCode;

	@Id
	@Column(length = 6)
	private String pgmCode;

	@Column(length = 10)
	private String updater;

	private Timestamp updTime;

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

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Timestamp getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Timestamp updTime) {
		this.updTime = updTime;
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
