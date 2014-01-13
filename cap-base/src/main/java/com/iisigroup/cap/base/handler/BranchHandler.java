/* 
 * BranchHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.handler;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.Branch;
import com.iisigroup.cap.base.service.BranchService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 分行維護
 * </pre>
 * 
 * @since 2014/1/13
 * @author tammy
 * @version <ul>
 *          <li>2014/1/13,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("branchhandler")
public class BranchHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonSrv;

	@Resource
	private BranchService branchService;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {
		search.addOrderBy("departno");

		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();

		Page<Branch> page = commonSrv.findPage(Branch.class, search);
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/**
	 * 編輯資料
	 * 
	 * @param request
	 *            IRequest
	 * @return {@link tw.com.iisi.cap.response.IResult}
	 * @throws CapException
	 */
	public IResult save(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String oid = request.get("oid");
		String brNo = request.get("departno");
		Branch branch = null;

		if (CapString.isEmpty(oid)) {
			branch = branchService.findByBrno(brNo);
			if (branch != null) {
				result.set("exist", Boolean.TRUE);
				return result;
			}
		} else {
			branch = commonSrv.findById(Branch.class, oid);
		}

		if (branch == null) {
			branch = new Branch();
			branch.setOid(null);
		}
		CapBeanUtil.map2Bean(request, branch, Branch.class);
		branch.setUpdater(CapSecurityContext.getUserId());
		branch.setUpdtime(CapDate.getCurrentTimestamp());
		branchService.save(branch);

		return result;
	}

	/**
	 * 刪除資料
	 * 
	 * @param request
	 *            IRequest
	 * @return {@link tw.com.iisi.cap.response.IResult}
	 * @throws CapException
	 */
	public IResult delete(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		Branch code = commonSrv
				.findById(Branch.class, request.get("oid"));
		if (code != null) {
			commonSrv.delete(code);
		}
		return result;
	}

}
