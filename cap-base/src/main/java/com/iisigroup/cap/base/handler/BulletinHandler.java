/* 
 * BulletinHandler.java
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
import com.iisigroup.cap.base.formatter.CodeTypeFormatter;
import com.iisigroup.cap.base.model.Bulletin;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
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
 * 公告訊息維護
 * </pre>
 * 
 * @since 2014/2/4
 * @author tammy
 * @version <ul>
 *          <li>2014/2/4,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("bulletinhandler")
public class BulletinHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonSrv;

	@Resource
	private CodeTypeService codeTypeService;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {
		String title = params.get("title");
		String status = params.get("status");
		if (!CapString.isEmpty(title)) {
			search.addSearchModeParameters(SearchMode.LIKE, "title", title);
		}
		if (!CapString.isEmpty(status)) {
			search.addSearchModeParameters(SearchMode.EQUALS, "status", status);
		}

		search.addOrderBy("startDate");

		Map<String, IFormatter> dataReformatter = new HashMap<String, IFormatter>();
		dataReformatter.put("level", new CodeTypeFormatter(codeTypeService,
				"level"));
		dataReformatter.put("status", new CodeTypeFormatter(codeTypeService,
				"status"));

		Page<Bulletin> page = commonSrv.findPage(Bulletin.class, search);
		return new GridResult(page.getContent(), page.getTotalRow(),
				dataReformatter);
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
		Bulletin bulletin = null;

		if (!CapString.isEmpty(oid)) {
			bulletin = commonSrv.findById(Bulletin.class, oid);
		}

		if (bulletin == null) {
			bulletin = new Bulletin();
			bulletin.setCrTime(CapDate.getCurrentTimestamp());
		}
		CapBeanUtil.map2Bean(request, bulletin, Bulletin.class);
		bulletin.setUpdater(CapSecurityContext.getUserId());
		bulletin.setUpdTime(CapDate.getCurrentTimestamp());
		bulletin.setLevel(request.get("level"));

		commonSrv.save(bulletin);

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
		Bulletin bulletin = commonSrv.findById(Bulletin.class,
				request.get("oid"));
		if (bulletin != null) {
			commonSrv.delete(bulletin);
		}
		return result;
	}

}
