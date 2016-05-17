/* 
 * Role.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.auth.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.db.model.DataObject;
import com.iisigroup.cap.db.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.security.model.Role;

/**
 * <pre>
 * 使用者資訊
 * </pre>
 * 
 * @since 2013/12/23
 * @author tammy
 * @version
 *          <ul>
 *          <li>2013/12/23,tammy,new
 *          </ul>
 */

@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = { "CODE" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "P")
public class DefaultRole extends GenericBean implements DataObject, Role {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @Column(length = 10)
    private String code;

    @Column(length = 48)
    private String name;

    @Column(length = 1)
    private String sysType;

    @Column(length = 1)
    private String status;

    @Column(length = 60)
    private String desc;

    @Column(length = 10)
    private String updater;

    @Column
    private Timestamp updateTime;

    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<RoleFunction> rfList;

    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<UserRole> urList;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public List<RoleFunction> getRfList() {
        return rfList;
    }

    public void setRfList(List<RoleFunction> rfList) {
        this.rfList = rfList;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public List<UserRole> getUrList() {
        return urList;
    }

    public void setUrList(List<UserRole> urList) {
        this.urList = urList;
    }

}
