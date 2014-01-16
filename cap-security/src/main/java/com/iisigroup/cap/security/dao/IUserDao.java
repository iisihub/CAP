/**
 * IUserDao.java
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
package com.iisigroup.cap.security.dao;

import java.util.List;

import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.model.IUser;

/**<p> interface IUserDao.</p>
 * <pre>
 * $Date: 2010-08-25 11:25:55 +0800 (星期三, 25 八月 2010) $
 * $Author: iris $
 * $Revision: 185 $
 * $HeadURL: svn://192.168.0.1/MICB_ISDOC/cap/cap-core/src/main/java/tw/com/iisi/cap/security/dao/IUserDao.java $
 * </pre>
 *
 * @author iristu
 * @version $Revision: 185 $
 * @version <ul>
 *           <li>2010/7/26,iristu,new
 *          </ul>
 * @param <T> the model extends IUser
 */
public interface IUserDao<T extends IUser> {
	
	T getUserByLoginId(String loginId,String unitNo);

	List<? extends IRole> getRoleByUser(T user);
}
