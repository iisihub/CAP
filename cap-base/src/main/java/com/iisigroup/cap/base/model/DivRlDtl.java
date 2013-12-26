/* 
 * CodeType.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * Division Rule Details
 * </pre>
 * 
 * @since 2013/12/19
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/19,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DIVRLDTL", uniqueConstraints = @UniqueConstraint(columnNames = {
		"oid" }))
public class DivRlDtl extends GenericBean implements IDataObject {

	@Id
	@Column(nullable = false, length = 32)
	private String oid;

	@NotNull
	@Column(length = 10, nullable = false)
	private String divRlNo;

	@NotNull
	@Column(length = 10, nullable = false)
	private String divCtNo;

	@Column(length = 5000)
	private String divRlJson;

	/**排序*/
	@Column(length = 3)
	private BigDecimal divRlSor;

	// bi-directional many-to-one association to DivRlItm
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "divRlNo", referencedColumnName = "divRlNo", nullable = false, insertable=false, updatable=false)
	private DivRlItm divRlItm;

//	// bi-directional many-to-one association to DivCtDtl
//	@OneToMany(mappedBy = "divRlDtl", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//	private List<DivCtDtl> divCtDtls;
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getDivRlNo() {
		return divRlNo;
	}

	public void setDivRlNo(String divRlNo) {
		this.divRlNo = divRlNo;
	}

	public String getDivCtNo() {
		return divCtNo;
	}

	public void setDivCtNo(String divCtNo) {
		this.divCtNo = divCtNo;
	}

	public DivRlItm getDivRlItm() {
		return divRlItm;
	}

	public void setDivRlItm(DivRlItm divRlItm) {
		this.divRlItm = divRlItm;
	}

	public BigDecimal getDivRlSor() {
		return divRlSor;
	}

	public void setDivRlSor(BigDecimal divRlSor) {
		this.divRlSor = divRlSor;
	}

	public String getDivRlJson() {
		return divRlJson;
	}

	public void setDivRlJson(String divRlJson) {
		this.divRlJson = divRlJson;
	}

//	public List<DivCtDtl> getDivCtDtls() {
//		return divCtDtls;
//	}
//
//	public void setDivCtDtls(List<DivCtDtl> divCtDtls) {
//		this.divCtDtls = divCtDtls;
//	}

}
