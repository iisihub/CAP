/* 
 * CapOidGeneratorListener.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.model.listener;

import java.util.UUID;

import javax.persistence.PrePersist;

import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * 生成oid的值
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public class CapOidGeneratorListener {

	@PrePersist
	public <T extends IDataObject> void perPersist(T entity) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		entity.setOid(uuid);
	}// ;

}
