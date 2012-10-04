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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.security.dao.IUserDao;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.model.IUser;
import com.iisigroup.cap.utils.CapString;

/**
 * <p>
 * CapUserDetailsService implements UserDetailsService.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/9,iristu,new
 *          </ul>
 */
public class CapUserDetailsService implements UserDetailsService {

	private static final Log logger = LogFactory
			.getLog(CapUserDetailsService.class);

	MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) {
		if (CapString.isEmpty(username)) {
			throw new UsernameNotFoundException(
					messages.getMessage(
							"AbstractUserDetailsAuthenticationProvider.emptyCredentials",
							"Empty Credentials"));
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Security verification for user '" + username + "'");
		}

		IUser user = obtainAccount(username);

		if (user == null) {
			if (logger.isInfoEnabled()) {
				logger.info("Account " + username + " could not be found");
			}
			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.notFound", new Object[] { username },
					"Username {0} not found"), username);
		}

		String password = obtainPassword(username);

		Map<String, String> roles = obtainRole(user);
		if (CollectionUtils.isEmpty(roles)) {
			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.noAuthority", new Object[] { username },
					"User {0} has no GrantedAuthority"), username);
		}
		//
		// boolean enabled = user.isEnabled();
		// boolean accountNonExpired = true;
		// boolean credentialsNonExpired = true;
		// boolean accountNonLocked = true;
		return obtainUserDetails(user, password, roles);
	}

	public UserDetails obtainUserDetails(IUser user, String password,
			Map<String, String> roles) {
		return new CapUserDetails(user, password, roles);
	}

	private IUserDao<IUser> userDao;

	public void setUserDao(IUserDao<IUser> userDao) {
		this.userDao = userDao;
	}

	public IUserDao<IUser> getUserDao() {
		return userDao;
	}

	/**
	 * Return the user depending on the login provided by spring security.
	 * 
	 * @return the user if found
	 */
	protected IUser obtainAccount(String login) {
		return userDao.getUserByLoginId(login, null);
	}

	@SuppressWarnings("unchecked")
	protected Map<String, String> obtainRole(IUser user) {
		Map<String, String> mRoles = new HashMap<String, String>();
		List<IRole> roles = (List<IRole>) userDao.getRoleByUser(user);
		if (roles != null) {
			for (int i = 0; i < roles.size(); i++) {
				IRole role = roles.get(i);
				mRoles.put(role.getOid(), role.getRoleName());
			}
		}
		return mRoles;
	}

	/**
	 * Returns null. Subclass may override it to provide their own password.
	 */
	protected String obtainPassword(String username) {
		return "";
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messages = new MessageSourceAccessor(messageSource);
	}

}
