
package com.iisigroup.cap.base.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * 字典代码表
 * </pre>
 * 
 * @since 2010/12/8
 * @author iristu
 * @version <ul>
 *          <li>2010/12/8,iristu,new
 *          <li>2010/11/8/20,RodesChen,from cap
 *          <li>2011-12-19,Gabriella,修改column
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "CODETYPE", uniqueConstraints = @UniqueConstraint(columnNames = { "cdeType", "cdeVal" }))
public class CodeType extends GenericBean implements IDataObject {

	@Id
	@GeneratedValue(generator = "strategy-uuid")
	@GenericGenerator(name = "strategy-uuid", strategy = "uuid")
	@Column(nullable = false, length = 32)
	private String oid;

	/** 代码 */
	@Column(nullable = false, length = 32)
	private String cdeType;

	/** 值 */
	@Column(nullable = false, length = 48)
	private String cdeVal;

	/** 描述 */
	@Column(length = 100)
	private String cdeDesc;

	/** 排序 */
	@Column(nullable = false, length = 3)
	private Integer cdeOrd;

	/** 修改操作者 */
	@Column(nullable = false, length = 10)
	private String lastModBy;

	/** 修改时间 */
	@Column(nullable = false)
	private Timestamp lastModTm;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCdeType() {
		return cdeType;
	}

	public void setCdeType(String cdeType) {
		this.cdeType = cdeType;
	}

	public String getCdeVal() {
		return cdeVal;
	}

	public void setCdeVal(String cdeVal) {
		this.cdeVal = cdeVal;
	}

	public String getCdeDesc() {
		return cdeDesc;
	}

	public void setCdeDesc(String cdeDesc) {
		this.cdeDesc = cdeDesc;
	}

	public Integer getCdeOrd() {
		return cdeOrd;
	}

	public void setCdeOrd(Integer cdeOrd) {
		this.cdeOrd = cdeOrd;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Timestamp getLastModTm() {
		return lastModTm;
	}

	public void setLastModTm(Timestamp lastModTm) {
		this.lastModTm = lastModTm;
	}

}
