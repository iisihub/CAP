/* 
 * CapUserAuthenticationProvider.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.acl.providers;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import com.iisigroup.cap.security.model.CapUserDetails;

/**
 * <pre>
 * 檢核使用者帳號 / 密碼相關資訊
 * </pre>
 * 
 * @since 2012/10/4
 * @author iristu
 * @version <ul>
 *          <li>2012/10/4,iristu,new
 *          </ul>
 */
public class CapUserAuthenticationProvider extends DaoAuthenticationProvider {

	SessionRegistry sessionRegistry;

	MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) {
		CapUserDetails user = (CapUserDetails) userDetails;
		if (!user.isEnabled()) {
			// 使用者停用中，不得登入
			throw new BadCredentialsException(messages.getMessage(
					"UserAuthenticationProvider.noActive", "Bad credentials"));
		}
		// 檢核使用者是否已在其它地方登入
		List<SessionInformation> sessions = sessionRegistry.getAllSessions(
				authentication.getPrincipal(), false);

		if (sessions != null && !sessions.isEmpty()) {
			// 表示session已有登入記錄
			throw new SessionAuthenticationException(
					"UserAuthenticationProvider.loginOther");
		}
	}

	public void setSessionRegistry(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messages = new MessageSourceAccessor(messageSource);
	}

}
