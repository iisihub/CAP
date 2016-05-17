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
package com.iisigroup.cap.rule.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.db.model.DataObject;
import com.iisigroup.cap.db.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * Division Rule Details
 * </pre>
 * 
 * @since 2013/12/19
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/19,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity

@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DIVCTDTL", uniqueConstraints = @UniqueConstraint(columnNames = { "oid" }))
public class DivCtDtl extends GenericBean implements DataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @NotNull
    @Column(length = 10, nullable = false)
    private String divCtNo;

    @Column(length = 10)
    private String divRlNo;

    @Column(length = 10)
    private String factorNo;

    @Column(length = 10)
    private String rangeNo;

    @Column(length = 5000)
    private String divCtJson;

    /** 排序 */
    @Column(length = 3)
    private BigDecimal divCtSor;

    // bi-directional many-to-one association to DivCtItm
    @ManyToOne
    @JoinColumn(name = "divCtNo", referencedColumnName = "divCtNo", nullable = false, insertable = false, updatable = false)
    private DivCtItm divCtItm;

    // bi-directional many-to-one association to DivFtDtl
    @ManyToOne
    @JoinColumns({ @JoinColumn(name = "factorNo", referencedColumnName = "factorNo", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "rangeNo", referencedColumnName = "rangeNo", nullable = false, insertable = false, updatable = false) })
    private DivFtDtl divFtDtl;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDivCtNo() {
        return divCtNo;
    }

    public void setDivCtNo(String divCtNo) {
        this.divCtNo = divCtNo;
    }

    public String getDivCtJson() {
        return divCtJson;
    }

    public void setDivCtJson(String divCtJson) {
        this.divCtJson = divCtJson;
    }

    public BigDecimal getDivCtSor() {
        return divCtSor;
    }

    public void setDivCtSor(BigDecimal divCtSor) {
        this.divCtSor = divCtSor;
    }

    public DivCtItm getDivCtItm() {
        return divCtItm;
    }

    public void setDivCtItm(DivCtItm divCtItm) {
        this.divCtItm = divCtItm;
    }

    public String getDivRlNo() {
        return divRlNo;
    }

    public void setDivRlNo(String divRlNo) {
        this.divRlNo = divRlNo;
    }

    public String getFactorNo() {
        return factorNo;
    }

    public void setFactorNo(String factorNo) {
        this.factorNo = factorNo;
    }

    public DivFtDtl getDivFtDtl() {
        return divFtDtl;
    }

    public void setDivFtDtl(DivFtDtl divFtDtl) {
        this.divFtDtl = divFtDtl;
    }

    public String getRangeNo() {
        return rangeNo;
    }

    public void setRangeNo(String rangeNo) {
        this.rangeNo = rangeNo;
    }

}
