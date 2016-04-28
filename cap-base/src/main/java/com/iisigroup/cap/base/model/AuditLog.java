/* 
 * AuditLog.java
 * 
 * Copyright (c) 2009-2014 International Integrated System, Inc. 
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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.DataObject;

/**
 * <pre>
 * 使用軌跡 persistence model.
 * </pre>
 * 
 * @since 2014/1/16
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2014/1/16,Sunkist Wang,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AUDIT_LOG", uniqueConstraints = @UniqueConstraint(columnNames = "id") )
public class AuditLog extends GenericBean implements DataObject {
    /** unique id */
    @Id
    @Column(length = 32, nullable = false)
    private String id;

    /** 使用者SSOID */
    @Column(name = "user_id", length = 20)
    private String userId;

    /** IP 位址 */
    @Column(name = "ip_address", length = 50)
    private String ipAddress;

    /** 作業代號 */
    @Column(name = "function_id", length = 20)
    private String functionId;

    /** 新增/修改/刪除/查詢/匯出/匯入 */
    @Column(length = 20)
    private String action;

    /** 執行時間 */
    @Column(name = "execute_date")
    private Timestamp executeDate;

    /** 備註/Key值 */
    @Column(length = 50)
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Timestamp executeDate) {
        this.executeDate = executeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOid() {
        return id;
    }

    public void setOid(String oid) {
        this.id = oid;
    }

}
