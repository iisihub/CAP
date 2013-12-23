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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * Division Factor Details
 * </pre>
 * 
 * @since 2013/12/20
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/20,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DIVFTDTL", uniqueConstraints = @UniqueConstraint(columnNames = { "oid" }))
public class DivFtDtl extends GenericBean implements IDataObject {

	@Id
	@Column(nullable = false, length = 32)
	private String oid;

	@NotNull
	@Column(length = 10, nullable = false)
	private String factorNo;

	@NotNull
	@Column(length = 10, nullable = false)
	private String rangeNo;
	
	@Column(length = 60)
	private String rangeNm;

	/** 值域1 */
	@Column(length = 100)
	private String range1;

	/** 值域2 */
	@Column(length = 100)
	private String range2;
	
	@Column(precision=2, scale=0)
	private BigDecimal rangeSor;
	
	// bi-directional many-to-one association to DivFtItm
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "factorNo", referencedColumnName = "factorNo", nullable = false, insertable=false, updatable=false)
	private DivFtItm divFtItm;
	
	// bi-directional many-to-one association to DivCtDtl
	@OneToMany(mappedBy = "divFtDtl", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<DivCtDtl> divCtDtls;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getFactorNo() {
		return factorNo;
	}

	public void setFactorNo(String factorNo) {
		this.factorNo = factorNo;
	}

	public String getRangeNo() {
		return rangeNo;
	}

	public void setRangeNo(String rangeNo) {
		this.rangeNo = rangeNo;
	}

	public String getRangeNm() {
		return rangeNm;
	}

	public void setRangeNm(String rangeNm) {
		this.rangeNm = rangeNm;
	}

	public String getRange1() {
		return range1;
	}

	public void setRange1(String range1) {
		this.range1 = range1;
	}

	public String getRange2() {
		return range2;
	}

	public void setRange2(String range2) {
		this.range2 = range2;
	}

	public BigDecimal getRangeSor() {
		return rangeSor;
	}

	public void setRangeSor(BigDecimal rangeSor) {
		this.rangeSor = rangeSor;
	}

	public DivFtItm getDivFtItm() {
		return divFtItm;
	}

	public void setDivFtItm(DivFtItm divFtItm) {
		this.divFtItm = divFtItm;
	}

	public List<DivCtDtl> getDivCtDtls() {
		return divCtDtls;
	}

	public void setDivCtDtls(List<DivCtDtl> divCtDtls) {
		this.divCtDtls = divCtDtls;
	}

}
