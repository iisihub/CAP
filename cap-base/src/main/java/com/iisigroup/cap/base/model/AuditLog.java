package com.iisigroup.cap.base.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;

/**
 * <pre>
 * 記錄Audit Log
 * 
 * sno          = 流水序號
 * mainId       = 案件編號(mainId)
 * docOid       = 文件的Oid
 * txId         = 交易代碼
 * sysId        = 子系統代碼
 * serverName   = 服務主機名稱
 * userId       = 使用者
 * invokerIp    = 用戶端位址
 * invokeResult = 執行結果碼
 * invokeSource = 呼叫端名稱
 * invokeTarget = Handler名稱
 * invokeAction = 執行的METHOD
 * invokeMemo   = 執行結果備註
 * startTime    = 開始時間
 * endTime      = 結束時間
 * cost         = 執行時間
 * </pre>
 * 
 * @since 2011/06/01
 * @author UFO
 * @version <ul>
 *          <li>2011/06/01,UFO,new
 *          </ul>
 */
@Entity
@Table(name = "DEF_AuditLog")
public class AuditLog extends GenericBean implements IDataObject{
	/**
	 * 成功
	 */
	@Transient
	public static final String RC_NORMAL = "0";

	/**
	 * 失敗
	 */
	@Transient
	public static final String RC_EXCEPTION = "1";

