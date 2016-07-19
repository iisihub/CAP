/* 
 * CheckCodeService.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.service;

import com.iisigroup.cap.security.constants.CheckStatus;

/**
 * <pre>
 * Interface for create and valid check code.
 * </pre>
 * 
 * @since 2016年6月13日
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2016年6月13日,Sunkist Wang,new
 *          </ul>
 */
public interface CheckCodeService {

    String getErrorMessage();

    <T> T createCheckCode();

    CheckStatus valid(String answer);

}
