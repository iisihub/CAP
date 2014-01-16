/*
 * IFormatter.java
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
package com.iisigroup.cap.formatter;

import java.io.Serializable;

/**
 * <p>
 * reformat 欄位值
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/1/8,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface IFormatter extends Serializable {

	/**
	 * 重新format傳入的值
	 * 
	 * @param <T>
	 *            type
	 * @param in
	 *            the input
	 * @return String
	 * @throws CapFormatException
	 */
	public <T> T reformat(Object in);

}
