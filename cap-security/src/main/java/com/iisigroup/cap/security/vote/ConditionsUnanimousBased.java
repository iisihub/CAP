/*_
 * ConditionsUnanimousBased.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.security.vote;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.util.Assert;

/**
 * <pre>
 * 依據Config中所設定的access條件當作Voter
 * </pre>
 * 
 * @since 2011/1/20
 * @author iristu
 * @version <ul>
 *          <li>2011/1/20,iristu,new
 *          </ul>
 */
public class ConditionsUnanimousBased implements AccessDecisionManager,
		InitializingBean, MessageSourceAware {

	private Map<String, AccessDecisionVoter<Object>> conditionVoters;

	protected MessageSourceAccessor messages = SpringSecurityMessageSource
			.getAccessor();

	/**
	 * <pre>
	 * 依據Config中所設定的access條件當作Voter進行檢核
	 * </pre>
	 * 
	 * @param authentication
	 *            使用者登入資訊
	 * @param object
	 *            FilterInvocation
	 * @param configAttributes
	 *            ConfigAttributeDefinition
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) {
		int grant = 0;
		int abstain = 0;

		List<AccessDecisionVoter<Object>> decisionVoters = new ArrayList<AccessDecisionVoter<Object>>();

		Iterator<ConfigAttribute> configIter = configAttributes.iterator();

		while (configIter.hasNext()) {

			String s = ((ConfigAttribute) configIter.next()).getAttribute();

			if (conditionVoters.containsKey(s)) {
				AccessDecisionVoter<Object> voter = conditionVoters.get(s);
				if (voter instanceof RoleVoter) {
					((RoleVoter) voter).setRolePrefix(s);
				}
				decisionVoters.add(voter);
			}

		}

		Iterator<AccessDecisionVoter<Object>> voters = decisionVoters.iterator();

		while (voters.hasNext()) {
			AccessDecisionVoter<Object> voter = (AccessDecisionVoter<Object>) voters
					.next();
			int result = voter.vote(authentication, object, configAttributes);

			switch (result) {
			case AccessDecisionVoter.ACCESS_GRANTED:
				grant++;

				break;

			case AccessDecisionVoter.ACCESS_DENIED:
				throw new AccessDeniedException(messages.getMessage(
						"AbstractAccessDecisionManager.accessDenied",
						"Access is denied"));

			default:
				abstain++;

				break;
			}
		}

		// To get this far, there were no deny votes
		if (grant > 0) {
			return;
		} else if (abstain > 0) {
			throw new AccessDeniedException(messages.getMessage(
					"AbstractAccessDecisionManager.accessDenied",
					"Access is denied"));
		}

	}// ;

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return (getConditionVoters().containsKey(attribute.toString()));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		return true;
	}

	public Map<String, AccessDecisionVoter<Object>> getConditionVoters() {
		return conditionVoters;
	}

	public void setConditionVoters(
			Map<String, AccessDecisionVoter<Object>> conditionVoters) {
		this.conditionVoters = conditionVoters;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messages = new MessageSourceAccessor(messageSource);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notEmpty(this.conditionVoters,
				"AccessDecisionVoters is required");
	}

}// ~
