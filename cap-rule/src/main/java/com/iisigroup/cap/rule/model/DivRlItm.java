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
 * Division Rule Item
 * </pre>
 * 
 * @since 2013/12/13
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DIVRLITM", uniqueConstraints = @UniqueConstraint(columnNames = { "divRlNo" }) )
public class DivRlItm extends GenericBean implements IDataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @NotNull
    @Column(length = 10, nullable = false)
    private String divRlNo;

    @NotNull
    @Column(length = 60, nullable = false)
    private String divRlNm;

    /** 均分量化方式 */
    @Column(length = 1)
    private String divRlTyp;

    // @Column(length = 1)
    // private String inputFlg;

    @Column(length = 6)
    private String updater;

    @Column
    private Timestamp updateTime;

    // bi-directional many-to-one association to DivRlDtl
    @OneToMany(mappedBy = "divRlItm", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<DivRlDtl> divRlDtls;

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

    public String getDivRlNm() {
        return divRlNm;
    }

    public void setDivRlNm(String divRlNm) {
        this.divRlNm = divRlNm;
    }

    public String getDivRlTyp() {
        return divRlTyp;
    }

    public void setDivRlTyp(String divRlTyp) {
        this.divRlTyp = divRlTyp;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public List<DivRlDtl> getDivRlDtls() {
        return divRlDtls;
    }

    public void setDivRlDtls(List<DivRlDtl> divRlDtls) {
        this.divRlDtls = divRlDtls;
    }

}
