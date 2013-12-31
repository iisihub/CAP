/* 
 * AuditConfigHandler.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.formatter.CodeTypeFormatter;
import com.iisigroup.cap.base.model.AuditConfig;
import com.iisigroup.cap.base.service.AuditConfigService;
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
 * 操作紀錄查詢
 * </pre>
 * 
 * @since 2013/12/31
 * @author tammy
 * @version <ul>
 *          <li>2013/12/31,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("audithandler")
public class AuditConfigHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonSrv;

	@Resource
	private AuditConfigService auditConfigService;

	@Autowired
	private CodeTypeService codeTypeService;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {

		if (!CapString.isEmpty(params.get("targetName"))) {
			search.addSearchModeParameters(SearchMode.LIKE, "targetName",
					params.get("targetName"));
		}
		if (!CapString.isEmpty(params.get("disableType"))) {
			search.addSearchModeParameters(SearchMode.EQUALS, "disableType",
					params.get("disableType"));
		}

		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		// fmt.put("lastModifyBy", new UserNameFormatter(this.userService));
		fmt.put("disableType", new CodeTypeFormatter(this.codeTypeService,
				"DisableType"));

		Page<AuditConfig> page = commonSrv.findPage(AuditConfig.class, search);
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/**
	 * 編輯資料
	 * 
	 * @param params
	 *            {@link org.apache.wicket.PageParameters}
	 * @param parent
	 *            {@link org.apache.wicket.Component}
	 * @return {@link tw.com.iisi.cap.response.IResult}
	 * @throws CapException
	 */
	public IResult save(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String oid = request.get("oid");
		String targetName = request.get("targetName");
		String disableType = request.get("disableType");
		AuditConfig audit = null;

		if (CapString.isEmpty(oid)) {
			audit = auditConfigService.find(targetName, disableType);
			if (audit != null) {
				result.set("exist", Boolean.TRUE);
				return result;
			}
		} else {
			audit = commonSrv.findById(AuditConfig.class, oid);
		}

		if (audit == null) {
			audit = new AuditConfig();
			audit.setOid(null);
		}
		CapBeanUtil.map2Bean(request, audit, AuditConfig.class);
		audit.setLastModifyBy(CapSecurityContext.getUserId());
		audit.setLastModifyTime(CapDate.getCurrentTimestamp());
		auditConfigService.save(audit);

		return result;
	}

	/**
	 * 刪除資料
	 * 
	 * @param params
	 *            {@link org.apache.wicket.PageParameters}
	 * @param parent
	 *            {@link org.apache.wicket.Component}
	 * @return {@link tw.com.iisi.cap.response.IResult}
	 * @throws CapException
	 */
	public IResult delete(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		AuditConfig audit = commonSrv.findById(AuditConfig.class,
				request.get("oid"));
		if (audit != null) {
			auditConfigService.delete(audit);
		}
		return result;
	}

}
