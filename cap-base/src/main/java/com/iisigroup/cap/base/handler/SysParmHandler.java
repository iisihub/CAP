/* 
 * SysParmHandler.java
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
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.formatter.ADDateFormatter;
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
 * 系統參數處理
 * </pre>
 * 
 * @since 2012/10/25
 * @author iristu
 * @version <ul>
 *          <li>2012/10/25,iristu,new
 *          </ul>
 */
@Scope("request")
@Controller("sysparmhandler")
public class SysParmHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonSrv;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {

		if (!CapString.isEmpty(params.get("parmId"))) {
			search.addSearchModeParameters(SearchMode.LIKE, "parmId",
					params.get("parmId") + "%");
		}
		if (!search.hasOrderBy()) {
			search.addOrderBy("parmId");
		}
		Page<SysParm> page = commonSrv.findPage(SysParm.class, search);
		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("updateTime", new ADDateFormatter());
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/**
	 * modify SysParm
	 * 
	 * @param request
	 *            request
	 * @return IResult
	 */
	public IResult modify(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		SysParm parm = commonSrv.findById(SysParm.class, request.get("parmId"));
		if (parm == null) {
			parm = new SysParm();
		}
		CapBeanUtil.map2Bean(request, parm, SysParm.class);
		parm.setUpdater(CapSecurityContext.getUserId());
		parm.setUpdateTime(CapDate.getCurrentTimestamp());
		commonSrv.save(parm);
		return result;
	}

	/**
	 * delete SysParm
	 * 
	 * @param request
	 *            request
	 * @return IResult
	 */
	public IResult delete(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String[] ids = request.getParamsAsStringArray("parmId");
		for (String id : ids) {
			SysParm parm = commonSrv.findById(SysParm.class, id);
			if (parm != null) {
				commonSrv.delete(parm);
			}
		}
		return result;
	}

}
