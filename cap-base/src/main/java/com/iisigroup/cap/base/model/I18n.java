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

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * I18N
 * </pre>
 * 
 * @since 2014/4/24
 * @author Lancelot
 * @version <ul>
 *          <li>2014/4/24,Lancelot,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_I18N", uniqueConstraints = @UniqueConstraint(columnNames = { "locale", "codeType", "codeValue" }))
public class I18n extends GenericBean implements IDataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @NotNull
    @Column(length = 5)
    private String locale;

    @NotNull
    @Column(length = 32, nullable = false)
    private String codeType;

    @Column(length = 32)
    private String codeValue;

    @Column(length = 300)
    private String codeDesc;

    @Column(nullable = false, length = 3)
    private Integer codeOrder;

    @Column(length = 6)
    private String updater;

    @Column
    private Timestamp updateTime;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public Integer getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(Integer codeOrder) {
        this.codeOrder = codeOrder;
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

}
