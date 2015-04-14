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
import javax.persistence.OneToOne;
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
 * @version <ul>
 *          <li>2013/12/13,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DIVCTITM", uniqueConstraints = @UniqueConstraint(columnNames = { "oid" }))
public class DivCtItm extends GenericBean implements IDataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @NotNull
    @Column(length = 10, nullable = false)
    private String divCtNo;

    @NotNull
    @Column(length = 60)
    private String divCtNm;

    /** 條件屬性-動作or條件 */
    @Column(length = 1)
    private String divCtTyp;

    /** 分派處理/組別 */
    @Column(length = 30)
    private String divCtAction;

    /** 分派設定 */
    @Column(length = 30)
    private String divCtSetting;

    @Column(length = 6)
    private String updater;

    @Column
    private Timestamp updateTime;

    // bi-directional many-to-one association to DivCtDtl
    @OneToMany(mappedBy = "divCtItm", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<DivCtDtl> divCtDtls;

    // bi-directional many-to-one association to DivCtDtl
    // @OneToOne(mappedBy = "divCtItm", cascade = CascadeType.PERSIST, fetch =
    // FetchType.LAZY)
    // private DivRlDtl divRlDtl;

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

    public String getDivCtNm() {
        return divCtNm;
    }

    public void setDivCtNm(String divCtNm) {
        this.divCtNm = divCtNm;
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

    /**
     * 條件屬性-動作or條件
     * 
     * @return String
     */
    public String getDivCtTyp() {
        return divCtTyp;
    }

    /**
     * 條件屬性-動作or條件
     * 
     * @param divCtTyp
     */
    public void setDivCtTyp(String divCtTyp) {
        this.divCtTyp = divCtTyp;
    }

    public List<DivCtDtl> getDivCtDtls() {
        return divCtDtls;
    }

    public void setDivCtDtls(List<DivCtDtl> divCtDtls) {
        this.divCtDtls = divCtDtls;
    }

    public String getDivCtAction() {
        return divCtAction;
    }

    public void setDivCtAction(String divCtAction) {
        this.divCtAction = divCtAction;
    }

    public String getDivCtSetting() {
        return divCtSetting;
    }

    public void setDivCtSetting(String divCtSetting) {
        this.divCtSetting = divCtSetting;
    }

    // public DivRlDtl getDivRlDtl() {
    // return divRlDtl;
    // }
    //
    // public void setDivRlDtl(DivRlDtl divRlDtl) {
    // this.divRlDtl = divRlDtl;
    // }

}