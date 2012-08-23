package com.iisigroup.cap.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * 序号表
 * </pre>
 * 
 * @since 2009-12-01
 * @author iristu
 * @version <ul>
 *          <li>2009-12-01,iristu,new
 *          <li>2011/11/11,copy from cap
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SEQUENCE", uniqueConstraints = @UniqueConstraint(columnNames = "nodeName"))
public class Sequence extends GenericBean implements Serializable {

	@Id
	@GeneratedValue(generator = "strategy-uuid")
	@GenericGenerator(name = "strategy-uuid", strategy = "uuid")
	@Column(length = 32)
	private String oid;

	@Column(nullable = false, length = 20)
	private String nodeName;

	private Integer nextSeq;

	private Integer rounds;

	private Timestamp lastModifyTime;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Integer getNextSeq() {
		return nextSeq;
	}

	public void setNextSeq(Integer nextSeq) {
		this.nextSeq = nextSeq;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Integer getRounds() {
		return rounds;
	}

	public void setRounds(Integer rounds) {
		this.rounds = rounds;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
