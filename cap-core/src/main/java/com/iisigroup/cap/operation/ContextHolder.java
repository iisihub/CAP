/*
 * ContextHolder.java
 *
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
*/
package com.iisigroup.cap.operation;

import java.io.Serializable;

import com.iisigroup.cap.component.IRequest;

/**<p> ContextHolder.</p>
 *
 * @author iristu
 * @version <ul>
 *           <li>2010/7/22,iristu,new
 *          </ul>
 */
public interface ContextHolder {
			
	IRequest getParameters();
	void setParameters(IRequest params);
	
	
	Serializable getResult();
	void setResult(Serializable result);
	
	Object getData(String key);
	ContextHolder setData(String key,Object value);
	
}
