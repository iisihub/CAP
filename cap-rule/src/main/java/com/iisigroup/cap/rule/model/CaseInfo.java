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
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.db.model.DataObject;
import com.iisigroup.cap.db.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * Case info 案件基本資料
 * </pre>
 * 
 * @since 2013/12/18
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/18,TimChiang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity

@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "CASEINFO", uniqueConstraints = @UniqueConstraint(columnNames = { "casNo" }))
public class CaseInfo extends GenericBean implements DataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @NotNull
    @Column(length = 20, nullable = false)
    private String casNo;

    /** 部門ID */
    @Column(length = 20)
    private String departNo;

    /** 群組ID */
    @Column(length = 20)
    private String grpUppId;

    /** 經辦ID */
    @Column(length = 20)
    private String cpsGrpId;

    @Column(length = 6)
    private String creator;

    @Column
    private Timestamp createTime;

    @Column(length = 6)
    private String updater;

    @Column
    private Timestamp updateTime;

    @Column(length = 1)
    private String isClosed;

    @Column
    private Timestamp deletedTime;

    @Column(length = 20)
    private String docStatus;

    @Column(precision = 12, scale = 3)
    private BigDecimal amount;

    @Column(length = 10)
    private int overDueDay;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCasNo() {
        return casNo;
    }

    public void setCasNo(String casNo) {
        this.casNo = casNo;
    }

    /** 部門ID */
    public String getDepartNo() {
        return departNo;
    }

    /** 部門ID */
    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

    /** 群組ID */
    public String getGrpUppId() {
        return grpUppId;
    }

    /** 群組ID */
    public void setGrpUppId(String grpUppId) {
        this.grpUppId = grpUppId;
    }

    /** 經辦ID */
    public String getCpsGrpId() {
        return cpsGrpId;
    }

    /** 經辦ID */
    public void setCpsGrpId(String cpsGrpId) {
        this.cpsGrpId = cpsGrpId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public Timestamp getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Timestamp deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getOverDueDay() {
        return overDueDay;
    }

    public void setOverDueDay(int overDueDay) {
        this.overDueDay = overDueDay;
    }

}
