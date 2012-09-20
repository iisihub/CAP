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
package com.iisigroup.cap.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.iisigroup.cap.jdbc.CapNamedJdbcTemplate;
import com.iisigroup.cap.service.SequenceService;
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
public class SequenceServiceImpl implements SequenceService {

	private final static Logger logger = LoggerFactory
			.getLogger(SequenceServiceImpl.class);

	private CapNamedJdbcTemplate jdbc;

	private Map<String, NodeSeq> nodeSeq = Collections
			.synchronizedMap(new HashMap<String, NodeSeq>());

	public void setJdbc(CapNamedJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	/**
	 * 取得序號
	 * 
	 * @param nodeName
	 *            序號key值
	 * @param interval
	 *            序號區間值
	 * @param startSeq
	 *            序號起啟值
	 * @param maxSeq
	 *            最大序號
	 * @return next seq
	 */
	public int getNextSeqNo(String nodeName, int interval, int startSeq,
			int maxSeq) {
		NodeSeq nSeq = nodeSeq.get(nodeName);
		if (nSeq == null) {
			nSeq = new NodeSeq(nodeName);
			nodeSeq.put(nodeName, nSeq);
		}
		synchronized (nSeq) {
			nSeq.nextSeqNo++;
			if (nSeq.nextSeqNo >= interval || nSeq.currentSeq == -1) {
				nSeq.currentSeq = getDBNextSeq(nodeName, interval, startSeq,
						maxSeq);
				nSeq.nextSeqNo = 0;
			}
			return nSeq.currentSeq * interval + nSeq.nextSeqNo;
		}
	}// ;

	/**
	 * 從DB取得下一個序號
	 * 
	 * @param nodeName
	 *            序號key值
	 * @param interval
	 *            序號區間值
	 * @param startSeq
	 *            序號起啟值
	 * @param maxSeq
	 *            最大序號
	 * @return next seq
	 */
	private int getDBNextSeq(String nodeName, int interval, int startSeq,
			int maxSeq) {
		Sequence thisSeq = getSequence(nodeName);
		int returnSeq = -1;
		try {
			if (thisSeq == null || thisSeq.getNodeName().length() == 0) {
				thisSeq = new Sequence();
				thisSeq.setNodeName(nodeName);
				thisSeq.setNextSeq(startSeq + 1);
				thisSeq.setLastModifyTime(CapDate.getCurrentTimestamp());
				thisSeq.setRounds(1);
				saveSeq(thisSeq, -1);
				return startSeq;
			} else {
				Sequence nextSeq = new Sequence();
				returnSeq = thisSeq.getNextSeq();
				int next = returnSeq + 1;
				if (maxSeq > 0 && (next * interval) >= maxSeq) {
					next = startSeq;
					nextSeq.setRounds(nextSeq.getRounds() + 1);
				}
				nextSeq.setNodeName(thisSeq.getNodeName());
				nextSeq.setNextSeq(next);
				nextSeq.setLastModifyTime(CapDate.getCurrentTimestamp());
				int row = saveSeq(nextSeq, returnSeq);
				if (row != 1) {
					return getDBNextSeq(nodeName, interval, startSeq, maxSeq);
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
			jdbc.update("Sequence.insert", map);
			rtn = 1;
		} else {
			map.put("oldSeq", oldSeq);
			rtn = jdbc.update("Sequence.updateByNodeNameAndNextSeq", map);
		}
		return rtn;
	}// ;

	private Sequence getSequence(String nodeName) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("nodeName", nodeName);
		Sequence thisSeq = jdbc.queryForObject("Sequence.findByNodeName", args,
				new RowMapper<Sequence>() {
					@Override
					public Sequence mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Sequence seq = new Sequence();
						seq.setNodeName(rs.getString("NODENAME"));
						seq.setNextSeq(rs.getInt("NEXTSEQ"));
						seq.setRounds(rs.getInt("ROUNDS"));
						seq.setLastModifyTime(rs.getTimestamp("LASTMODIFYTIME"));
						return seq;
					}
				});
		return thisSeq;
	}// ;

	/**
	 * <pre>
	 * 流水號設定
	 * </pre>
	 */
	private class NodeSeq implements Serializable {
		private static final long serialVersionUID = 1L;
		@SuppressWarnings("unused")
		String nodeName;
		int nextSeqNo;
		int currentSeq;

		NodeSeq(String nodeName) {
			this.nodeName = nodeName;
			this.nextSeqNo = 0;
			this.currentSeq = -1;
		}
	}// ;

	/**
	 * <pre>
	 * 流水號
	 * </pre>
	 */
	private class Sequence {
		Map<String, Object> thisSeq;

		public Sequence() {
			this.thisSeq = new HashMap<String, Object>();
		}

		public String getNodeName() {
			return (String) thisSeq.get("nodeName");
		}

		public void setNodeName(String nodeName) {
			thisSeq.put("nodeName", nodeName);
		}

		public Integer getNextSeq() {
			return (Integer) thisSeq.get("nextSeq");
		}

		public void setNextSeq(Integer nextSeq) {
			thisSeq.put("nextSeq", nextSeq);
		}

		public Integer getRounds() {
			return (Integer) thisSeq.get("rounds");
		}

		public void setRounds(Integer rounds) {
			thisSeq.put("rounds", rounds);
		}

		public void setLastModifyTime(Timestamp lastModifyTime) {
			thisSeq.put("lastModifyTime", lastModifyTime);
		}

		public Map<String, Object> getSequence() {
			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.putAll(thisSeq);
			return newMap;
		}
	}// ;

}
