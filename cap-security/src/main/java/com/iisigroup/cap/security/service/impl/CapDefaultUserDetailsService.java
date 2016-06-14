/* 
 * CapDefaultUserDetailsService.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.iisigroup.cap.security.model.CapUserDetails;

/**
 * <pre>
 * Get default CapUserDetails
 * </pre>
 * 
 * @since 2016年6月14日
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2016年6月14日,Sunkist Wang,new
 *          </ul>
 */
public class CapDefaultUserDetailsService implements UserDetailsService {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        CapUserDetails u = new CapUserDetails();
        u.setPassword("P@ssw0rd");
        return u;
    }

}
