/**
 * IRole.java
 *
 * Copyright (c) 2009 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
*/
package com.iisigroup.cap.security.model;

import java.io.Serializable;

/**<p> 角色.</p>
 * @author iristu
 * @version <ul>
 *           <li>2010/7/26,iristu,new
 *          </ul>
 */
public interface IRole extends Serializable {
	
	/**
	 * Gets the oid.
	 * 
	 * @return the oid
	 */
//	String getOid();
	
	String getRoleId();
	
	void setRoleId(String roleId);
	
	String getRoleName();
	
	void setRoleName(String roleName);
}
