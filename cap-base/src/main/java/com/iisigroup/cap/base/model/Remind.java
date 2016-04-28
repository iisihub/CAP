/* 
 * Remind.java
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

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.DataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <p>
 * 提醒通知檔.
 * </p>
 * 
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/27,tammy,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "CFG_REMIND", uniqueConstraints = @UniqueConstraint(columnNames = "oid") )
public class Remind extends GenericBean implements DataObject {

    /** id */
    @Id
    @Column(length = 32, nullable = false)
    private String oid;
    /** 內文 */
    @Column(length = 2000)
    private String content;
    /** 0.個人 1.組別(業務) 2.群組 3.部門 9.全體 */
    @Column(length = 1)
    private String scopeTyp;
    /** 對象號碼 */
    @Column(length = 10)
    private String scopePid;
    /** 資料有效期間 */
    private Timestamp startDate;
    /** 資料有效期間 */
    private Timestamp endDate;
    /** 建立時間 */
    private Timestamp crTime;
    /** 語系 */
    @Column(length = 5)
    private String locale;
    /** 最後異動人員 */
    @Column(length = 10)
    private String updater;
    /** 修改時間 */
    private Timestamp updTime;

    @OneToMany(mappedBy = "remind", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reminds> reminds;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScopeTyp() {
        return scopeTyp;
    }

    public void setScopeTyp(String scopeTyp) {
        this.scopeTyp = scopeTyp;
    }

    public String getScopePid() {
        return scopePid;
    }

    public void setScopePid(String scopePid) {
        this.scopePid = scopePid;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getCrTime() {
        return crTime;
    }

    public void setCrTime(Timestamp crTime) {
        this.crTime = crTime;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Timestamp updTime) {
        this.updTime = updTime;
    }

    public List<Reminds> getReminds() {
        return reminds;
    }

    public void setReminds(List<Reminds> reminds) {
        this.reminds = reminds;
    }

}
