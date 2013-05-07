/* 
 * ReserveHandler.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.bqd.poc.sample;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;

/**
 * <pre>
 * 預約開戶
 * </pre>
 * 
 * @since 2013/5/7
 * @author iristu
 * @version <ul>
 *          <li>2013/5/7,iristu,new
 *          </ul>
 */
@Scope("request")
@Controller("reservehandler")
public class ReserveHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonService;

	@SuppressWarnings("unchecked")
	public IResult openAcc(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String custId = request.get("custId");
		OpenAcct acct = commonService.findById(OpenAcct.class, custId);
		if (acct == null) {
			acct = new OpenAcct();
			acct.setCustId(custId);
		}
		Map<String, Object> map = request.getServletRequest().getParameterMap();
		String[] keys = new String[map.size()];
		map.keySet().toArray(keys);
		acct.setJsonData(CapBeanUtil.map2Json(map, keys).toString());
		acct.setUpdateTime(CapDate.getCurrentTimestamp());
		commonService.save(acct);
		return result;
	}
}
