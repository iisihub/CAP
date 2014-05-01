/* 
 * Role.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.auth.model;

import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.OneToMany;
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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="discriminator",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="P")
public class Role extends GenericBean implements IRole {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLCODE", length = 10)
	private String roleId;

	@Column(length = 48)
	private String rolName;

	@Column(length = 1)
	private String sysTyp;

	@Column(length = 1)
	private String unit;

	@Column(length = 1)
	private String stu;

	@Column(length = 60)
	private String note;

	@Column(length = 10)
	private String updater;

	private Timestamp updTime;

	@Column(length = 10)
	private String apprId;

	private Timestamp apprTime;

	@OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<RoleFunction> rlfList;

	@OneToMany(mappedBy = "roleSet_role", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<RoleSet> rlSet;

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
		return rolName;
	}

	@Override
	public void setRoleName(String roleName) {
		this.rolName = roleName;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public String getSysTyp() {
		return sysTyp;
	}

	public void setSysTyp(String sysTyp) {
		this.sysTyp = sysTyp;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStu() {
		return stu;
	}

	public void setStu(String stu) {
		this.stu = stu;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public String getApprId() {
		return apprId;
	}

	public void setApprId(String apprId) {
		this.apprId = apprId;
	}

	public Timestamp getApprTime() {
		return apprTime;
	}

	public void setApprTime(Timestamp apprTime) {
		this.apprTime = apprTime;
	}

	public List<RoleSet> getRlSet() {
		return rlSet;
	}

	public void setRlSet(List<RoleSet> rlSet) {
		this.rlSet = rlSet;
	}

	public List<RoleFunction> getRlfList() {
		return rlfList;
	}

	public void setRlfList(List<RoleFunction> rlfList) {
		this.rlfList = rlfList;
	}

	public List<RoleSet> getrSetList() {
		return rlSet;
	}

	public void setrSetList(List<RoleSet> rSetList) {
		this.rlSet = rSetList;
	}

}