	/**
	 * 其他
	 */
	@Transient
	public static final String RC_OTHER = "2";

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 30, name = "sno", nullable = false)
	private String sno;

	@Column(length = 32)
	private String mainId;

	@Column(length = 32)
	private String docOid;

	@Column(length = 20)
	private String txid;

	@Column(length = 10)
	private String custId;

	@Column(length = 1)
	private String dupNo;

	@Column(length = 3)
	private String sysId;

	@Column(length = 10)
	private String serverName;

	@Column(length = 6)
	private String userId;

	@Column(length = 15)
	private String invokerIp;

	@Column(length = 1)
	private String invokeResult;

	@Column(length = 64)
	private String invokeSource;

	@Column(length = 128)
	private String invokeTarget;

	@Column(length = 30)
	private String invokeAction;

	@Column(length = 100)
	private String invokeMemo;

	private Timestamp startTime;

	private Timestamp endTime;

	@Column(columnDefinition = "DECIMAL(10,0)")
	private long cost;

	@OneToMany(mappedBy = "auditLog", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<AuditData> auditLogDataList;

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
	 * get the mainId
	 * 
	 * @return the mainId
	 */
	public String getMainId() {
		return mainId;
	}

	/**
	 * set the mainId
	 * 
	 * @param mainId
	 *            the mainId to set
	 */
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	/**
	 * get the txid
	 * 
	 * @return the txid
	 */
	public String getTxid() {
		return txid;
	}

	/**
	 * set the txid
	 * 
	 * @param txid
	 *            the txid to set
	 */
	public void setTxid(String txid) {
		this.txid = txid;
	}

	/**
	 * get the sysId
	 * 
	 * @return the sysId
	 */
	public String getSysId() {
		return sysId;
	}

	/**
	 * set the sysId
	 * 
	 * @param sysId
	 *            the sysId to set
	 */
	public void setSysId(String sysId) {
		if (sysId != null) {
			this.sysId = sysId.toUpperCase();
		}
	}

	/**
	 * get the serverName
	 * 
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * set the serverName
	 * 
	 * @param serverName
	 *            the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * get the userId
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * set the userId
	 * 
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get the invokerIp
	 * 
	 * @return the invokerIp
	 */
	public String getInvokerIp() {
		return invokerIp;
	}

	/**
	 * set the invokerIp
	 * 
	 * @param invokerIp
	 *            the invokerIp to set
	 */
	public void setInvokerIp(String invokerIp) {
		this.invokerIp = invokerIp;
	}

	/**
	 * get the invokeResult
	 * 
	 * @return the invokeResult
	 */
	public String getInvokeResult() {
		return invokeResult;
	}

	/**
	 * set the invokeResult
	 * 
	 * @param invokeResult
	 *            the invokeResult to set
	 */
	public void setInvokeResult(String invokeResult) {
		this.invokeResult = invokeResult;
	}

	/**
	 * get the invokeSource
	 * 
	 * @return the invokeSource
	 */
	public String getInvokeSource() {
		return invokeSource;
	}

	/**
	 * set the invokeSource
	 * 
	 * @param invokeSource
	 *            the invokeSource to set
	 */
	public void setInvokeSource(String invokeSource) {
		this.invokeSource = invokeSource;
	}

	/**
	 * get the invokeTarget
	 * 
	 * @return the invokeTarget
	 */
	public String getInvokeTarget() {
		return invokeTarget;
	}

	/**
	 * set the invokeTarget
	 * 
	 * @param invokeTarget
	 *            the invokeTarget to set
	 */
	public void setInvokeTarget(String invokeTarget) {
		this.invokeTarget = invokeTarget;
	}

	/**
	 * get the invokeMemo
	 * 
	 * @return the invokeMemo
	 */
	public String getInvokeMemo() {
		return invokeMemo;
	}

	/**
	 * set the invokeMemo
	 * 
	 * @param invokeMemo
	 *            the invokeMemo to set
	 */
	public void setInvokeMemo(String invokeMemo) {
		invokeMemo = StringUtils.trimToEmpty(invokeMemo);
		if (invokeMemo.getBytes().length > 100) {
			this.invokeMemo = new String(invokeMemo.getBytes(), 0, 100);
		}

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

	/**
	 * get the docOid
	 * 
	 * @return the docOid
	 */
	public String getDocOid() {
		return docOid;
	}

	/**
	 * set the docOid
	 * 
	 * @param docOid
	 *            the docOid to set
	 */
	public void setDocOid(String docOid) {
		this.docOid = docOid;
	}

	/**
	 * get the invokeAction
	 * 
	 * @return the invokeAction
	 */
	public String getInvokeAction() {
		return invokeAction;
	}

	/**
	 * set the invokeAction
	 * 
	 * @param invokeAction
	 *            the invokeAction to set
	 */
	public void setInvokeAction(String invokeAction) {
		this.invokeAction = invokeAction;
	}

	/**
	 * get the startTime
	 * 
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * set the startTime
	 * 
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * get the endTime
	 * 
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * set the endTime
	 * 
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * get the cost
	 * 
	 * @return the cost
	 */
	public long getCost() {
		return cost;
	}

	/**
	 * set the cost
	 * 
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(long cost) {
		this.cost = cost;
	}

	/**
	 * get the auditLogDataList
	 * 
	 * @return the auditLogDataList
	 */
	public List<AuditData> getAuditLogDataList() {
		return auditLogDataList;
	}

	/**
	 * set the auditLogDataList
	 * 
	 * @param auditLogDataList
	 *            the auditLogDataList to set
	 */
	public void setAuditLogDataList(List<AuditData> auditLogDataList) {
		this.auditLogDataList = auditLogDataList;
	}

	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * @param custId
	 *            the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return the dupNo
	 */
	public String getDupNo() {
		return dupNo;
	}

	/**
	 * @param dupNo
	 *            the dupNo to set
	 */
	public void setDupNo(String dupNo) {
		this.dupNo = dupNo;
	}

	/**
	 * <pre>
	 * ResultCode
	 * </pre>
	 * 
	 * @since 2011/06/01
	 * @author UFO
	 * @version <ul>
	 *          <li>2011/06/01,UFO,new
	 *          </ul>
	 */
	// enum ResultCode {
	// NORMAL("0"), EXCEPTION("1"), OTHER("2");
	//
	// private String rcode;
	//
	// ResultCode(String code) {
	// this.rcode = code;
	// }
	//
	// public String getCode() {
	// return rcode;
	// }
	//
	// public boolean isEquals(Object other) {
	// if (other instanceof String) {
	// return rcode.equals(other);
	// } else {
	// return super.equals(other);
	// }
	// }
	//
	// }

}