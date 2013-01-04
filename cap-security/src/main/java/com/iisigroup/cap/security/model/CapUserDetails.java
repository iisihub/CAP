/* 
 * CapUserDetail.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <pre>
 * CapUserDetails
 * </pre>
 * 
 * @since 2012/5/15
 * @author rodeschen
 * @version <ul>
 *          <li>2012/5/15,rodeschen,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapUserDetails implements UserDetails, IUser {

	private String password;
	private String userId;
	private String userName;
	private String unitNo;
	private Map<String, String> roles;
	private JSONArray menu;
	private Locale locale;

	private Collection<GrantedAuthority> authorities;

	public CapUserDetails() {
	}

	public CapUserDetails(IUser user, String password, Map<String, String> roles) {
		this.password = password;
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.unitNo = user.getUnitNo();
		this.roles = new LinkedHashMap<String, String>();
		this.roles.putAll(roles);
		this.locale = user.getLocale();
		setAuthorities(roles);
	}

	protected void setAuthorities(Map<String, String> roles) {
		authorities = new ArrayList<GrantedAuthority>();
		for (String roleOid : roles.keySet()) {
			authorities.add(new GrantedAuthorityImpl(roleOid));
		}
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return userId;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public JSONArray getMenu() {
		return menu;
	}

	public void setMenu(JSONArray menu) {
		this.menu = menu;
	}

	public Map<String, String> getRoles() {
		return roles;
	}

	public void setRoles(Map<String, String> roles) {
		this.roles = roles;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.security.model.IUser#getUserName()
	 */
	@Override
	public String getUserName() {
		return userName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.security.model.IUser#getUnitNo()
	 */
	@Override
	public String getUnitNo() {
		return unitNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.security.model.IUser#getLocale()
	 */
	@Override
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;

	}

}
