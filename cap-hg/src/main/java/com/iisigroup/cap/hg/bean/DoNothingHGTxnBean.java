/* 
 * MCIHGtTxnDoNothingBean.java
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

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * MCI 一般交易處理
 * </pre>
 * 
 * @since 2012/2/14
 * @author rodeschen
 * @version <ul>
 *          <li>2012/2/14,rodeschen,new
 *          </ul>
 */
public class DoNothingHGTxnBean implements IHGTxnBean {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private Document sendData;
	private Document resultData;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.bean.IHGTxnBean#setTxnCd(java.lang.String)
	 */
	@Override
	public void setTxnCd(String txnCd) {
		//do nothing
		//this.txnCd = txnCd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.bean.IHGTxnBean#setSendData(java.lang.Object)
	 */
	@Override
	public void setSendData(Object requestData) {

		if (requestData instanceof String && !CapString.isEmpty((String) requestData)) {
			try {
				this.sendData = DocumentHelper.parseText((String) requestData);
			} catch (DocumentException e) {
				logger.debug(e.getMessage(), e);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.bean.IHGTxnBean#execute()
	 */
	@Override
	public void execute() throws CapException {
		this.resultData = this.sendData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bqd.mci.bean.IHGTxnBean#getResultData()
	 */
	@Override
	public Object getResultData() {
		return this.resultData;
	}

}
