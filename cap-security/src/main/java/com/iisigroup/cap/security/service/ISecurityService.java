/*_
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.security.service;

import java.util.List;

import com.iisigroup.cap.security.model.IRole;

/**
 * <pre>
 * the interface ISecurityService
 * </pre>
 * 
 * @since 2010/11/29
 * @author iristu
 * @version <ul>
 *          <li>2010/11/29,iristu,new
 *          </ul>
 */
public interface ISecurityService {

	List<IRole> getAuthRolesByUrl(String url);

}
