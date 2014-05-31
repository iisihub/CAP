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

package com.iisigroup.cap.security.dao;

import java.util.List;

import com.iisigroup.cap.security.model.IRole;

/**
 * <pre>
 * IDao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
public interface IRoleDao<T extends IRole> {
	/**
	 * findByUrl
	 * 
	 * @param system
	 *            系統代碼
	 * @param url
	 *            系統代碼
	 * @return List<IRole>
	 */
	public List<T> findBySysTypeAndPath(String system, String url);
}
