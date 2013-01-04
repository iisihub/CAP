/* 
 * SequenceService.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.service;

import java.util.Map;

import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * 流水號產生器
 * </pre>
 * 
 * @since 2011/9/19
 * @author iristu
 * @version <ul>
 *          <li>2011/9/19,iristu,new
 *          </ul>
 */
public interface SequenceService {

	Page<Map<String, Object>> findPage(int start, int fetch);

	/**
	 * 取得序號
	 * 
	 * @param seqNode
	 *            序號key值
	 * @param interval
	 *            序號區間值
	 * @param startSeq
	 *            序號起啟值
	 * @param maxSeq
	 *            最大序號
	 * @return next seq
	 */
	int getNextSeqNo(String seqNode, int interval, int startSeq, int maxSeq);

}
