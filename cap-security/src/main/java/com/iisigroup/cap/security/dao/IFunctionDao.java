/**
 * IFunctionDao.java
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

import com.iisigroup.cap.security.model.IFunction;
import com.iisigroup.cap.security.model.IRole;

/**
 * <p>
 * 交易.
 * </p>
 * 
 * <pre>
 * $Date: 2010-09-28 12:08:43 +0800 (星期二, 28 九月 2010) $
 * $Author: iris $
 * $Revision: 656 $
 * $HeadURL: svn://192.168.0.1/MICB_ISDOC/cap/cap-core/src/main/java/tw/com/iisi/cap/security/dao/IFunctionDao.java $
 * </pre>
 * 
 * @author iristu
 * @version $Revision: 656 $
 * @version <ul>
 *          <li>2010/7/26,iristu,new
 *          </ul>
 * @param <T>
 */
public interface IFunctionDao<T extends IFunction> {

	T getFunctionByURL(String url);

	List<? extends IRole> getRoleByFunction(T function);
	
	T getFunctionByName(String functionName);
	
}
