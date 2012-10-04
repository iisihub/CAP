/* 
 * CapUser.java
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

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.security.model.IUser;

/**
 * <pre>
 * 使用者資訊
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
@Table(name = "UserPR", uniqueConstraints = @UniqueConstraint(columnNames = { "userId" }))
public class CapUser implements IUser {

	@Id
	@Column(nullable = false, length = 10)
	private String userId;

	@Column(length = 30)
	private String userName;

	@Column(length = 5)
	private String unitNo;

	@ManyToMany
	@JoinTable(name = "UserRoleMapping", 
		joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "userId") }, 
		inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId") })
	private List<CapRole> userRoles;

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
		this.userName = userName;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public List<CapRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<CapRole> userRoles) {
		this.userRoles = userRoles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.security.model.IUser#getRoles()
	 */
	@Override
	public Map<String, String> getRoles() {
		Map<String, String> rs = new HashMap<String, String>();
		if (userRoles != null && !userRoles.isEmpty()) {
			for (CapRole r : this.userRoles) {
				rs.put(r.getRoleId(), r.getRoleName());
			}
		}
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.security.model.IUser#getLocale()
	 */
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

}
