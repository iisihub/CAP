package com.iisigroup.cap.base.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * 記錄Audit Log的設定
 * </pre>
 * 
 * @since 2011/06/01
 * @author UFO
 * @version <ul>
 *          <li>2011/06/01,UFO,new
 *          </ul>
 */
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_AuditConfig")
public class AuditConfig extends GenericBean implements IDataObject{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 32)
	private String oid;

	@Column(length = 128)
	private String targetName;

	@Column(length = 1)
	private String disableType;

	@Column(length = 6)
	private String lastModifyBy;

	@Column
	private Timestamp lastModifyTime;

	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * @param oid
	 *            the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * @return the targetName
	 */
	public String getTargetName() {
		return targetName;
	}

	/**
	 * @param targetName
	 *            the targetName to set
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	/**
	 * @return the disableType
	 */
	public String getDisableType() {
		return disableType;
	}

	/**
	 * @param disableType
	 *            the disableType to set
	 */
	public void setDisableType(String disableType) {
		this.disableType = disableType;
	}

	/**
	 * @return the lastModifyBy
	 */
	public String getLastModifyBy() {
		return lastModifyBy;
	}

	/**
	 * @param lastModifyBy
	 *            the lastModifyBy to set
	 */
	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

	/**
	 * @return the lastModifyTime
	 */
	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	/**
	 * @param lastModifyTime
	 *            the lastModifyTime to set
	 */
	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	/**
	 * Audit不記錄的類型
	 * 
	 * @author UFO
	 * 
	 */
	public enum DisableType {
		ALL("A"), DATA("D"), CANCEL("C");

		private String rcode;

		DisableType(String code) {
			this.rcode = code;
		}

		public String getCode() {
			return rcode;
		}

		public boolean isEquals(Object other) {
			if (other instanceof String) {
				return rcode.equals(other);
			} else {
				return super.equals(other);
			}
		}
	}
}