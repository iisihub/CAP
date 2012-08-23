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
 * <p>
 * 系統參數檔.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/9/6,iristu,new
 *          <li>2011/12/28,rodeschen,copy from cap
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "SYSPARM", uniqueConstraints = @UniqueConstraint(columnNames = "parm"))
public class SysParm extends GenericBean implements IDataObject {

	@Id
	@GeneratedValue(generator = "strategy-uuid")
	@GenericGenerator(name = "strategy-uuid", strategy = "uuid")
	@Column(length = 32)
	private String oid;
	/** 参数id */
	@Column(length = 30, nullable = false)
	private String parm;
	/** 参数数值 */
	@Column(length = 10, nullable = false)
	private String parmValue;
	/** 参数描述 */
	@Column(length = 100)
	private String parmDesc;
	/** 修改操作者 */
	@Column(length = 10, nullable = false)
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

	public String getParm() {
		return parm;
	}

	public void setParm(String parm) {
		this.parm = parm;
	}

	public String getParmValue() {
		return parmValue;
	}

	public void setParmValue(String parmValue) {
		this.parmValue = parmValue;
	}

	public String getParmDesc() {
		return parmDesc;
	}

	public void setParmDesc(String parmDesc) {
		this.parmDesc = parmDesc;
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
