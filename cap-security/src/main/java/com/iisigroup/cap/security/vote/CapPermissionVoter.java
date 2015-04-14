/*
 * CapPermissionVoter.java
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
package com.iisigroup.cap.security.vote;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.service.IAccessControlService;

/**
 * <p>
 * url checker anonymous
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/9/27,iristu,new
 *          </ul>
 */
public class CapPermissionVoter extends RoleVoter {

    protected IAccessControlService securityService;

    @SuppressWarnings("rawtypes")
    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        int result = ACCESS_ABSTAIN;
        Iterator iter = attributes.iterator();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        while (iter.hasNext()) {
            ConfigAttribute attribute = (ConfigAttribute) iter.next();

            if (this.supports(attribute)) {
                result = ACCESS_DENIED;

                FilterInvocation filterInvocation = (FilterInvocation) object;

                String url = getRequestURL(filterInvocation);

                List<IRole> roles = securityService.getAuthRolesByUrl(url);

                if (roles != null && !roles.isEmpty()) {

                    // Attempt to find a matching granted authority
                    for (IRole role : roles) {
                        for (GrantedAuthority auth : authorities) {
                            if (auth.getAuthority().equals(role.getCode())) {
                                return ACCESS_GRANTED;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }// ;

    public void setSecurityService(IAccessControlService securityService) {
        this.securityService = securityService;
    }

    private boolean stripQueryStringFromUrls;

    public boolean isStripQueryStringFromUrls() {
        return stripQueryStringFromUrls;
    }

    public void setStripQueryStringFromUrls(boolean stripQueryStringFromUrls) {
        this.stripQueryStringFromUrls = stripQueryStringFromUrls;
    }

    /**
     * Gets the request url.
     * 
     * @param filter
     *            the filter
     * 
     * @return the request url
     */
    protected String getRequestURL(FilterInvocation filter) {
        String url = filter.getRequestUrl();

        if (stripQueryStringFromUrls) {
            // Strip anything after a question mark symbol, as per SEC-161. See
            // also SEC-321
            int firstQuestionMarkIndex = url.indexOf("?");
            if (firstQuestionMarkIndex != -1) {
                url = url.substring(0, firstQuestionMarkIndex);
            }
        } else {
            int firstQuestionMarkIndex = url.indexOf("?");
            if (firstQuestionMarkIndex != -1) {
                String queryString = url.substring(firstQuestionMarkIndex + 1);
                StringBuffer newQueryString = new StringBuffer();
                String[] query = queryString.split("&");
                for (String q : query) {
                    if (q.startsWith("x=") || q.startsWith("jsessionid=")) {
                        continue;
                    } else {
                        newQueryString.append(q).append('&');
                    }
                }
                if (newQueryString.length() > 0) {
                    newQueryString.deleteCharAt(newQueryString.length() - 1);
                }
                return new StringBuffer(url.substring(0, firstQuestionMarkIndex)).append("?").append(newQueryString.toString()).toString();
            }
        }
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

}// ~
