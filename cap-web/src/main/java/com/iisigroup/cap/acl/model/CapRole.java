/* 
 * CapRole.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.acl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.security.model.IRole;

/**
 * <pre>
 * 角色資訊
 * </pre>
 * 
 * @since 2012/10/3
 * @author iristu
 * @version <ul>
 *          <li>2012/10/3,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "RolePR", uniqueConstraints = @UniqueConstraint(columnNames = { "roleId" }))
public class CapRole implements IRole {

	@Transient
	private String oid;

	@Id
	@Column(nullable = false, length = 10)
	private String roleId;

	@Column(length = 30)
	private String roleName;

	public String getOid() {
		return roleId;
	}

	public void setOid(String oid) {
		//this.oid = oid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
