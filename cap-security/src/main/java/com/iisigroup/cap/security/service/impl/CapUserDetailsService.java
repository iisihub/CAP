/*
 * CapUserDetailsService.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.iisigroup.cap.security.dao.SecUserDao;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.security.model.Role;
import com.iisigroup.cap.security.model.User;
import com.iisigroup.cap.utils.CapString;

/**
 * <p>
 * CapUserDetailsService implements UserDetailsService.
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/9,iristu,new
 *          </ul>
 */
public class CapUserDetailsService implements UserDetailsService {

    private static final Log logger = LogFactory.getLog(CapUserDetailsService.class);

    /*
     * (non-Javadoc)
     * 
     * @seeorg.springframework.security.userdetails.UserDetailsService# loadUserByUsername(java.lang.String)
     */
    public UserDetails loadUserByUsername(String username) {
        if (CapString.isEmpty(username)) {
            throw new UsernameNotFoundException("Empty login");
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Security verification for user '" + username + "'");
        }

        User user = obtainAccount(username);

        if (user == null) {
            if (logger.isInfoEnabled()) {
                logger.info("Account " + username + " could not be found");
            }
            throw new UsernameNotFoundException("account " + username + " could not be found");
        }

        String password = obtainPassword(user);

        Map<String, String> roles = obtainRole(user);
        // TODO
        //
        // boolean enabled = user.isEnabled();
        // boolean accountNonExpired = true;
        // boolean credentialsNonExpired = true;
        // boolean accountNonLocked = true;
        return obtainUserDetails(user, password, roles);

    }

    public UserDetails obtainUserDetails(User user, String password, Map<String, String> roles) {
        return new CapUserDetails(user, password, roles);
    }

    @Resource
    private SecUserDao<User> userDao;

    /**
     * Return the user depending on the login provided by spring security.
     * 
     * @return the user if found
     */
    protected User obtainAccount(String login) {
        return userDao.getUserByLoginId(login, null);
    }

    @SuppressWarnings("unchecked")
    protected Map<String, String> obtainRole(User user) {
        Map<String, String> mRoles = new HashMap<String, String>();
        List<Role> roles = (List<Role>) userDao.getRoleByUser(user);
        if (roles != null) {
            for (int i = 0; i < roles.size(); i++) {
                Role role = roles.get(i);
                mRoles.put(role.getCode(), role.getName());
            }
        }
        return mRoles;
    }

    /**
     * Default password encoding algorithm is SHA-256. Subclass may override it to provide their own password.
     */
    protected String obtainPassword(User user) {
        return user.getPassword();
    }

}
