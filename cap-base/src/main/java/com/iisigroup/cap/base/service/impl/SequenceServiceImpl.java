/* 
 * SequenceServiceImpl.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.SequenceDao;
import com.iisigroup.cap.base.model.Sequence;
import com.iisigroup.cap.base.service.SequenceService;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.CapDate;

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
@Service
public class SequenceServiceImpl implements SequenceService {

	private final static Logger logger = LoggerFactory
			.getLogger(SequenceServiceImpl.class);

	@Resource
	private SequenceDao sequenceDao;

	private Map<String, NodeSeq> nodeSeq = Collections
			.synchronizedMap(new HashMap<String, NodeSeq>());

	@Override
	public Page<Map<String, Object>> findPage(int start, int fetch) {
		return sequenceDao.listAllForPaging(start, fetch);
	}

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
	public int getNextSeqNo(String seqNode, int interval, int startSeq,
			int maxSeq) {
		NodeSeq nSeq = nodeSeq.get(seqNode);
		if (nSeq == null) {
			nSeq = new NodeSeq(seqNode);
			nodeSeq.put(seqNode, nSeq);
		}
		synchronized (nSeq) {
			nSeq.nextSeqNo++;
			if (nSeq.nextSeqNo >= interval || nSeq.currentSeq == -1) {
				nSeq.currentSeq = getDBNextSeq(seqNode, interval, startSeq,
						maxSeq);
				nSeq.nextSeqNo = 0;
			}
			return nSeq.currentSeq * interval + nSeq.nextSeqNo;
		}
	}// ;

	/**
	 * 從DB取得下一個序號
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
	private int getDBNextSeq(String seqNode, int interval, int startSeq,
			int maxSeq) {
		Sequence thisSeq = getSequence(seqNode);
		int returnSeq = -1;
		try {
			if (thisSeq == null || thisSeq.getSeqNode().length() == 0) {
				thisSeq = new Sequence();
				thisSeq.setSeqNode(seqNode);
				thisSeq.setNextSeq(startSeq + 1);
				thisSeq.setUpdateTime(CapDate.getCurrentTimestamp());
				thisSeq.setRounds(1);
				saveSeq(thisSeq, -1);
				return startSeq;
			} else {
				Sequence nextSeq = thisSeq;
				returnSeq = thisSeq.getNextSeq();
				int next = returnSeq + 1;
				if (maxSeq > 0 && (next * interval) >= maxSeq) {
					next = startSeq;
					nextSeq.setRounds(thisSeq.getRounds() + 1);
				}
				nextSeq.setNextSeq(next);
				nextSeq.setUpdateTime(CapDate.getCurrentTimestamp());
				int row = saveSeq(nextSeq, returnSeq);
				if (row != 1) {
					return getDBNextSeq(seqNode, interval, startSeq, maxSeq);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		// set current seq
		return returnSeq;
	}// ;

	private int saveSeq(Sequence nextSeq, int oldSeq) {
		int rtn = 0;
		Map<String, Object> map = nextSeq.getSequence();
		if (oldSeq == -1) {
			sequenceDao.createFromMap(map);
			rtn = 1;
		} else {
			map.put("oldSeq", oldSeq);
			rtn = sequenceDao.updateByNodeAndNextSeqFromMap(map);
		}
		return rtn;
	}// ;

	private Sequence getSequence(String seqNode) {
		Sequence thisSeq = sequenceDao.findBySeqNode(seqNode);
		return thisSeq;
	}// ;

	/**
	 * <pre>
	 * 流水號設定
	 * </pre>
	 */
	private class NodeSeq {
		@SuppressWarnings("unused")
		String seqNode;
		int nextSeqNo;
		int currentSeq;

		NodeSeq(String seqNode) {
			this.seqNode = seqNode;
			this.nextSeqNo = 0;
			this.currentSeq = -1;
		}
	}// ;

}
