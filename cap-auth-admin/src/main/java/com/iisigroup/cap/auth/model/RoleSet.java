/* 
 * RoleSet.java
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
@Table(name = "DEF_RLSET", uniqueConstraints = @UniqueConstraint(columnNames = {
		"STAFFPID", "ROLCODE" }))
public class RoleSet extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STAFFPID", length = 10)
	private String userId;

	@Id
	@Column(length = 10)
	private String rolCode;

	@Column(length = 10)
	private String updater;

	private Timestamp updateTime;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name = "ROLCODE", referencedColumnName = "ROLCODE", nullable = false, insertable = false, updatable = false) })
	private Role roleSet_role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name = "STAFFPID", referencedColumnName = "STAFFPID", nullable = false, insertable = false, updatable = false) })
	private User roleSet_usr;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRolCode() {
		return rolCode;
	}

	public void setRolCode(String rolCode) {
		this.rolCode = rolCode;
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

	public Role getRole() {
		return roleSet_role;
	}

	public void setRole(Role role) {
		this.roleSet_role = role;
	}

	public User getUsr() {
		return roleSet_usr;
	}

	public void setUsr(User usr) {
		this.roleSet_usr = usr;
	}

}
