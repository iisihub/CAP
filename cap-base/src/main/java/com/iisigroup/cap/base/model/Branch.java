package com.iisigroup.cap.base.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 分行資訊
 * </pre>
 * 
 * @since 2013/12/26
 * @author tammy
 * @version <ul>
 *          <li>2013/12/26,tammy,new
 *          </ul>
 */

@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_BRN", uniqueConstraints = @UniqueConstraint(columnNames = { "oid" }))
public class Branch extends GenericBean 
		{

	@Id
	private String oid;

	/** 分行代碼 **/
	@NotNull
	@Column(nullable = false, length = 4, columnDefinition = "CHAR(4)")
	private String brNo;

	/**
	 * 分行名稱
	 * <p/>
	 * 21中文字
	 */
	private String brName;

	/** 更新人員 **/
	private String updater;

	/** 更新日期 **/
	private Timestamp updTime;

	/** 分行檢查碼 **/
	private String chkNo;

	/** 分行住址 **/
	private String addr;

	/** 分行電話 **/
	private String tel;

	/**
	 * 分行等級
	 * <p/>
	 * （Ｙ：簡易分行）
	 */
	private String brClass;

	/** 分行英文名稱 **/
	private String engName;

	/** 該分行所在地之本位幣 **/
	private String useSWFT;

	/** 分行名稱簡稱 **/
	private String nameABBR;

	/** １國內２國外３總處４子銀行 **/
	private String brNoFlag;

	/** １北區２中區３南區４其他 **/
	private String brNoArea;

	/** 經理 **/
	private String accManager;

	/**
	 * 單位類別 (從Notes引進)
	 * <p/>
	 * B：一般分行<br/>
	 * J：簡易型分行<br/>
	 * A：區域授信中心<br/>
	 * S：企金部<br/>
	 * G：稽核處 (總行G)<br/>
	 * H：徵信中心 (總行C)<br/>
	 * O：海外分行<br/>
	 * M：大陸分行 (目前Notes無)
	 */
	private String unitType;

	/** 所屬區域授信中心 **/
	private String brnGroup;

	/** 國別 **/
	private String countryType;

	/**
	 * 時區
	 * <p/>
	 * 格式：GMT Sign Hours : Minutes<br/>
	 * 例：GMT-08:00
	 */
	private String timeZone;

	/** 主機編碼方式 **/
	private String hostCodePage;

	/**
	 * 周一至週五營業開始時間
	 * <p/>
	 * 差勤系統是否提供？
	 */
	private Date bizStartTime;

	/**
	 * 周一至週五營業結束時間
	 * <p/>
	 * 差勤系統是否提供？
	 */
	private Date bizEndTime;

	/**
	 * 週六是否營業
	 * <p/>
	 * 差勤系統是否提供？
	 */
	private String isSatOpen;

	/**
	 * 週六營業開始時間
	 * <p/>
	 * 差勤系統是否提供？
	 */
	private Date satStartTime;

	/**
	 * 週六營業結束時間
	 * <p/>
	 * 差勤系統是否提供？
	 */
	private Date satEndTime;

	/** 所屬母行 **/
	private String parentBrNo;

	/**
	 * 預設使用的UnitType(當權限角色未設定時，則會依此再找一次)
	 */
	private String defUnitType;

	/**
	 * 海外分行主機是否在國外
	 */
	private String obsHostLocal;

	/**
	 * 海外分行主機資料庫Schema名稱
	 */
	private String obsSchema;

	/**
	 * 海外分行分行類型(1.海外總行、2.海外一般分行、3.海外簡易分行)
	 */
	private String obsBrnType;

	/**
	 * 海外分行一級單位代碼
	 */
	private String obsBrnGrp;

	/**
	 * 海外分行主機資料庫名稱
	 */
	private String obsDBName;

	/**
	 * 停業註記
	 */
	private String brekFlag;

	/**
	 * 單位主管
	 */
	private String brnMgr;

	/**
	 * 帳務群組代號
	 */
	private String accGroup;
	/**
	 * 帳務群組名稱
	 */
	private String accGroupName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrNo()
	 */
	public String getBrNo() {
		return this.brNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrNo(java.lang.String)
	 */
	public void setBrNo(String value) {
		this.brNo = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrName()
	 */
	public String getBrName() {
		return this.brName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrName(java.lang.String)
	 */
	public void setBrName(String value) {
		value = CapString.trimFullSpace(value);
		this.brName = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getUpdater()
	 */
	public String getUpdater() {
		return this.updater;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setUpdater(java.lang.String)
	 */
	public void setUpdater(String value) {
		this.updater = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getUpdTime()
	 */
	public Timestamp getUpdTime() {
		return this.updTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setUpdTime(java.util.Date)
	 */
	public void setUpdTime(Timestamp value) {
		this.updTime = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getChkNo()
	 */
	public String getChkNo() {
		return this.chkNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setChkNo(java.lang.String)
	 */
	public void setChkNo(String value) {
		this.chkNo = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getAddr()
	 */
	public String getAddr() {
		return this.addr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setAddr(java.lang.String)
	 */
	public void setAddr(String value) {
		this.addr = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getTel()
	 */
	public String getTel() {
		return this.tel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setTel(java.lang.String)
	 */
	public void setTel(String value) {
		this.tel = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrClass()
	 */
	public String getBrClass() {
		return this.brClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrClass(java.lang.String)
	 */
	public void setBrClass(String value) {
		this.brClass = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getEngName()
	 */
	public String getEngName() {
		return this.engName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setEngName(java.lang.String)
	 */
	public void setEngName(String value) {
		this.engName = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getUseSWFT()
	 */
	public String getUseSWFT() {
		return this.useSWFT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setUseSWFT(java.lang.String)
	 */
	public void setUseSWFT(String value) {
		this.useSWFT = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getNameABBR()
	 */
	public String getNameABBR() {
		return this.nameABBR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setNameABBR(java.lang.String)
	 */
	public void setNameABBR(String value) {
		value = CapString.trimFullSpace(value);
		this.nameABBR = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrNoFlag()
	 */
	public String getBrNoFlag() {
		return this.brNoFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrNoFlag(java.lang.String)
	 */
	public void setBrNoFlag(String value) {
		this.brNoFlag = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrNoArea()
	 */
	public String getBrNoArea() {
		return this.brNoArea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrNoArea(java.lang.String)
	 */
	public void setBrNoArea(String value) {
		this.brNoArea = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getAccManager()
	 */
	public String getAccManager() {
		return this.accManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setAccManager(java.lang.String)
	 */
	public void setAccManager(String value) {
		this.accManager = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getUnitType()
	 */
	public String getUnitType() {
		return this.unitType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setUnitType(java.lang.String)
	 */
	public void setUnitType(String value) {
		this.unitType = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrnGroup()
	 */
	public String getBrnGroup() {
		return this.brnGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrnGroup(java.lang.String)
	 */
	public void setBrnGroup(String value) {
		this.brnGroup = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getCountryType()
	 */
	public String getCountryType() {
		return this.countryType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setCountryType(java.lang.String)
	 */
	public void setCountryType(String value) {
		this.countryType = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getTimeZone()
	 */
	public String getTimeZone() {
		return this.timeZone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setTimeZone(java.lang.String)
	 */
	public void setTimeZone(String value) {
		this.timeZone = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getHostCodePage()
	 */
	public String getHostCodePage() {
		return this.hostCodePage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setHostCodePage(java.lang.String)
	 */
	public void setHostCodePage(String value) {
		this.hostCodePage = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBizStartTime()
	 */
	public Date getBizStartTime() {
		return this.bizStartTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBizStartTime(java.util.Date)
	 */
	public void setBizStartTime(Date value) {
		this.bizStartTime = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBizEndTime()
	 */
//	@Override
	public Date getBizEndTime() {
		return this.bizEndTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBizEndTime(java.util.Date)
	 */
	public void setBizEndTime(Date value) {
		this.bizEndTime = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getIsSatOpen()
	 */
	public String getIsSatOpen() {
		return this.isSatOpen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setIsSatOpen(java.lang.String)
	 */
	public void setIsSatOpen(String value) {
		this.isSatOpen = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getSatStartTime()
	 */
	public Date getSatStartTime() {
		return this.satStartTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setSatStartTime(java.util.Date)
	 */
	public void setSatStartTime(Date value) {
		this.satStartTime = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getSatEndTime()
	 */
	public Date getSatEndTime() {
		return this.satEndTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setSatEndTime(java.util.Date)
	 */
	public void setSatEndTime(Date value) {
		this.satEndTime = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getParentBrNo()
	 */
	public String getParentBrNo() {
		return this.parentBrNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setParentBrNo(java.lang.String)
	 */
	public void setParentBrNo(String value) {
		this.parentBrNo = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getDefUnitType()
	 */
	public String getDefUnitType() {
		return defUnitType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setDefUnitType(java.lang.String)
	 */
	public void setDefUnitType(String defUnitType) {
		this.defUnitType = defUnitType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getObsHostLocal()
	 */
	public String getObsHostLocal() {
		return obsHostLocal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setObsHostLocal(java.lang.String)
	 */
	public void setObsHostLocal(String obsHostLocal) {
		this.obsHostLocal = obsHostLocal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getObsSchema()
	 */
	public String getObsSchema() {
		return obsSchema;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setObsSchema(java.lang.String)
	 */
	public void setObsSchema(String obsSchema) {
		this.obsSchema = obsSchema;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getObsBrnType()
	 */
	public String getObsBrnType() {
		return obsBrnType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setObsBrnType(java.lang.String)
	 */
	public void setObsBrnType(String obsBrnType) {
		this.obsBrnType = obsBrnType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getObsBrnGrp()
	 */
//	@Override
	public String getObsBrnGrp() {
		return this.obsBrnGrp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setObsBrnGrp(java.lang.String)
	 */
//	@Override
	public void setObsBrnGrp(String obsBrnGrp) {
		this.obsBrnGrp = obsBrnGrp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getObsDBName()
	 */
	public String getObsDBName() {
		return obsDBName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setObsDBName(java.lang.String)
	 */
	public void setObsDBName(String obsDBName) {
		this.obsDBName = obsDBName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrekFlag()
	 */
	public String getBrekFlag() {
		return brekFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrekFlag(java.lang.String)
	 */
	public void setBrekFlag(String brekFlag) {
		this.brekFlag = brekFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getBrnMgr()
	 */
//	@Override
	public String getBrnMgr() {
		return this.brnMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setBrnMgr(java.lang.String)
	 */
//	@Override
	public void setBrnMgr(String brnMgr) {
		this.brnMgr = brnMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getAccGroup()
	 */
	public String getAccGroup() {
		return accGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setAccGroup(java.lang.String)
	 */
	public void setAccGroup(String accGroup) {
		this.accGroup = accGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#getAccGroupName()
	 */
	public String getAccGroupName() {
		return accGroupName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.sso.model.IBranch#setAccGroupName(java.lang.String)
	 */
	public void setAccGroupName(String accGroupName) {
		this.accGroupName = accGroupName;
	}

}
