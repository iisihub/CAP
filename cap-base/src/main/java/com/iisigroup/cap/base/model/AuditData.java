package com.iisigroup.cap.base.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * 記錄Audit Log
 * 
 * sno          = 流水序號
 * logSno       = AUDITLOG的流水序號
 * flag         = 資料類型(I:InputO:Output)
 * data         = 資料內容
 * </pre>
 * 
 * @since 2011/06/01
 * @author UFO
 * @version <ul>
 *          <li>2011/06/01,UFO,new
 *          </ul>
 */
@Entity
@Table(name = "DEF_AuditData")
public class AuditData extends GenericBean implements IDataObject{
	private static final long serialVersionUID = 1L;

	@Transient
	private static final int MAX_DATA_SIZE = 10240;

	@Transient
	public static final String TYPE_REQUEST = "I";

	@Transient
	public static final String TYPE_RESPONSE = "O";

	@Id
	@Column(length = 30, name = "sno", nullable = false)
	private String sno;

//	private String logSno;

	@Column(length = 1)
	private String flag;

	@Column(length = 10240)
	private String data;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name = "logSno", referencedColumnName = "sno", nullable = false) })
	private AuditLog auditLog;

	public AuditData() {
	}

	public AuditData(String flag, String data, AuditLog auditLog) {
		this.flag = flag;
		this.data = data;
		this.auditLog = auditLog;
		this.trimData();
	}

	/**
	 * get the oid
	 * 
	 * @return the oid
	 */
	public String getOid() {
		return String.valueOf(sno);
	}

	/**
	 * set the oid
	 * 
	 * @param oid
	 *            the oid to set
	 */
	public void setOid(String oid) {
		this.sno = oid;
	}

	/**
	 * get the sno
	 * 
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * set the sno
	 * 
	 * @param sno
	 *            the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

//	/**
//	 * get the logSno
//	 * 
//	 * @return the logSno
//	 */
//	public String getLogSno() {
//		return logSno;
//	}
//
//	/**
//	 * set the logSno
//	 * 
//	 * @param logSno
//	 *            the logSno to set
//	 */
//	public void setLogSno(String logSno) {
//		this.logSno = logSno;
//	}

	/**
	 * get the flag
	 * 
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * set the flag
	 * 
	 * @param flag
	 *            the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * get the data
	 * 
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * set the data
	 * 
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
		this.trimData();
	}

	/**
	 * get the auditLog
	 * 
	 * @return the auditLog
	 */
	public AuditLog getAuditLog() {
		return auditLog;
	}

	/**
	 * set the auditLog
	 * 
	 * @param auditLog
	 *            the auditLog to set
	 */
	public void setAuditLog(AuditLog auditLog) {
		this.auditLog = auditLog;
	}

	private void trimData() {
		if (data != null && data.getBytes().length > MAX_DATA_SIZE) {
			this.data = new String(this.data.getBytes(), 0, MAX_DATA_SIZE);
		}
	}

}