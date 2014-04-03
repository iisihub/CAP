package com.iisigroup.cap.base.model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Sequence {
	Map<String, Object> thisSeq;

	public Sequence() {
		this.thisSeq = new HashMap<String, Object>();
	}

	public String getSeqNode() {
		return (String) thisSeq.get("seqNode");
	}

	public void setSeqNode(String seqNode) {
		thisSeq.put("seqNode", seqNode);
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

	public void setUpdateTime(Timestamp updateTime) {
		thisSeq.put("updateTime", updateTime);
	}

	public Map<String, Object> getSequence() {
		Map<String, Object> newMap = new HashMap<String, Object>();
		newMap.putAll(thisSeq);
		return newMap;
	}
}
