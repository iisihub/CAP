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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.corundumstudio.socketio.SocketIOClient;

/**
 * <pre>
 * CapUserDetails
 * </pre>
 * 
 * @since 2012/5/15
 * @author rodeschen
 * @version <ul>
 *          <li>2012/5/15,rodeschen,new
 *          <li>2013/3/6,rodeschen,add set method
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapUserDetails implements UserDetails {

    private String password;
    private String userId;
    private String userName;
    private String unitNo;
    private Map<String, String> roles;
    private JSONArray menu;
    private Locale locale;
    private String status;
    private SocketIOClient socketClient;

    private Collection<GrantedAuthority> authorities;

    public CapUserDetails() {
    }

    public CapUserDetails(IUser user, String password, Map<String, String> roles) {
        this.password = password;
        this.userId = user.getCode();
        this.userName = user.getName();
        this.unitNo = user.getDepCode();
        this.roles = new LinkedHashMap<String, String>();
        this.roles.putAll(roles);
        this.locale = user.getLocale();
        this.status = user.getStatus();
        setAuthorities(roles);
    }

    protected void setAuthorities(Map<String, String> roles) {
        authorities = new ArrayList<GrantedAuthority>();
        for (String roleOid : roles.keySet()) {
            authorities.add(new SimpleGrantedAuthority(roleOid));
        }
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
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

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;

    }

    public void setUserName(String userName) {
        this.userName = userName;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SocketIOClient getSocketClient() {
        return socketClient;
    }

    public void setSocketClient(SocketIOClient socketClient) {
        this.socketClient = socketClient;
    }

}
