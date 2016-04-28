/* 
 * RoleFunction.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.auth.model;

import java.sql.Timestamp;

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
@Table(name = "DEF_ROLEFUNC", uniqueConstraints = @UniqueConstraint(columnNames = { "ROLECODE", "FUNCCODE" }) )
public class RoleFunction extends GenericBean implements IDataObject {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @Column(length = 10)
    private String roleCode;

    @Column(length = 6)
    private String funcCode;

    @Column(length = 10)
    private String updater;

    @Column
    private Timestamp updateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumns({ @JoinColumn(name = "ROLECODE", referencedColumnName = "CODE", nullable = false, insertable = false, updatable = false) })
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumns({ @JoinColumn(name = "FUNCCODE", referencedColumnName = "CODE", nullable = false, insertable = false, updatable = false) })
    private Function function;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
