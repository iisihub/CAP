/* 
 * CapSecurityContext.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security;

import java.net.InetAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.iisigroup.cap.security.model.CapUserDetails;

/**
 * <pre>
 * CapSecurityContext
 * </pre>
 * 
 * @since 2011/11/4
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/4,rodeschen,new
 *          </ul>
 */
public class CapSecurityContext {

    /**
     * <pre>
     * 取得Spring Security登入者的user information.
     * </pre>
     * 
     * @param <T>
     *            T extends IUser
     * @return T T extends IUser
     */
    @SuppressWarnings("unchecked")
    public static <T extends CapUserDetails> T getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // if (auth != null
        // && auth.getDetails() instanceof CapAuthenticationDetails) {
        // CapAuthenticationDetails detail = (CapAuthenticationDetails) auth
        // .getDetails();
        // return ((T) detail.getUserDetails());
        // }
        if (auth != null) {
            return (T) auth.getPrincipal();
        }
        return (T) getDefautlUserDetails();
    }

    /**
     * <pre>
     * 取得使用者代號
     * </pre>
     * 
     * @return String
     */
    public static String getUserId() {
        CapUserDetails user = getUser();
        if (user != null) {
            return user.getUserId();
        }
        return null;
    }

    /**
     * <pre>
     * 使用者名稱
     * </pre>
     * 
     * @return String
     */
    public static String getUserName() {
        CapUserDetails user = getUser();
        if (user != null) {
            return user.getUserName();
        }
        return null;
    }

    /**
     * <pre>
     * 使用者單位代碼
     * </pre>
     * 
     * @return String
     */
    public static String getUnitNo() {
        CapUserDetails user = getUser();
        if (user != null) {
            return user.getUnitNo();
        }
        return null;
    }

    public static Locale getLocale() {
        CapUserDetails user = getUser();
        Locale locale = null;
        if (user != null) {
            locale = user.getLocale();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }

    public static Collection<? extends GrantedAuthority> getAuthorities() {
        UserDetails user = getUser();
        if (user != null) {
            return user.getAuthorities();
        }
        return null;
    }

    public static Set<String> getRoleIds() {
        Set<String> roleOids = new HashSet<String>();
        Collection<? extends GrantedAuthority> auths = getAuthorities();
        for (GrantedAuthority auth : auths) {
            if (AuthenticatedVoter.IS_AUTHENTICATED_ANONYMOUSLY.equals(auth.getAuthority())) {
                continue;
            }
            roleOids.add(auth.getAuthority());
        }
        return roleOids;
    }

    private static CapUserDetails getDefautlUserDetails() {
        CapUserDetails user = new CapUserDetails();
        String userId = "";
        try {
            userId = InetAddress.getLocalHost().getHostName();
        } catch (java.net.UnknownHostException uhe) {
            userId = "UNKNOWN";
        }
        user.setUserId(userId);
        user.setUserName(userId);
        user.setUnitNo("999");
        return user;
    }// ;
}
