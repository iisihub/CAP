/* 
 * ElsUser.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.auth.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.security.model.IRole;
import com.iisigroup.cap.security.model.IUser;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 使用者資訊
 * </pre>
 * 
 * @since 2013/12/23
 * @author tammy
 * @version <ul>
 *          <li>2013/12/23,tammy,new
 *          </ul>
 */

@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_USR")
public class User extends GenericBean implements IDataObject, IUser {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, length = 32)
    private String oid;

    @Column(name = "STAFFPID", length = 10)
    private String userId;

    @Column(name = "STAFFPNM", length = 12)
    private String userName;

    @Column(name = "DEPARTNO", length = 4)
    private String unitNo;

    @Column(length = 1)
    private String applyNf;

    @Column(length = 30)
    private String applyRem;

    @Column(precision = 5, scale = 2)
    private BigDecimal weights;

    @Column(length = 6)
    private String updater;

    @Column
    private Timestamp updateTime;

    // bi-directional one-to-one association to Branch
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumns({ @JoinColumn(name = "DEPARTNO", referencedColumnName = "departno", nullable = true, insertable = false, updatable = false) })
    private Branch branch;

    @OneToMany(mappedBy = "roleSet_usr", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<RoleSet> rlSet;

    @Column(length = 100)
    private String password;

    @Column(length = 128)
    private String email;

    @Column(length = 1)
    private String status;

    @Column(length = 1)
    private String preStatus;

    @Column
    private Timestamp createTime;

    @Column(length = 6)
    private String creator;

    /**
     * @return Oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid
     *            oid
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = CapString.trimFullSpace(userName);
        this.userName = userName;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getApplyNf() {
        return applyNf;
    }

    public void setApplyNf(String applyNf) {
        this.applyNf = applyNf;
    }

    public String getApplyRem() {
        return applyRem;
    }

    public void setApplyRem(String applyRem) {
        this.applyRem = applyRem;
    }

    public BigDecimal getWeights() {
        return weights;
    }

    public void setWeights(BigDecimal weights) {
        this.weights = weights;
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

    @Override
    public List<? extends IRole> getRoles() {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<RoleSet> getRlSet() {
        return rlSet;
    }

    public void setRlSet(List<RoleSet> rlSet) {
        this.rlSet = rlSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}
