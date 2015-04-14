/* 
 * IHGTxnBean.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.hg.bean;

import com.iisigroup.cap.exception.CapException;

/**
 * <pre>
 * HG TXN Bean
 * </pre>
 * 
 * @since 2012/2/14
 * @author rodeschen
 * @version <ul>
 *          <li>2012/2/14,rodeschen,new
 *          </ul>
 */
public interface IHGTxnBean {

    void setTxnCd(String txnCd);

    void setSendData(Object requestData);

    void execute() throws CapException;

    Object getResultData();
}
