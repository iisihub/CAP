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

package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.dao.IGenericDao;

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
public interface CodeItemDao extends IGenericDao<CodeItem> {
	/**
	 * find All
	 * 
	 * @param	system
	 * 				系統代碼
	 * @return List<CodeItem>
	 */
	public List<CodeItem> findAll(String system);
	
	
	public List<CodeItem> findBySystypAndStep(String systyp, String step);
}
