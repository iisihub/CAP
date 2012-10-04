/* 
 * CapFunction.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.acl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.security.model.IFunction;

/**
 * <pre>
 * 交易資訊
 * </pre>
 * 
 * @since 2012/10/3
 * @author iristu
 * @version <ul>
 *          <li>2012/10/3,iristu,new
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FuncPR", uniqueConstraints = @UniqueConstraint(columnNames = { "funcId" }))
public class CapFunction implements IFunction {

	@Id
	@Column(nullable = false, length = 10)
	private String funcId;

	@Column(length = 30)
	private String funcDesc;

	@Column(nullable = false, length = 30)
	private String funcUrl;

	@Column(length = 10)
	private String funcParent;

	@Column(columnDefinition = "decimal(3,0)")
	private Integer funcOrder;

	@ManyToMany
	@JoinTable(name = "RoleFuncMapping", 
		joinColumns = { @JoinColumn(name = "FUNC_ID", referencedColumnName = "funcId") }, 
		inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId") })
	private List<CapRole> funcRoles;

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public String getFuncParent() {
		return funcParent;
	}

	public void setFuncParent(String funcParent) {
		this.funcParent = funcParent;
	}

	public int getFuncOrder() {
		if (funcOrder != null) {
			return funcOrder.intValue();
		}
		return 0;
	}

	public void setFuncOrder(Integer funcOrder) {
		if (funcOrder != null) {
			this.funcOrder = funcOrder;
		}
		funcOrder = 0;
		this.funcOrder = funcOrder;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncDesc() {
		return funcDesc;
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}

	public List<CapRole> getFuncRoles() {
		return funcRoles;
	}

	public void setFuncRoles(List<CapRole> funcRoles) {
		this.funcRoles = funcRoles;
	}
}
