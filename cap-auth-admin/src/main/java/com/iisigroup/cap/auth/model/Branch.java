package com.iisigroup.cap.auth.model;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Fri Dec 27 11:02:53 CST 2013
 */
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

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
public class Branch extends GenericBean implements IDataObject {
	private static final long serialVersionUID = 1L;

	/**
	 * OID:char(32)
	 */
	@Id
	private String oid;

	/**
	 * DEPARTNO:char(4) <Primary Key>
	 */
	@NotNull
	@Column(nullable = false, length = 4, columnDefinition = "CHAR(4)")
	private String departno;

	/**
	 * DEPARTNM:varchar(30)
	 */
	@Column(length = 30)
	private String departnm;

	/**
	 * DEPLEVEL:char(1)
	 */
	@Column(length = 1)
	private String deplevel;

	/**
	 * DEPARTEL:varchar(20)
	 */
	@Column(length = 20)
	private String departel;

	/**
	 * DEPARZIP:char(5)
	 */
	@Column(length = 5)
	private String deparzip;

	/**
	 * DEPARADD:varchar(90)
	 */
	@Column(length = 90)
	private String deparadd;

	/**
	 * DEPARTYP:char(1)
	 */
	@Column(length = 1)
	private String departyp;

	/**
	 * DEPMANAG:varchar(30)
	 */
	@Column(length = 30)
	private String depmanag;

	/**
	 * DEPPROXY:varchar(30)
	 */
	@Column(length = 30)
	private String depproxy;

	/**
	 * DEPARGRP:char(4)
	 */
	@Column(length = 4)
	private String depargrp;

	/**
	 * COUNTTYP:char(2)
	 */
	@Column(length = 2)
	private String counttyp;

	/**
	 * TIMEZONE:char(9)
	 */
	@Column(length = 9)
	private String timezone;

	/**
	 * ABREKFLG:char(1)
	 */
	@Column(length = 1)
	private String abrekflg;

	/**
	 * UPDATER:varchar(10)
	 */
	@Column(length = 10)
	private String updater;

	/**
	 * UPDTIME:timestamp(23,10)
	 */
	private Timestamp updtime;

	@OneToMany(mappedBy = "branch", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<User> users;

	/**
	 * Constractor
	 */
	public Branch() {
	}

	/**
	 * Constractor
	 * 
	 * @param <code>departno</code>
	 */
	public Branch(String departno) {
		this.departno = departno;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getDepartno() {
		return this.departno;
	}

	public void setDepartno(String departno) {
		this.departno = departno;
	}

	public String getDepartnm() {
		return this.departnm;
	}

	public void setDepartnm(String departnm) {
		this.departnm = departnm;
	}

	public String getDeplevel() {
		return this.deplevel;
	}

	public void setDeplevel(String deplevel) {
		this.deplevel = deplevel;
	}

	public String getDepartel() {
		return this.departel;
	}

	public void setDepartel(String departel) {
		this.departel = departel;
	}

	public String getDeparzip() {
		return this.deparzip;
	}

	public void setDeparzip(String deparzip) {
		this.deparzip = deparzip;
	}

	public String getDeparadd() {
		return this.deparadd;
	}

	public void setDeparadd(String deparadd) {
		this.deparadd = deparadd;
	}

	public String getDepartyp() {
		return this.departyp;
	}

	public void setDepartyp(String departyp) {
		this.departyp = departyp;
	}

	public String getDepmanag() {
		return this.depmanag;
	}

	public void setDepmanag(String depmanag) {
		this.depmanag = depmanag;
	}

	public String getDepproxy() {
		return this.depproxy;
	}

	public void setDepproxy(String depproxy) {
		this.depproxy = depproxy;
	}

	public String getDepargrp() {
		return this.depargrp;
	}

	public void setDepargrp(String depargrp) {
		this.depargrp = depargrp;
	}

	public String getCounttyp() {
		return this.counttyp;
	}

	public void setCounttyp(String counttyp) {
		this.counttyp = counttyp;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getAbrekflg() {
		return this.abrekflg;
	}

	public void setAbrekflg(String abrekflg) {
		this.abrekflg = abrekflg;
	}

	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Timestamp getUpdtime() {
		return this.updtime;
	}

	public void setUpdtime(Timestamp updtime) {
		this.updtime = updtime;
	}
	
	public List<User> getUsers() {
		return this.users;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[Def_brnVo:");
		buffer.append(" oid: ");
		buffer.append(oid);
		buffer.append(" departno: ");
		buffer.append(departno);
		buffer.append(" departnm: ");
		buffer.append(departnm);
		buffer.append(" deplevel: ");
		buffer.append(deplevel);
		buffer.append(" departel: ");
		buffer.append(departel);
		buffer.append(" deparzip: ");
		buffer.append(deparzip);
		buffer.append(" deparadd: ");
		buffer.append(deparadd);
		buffer.append(" departyp: ");
		buffer.append(departyp);
		buffer.append(" depmanag: ");
		buffer.append(depmanag);
		buffer.append(" depproxy: ");
		buffer.append(depproxy);
		buffer.append(" depargrp: ");
		buffer.append(depargrp);
		buffer.append(" counttyp: ");
		buffer.append(counttyp);
		buffer.append(" timezone: ");
		buffer.append(timezone);
		buffer.append(" abrekflg: ");
		buffer.append(abrekflg);
		buffer.append(" updater: ");
		buffer.append(updater);
		buffer.append(" updtime: ");
		buffer.append(updtime);
		buffer.append("]");
		return buffer.toString();
	}

}
