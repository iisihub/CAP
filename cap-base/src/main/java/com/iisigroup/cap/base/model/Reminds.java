/* 
 * Reminds.java
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <p>
 * 通知方式檔.
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
@Table(name = "CFG_REMINDS", uniqueConstraints = @UniqueConstraint(columnNames = "oid") )
public class Reminds extends GenericBean implements IDataObject {

    /** id */
    @Id
    @Column(length = 32, nullable = false)
    private String oid;
    /** pid */
    @Column(length = 32, nullable = false)
    private String pid;
    /** 對象號碼 */
    @Column(length = 10)
    private String scopePid;
    /** 提醒方式 */
    @Column(length = 1)
    private String styleTyp;
    /** 顏色 */
    @Column(length = 1)
    private String styleClr;
    /** 數值 */
    @Column(precision = 5)
    private BigDecimal style;
    /** 單位 */
    private BigDecimal unit;
    /** 是否完成 */
    @Column(length = 1)
    private String ynFlag;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumns({ @JoinColumn(name = "pid", referencedColumnName = "oid", nullable = false, insertable = false, updatable = false) })
    private Remind remind;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getScopePid() {
        return scopePid;
    }

    public void setScopePid(String scopePid) {
        this.scopePid = scopePid;
    }

    public String getStyleTyp() {
        return styleTyp;
    }

    public void setStyleTyp(String styleTyp) {
        this.styleTyp = styleTyp;
    }

    public String getStyleClr() {
        return styleClr;
    }

    public void setStyleClr(String styleClr) {
        this.styleClr = styleClr;
    }

    public BigDecimal getStyle() {
        return style;
    }

    public void setStyle(BigDecimal style) {
        this.style = style;
    }

    public BigDecimal getUnit() {
        return unit;
    }

    public void setUnit(BigDecimal unit) {
        this.unit = unit;
    }

    public String getYnFlag() {
        return ynFlag;
    }

    public void setYnFlag(String ynFlag) {
        this.ynFlag = ynFlag;
    }

    public Remind getRemind() {
        return remind;
    }

    public void setRemind(Remind remind) {
        this.remind = remind;
    }

}
