/* 
 * PgmSetHandler.java
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.formatter.CodeTypeFormatter;
import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.model.RoleFunction;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.base.service.PgmSetService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.jpa.utils.CapEntityUtil;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.response.MapGridResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 系統功能維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("pgmsethandler")
public class PgmSetHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonSrv;

	@Autowired
	private CodeTypeService codeTypeService;

	@Resource
	private PgmSetService pgmSetService;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {
		String sysTyp = params.get("sysTyp");
		String pgmType = params.get("pgmType");
		String pgmCode = params.get("pgmCode");
		String pgmName = params.get("pgmName");

		if (!CapString.isEmpty(sysTyp)) {
			search.addSearchModeParameters(SearchMode.EQUALS, "sysTyp", sysTyp);
		}
		if (!CapString.isEmpty(pgmType)) {
			search.addSearchModeParameters(SearchMode.EQUALS, "step", pgmType);
		}
		if (!CapString.isEmpty(pgmCode)) {
			search.addSearchModeParameters(SearchMode.EQUALS, "code", pgmCode);
		}
		if (!CapString.isEmpty(pgmName)) {
			search.addSearchModeParameters(SearchMode.EQUALS, "name", pgmName);
		}

		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("SYSNAME", new CodeTypeFormatter(codeTypeService, "authSysId"));

		Page<CodeItem> page = commonSrv.findPage(CodeItem.class, search);
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	@HandlerType(HandlerTypeEnum.GRID)
	public MapGridResult queryRle(ISearch search, IRequest params) {
		String sysTyp = params.get("sysTyp");
		String pgmCode = params.get("pgmCode");
		if (CapString.isEmpty(pgmCode)) {
			new GridResult();
		}

		Page<Map<String, Object>> page = pgmSetService.findPage(search, sysTyp,
				pgmCode);
		return new MapGridResult(page.getContent(), page.getTotalRow(), null);
	}// ;

	public IResult queryForm(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String code = request.get("pgmCode");
		CodeItem codeItem = null;

		if (!CapString.isEmpty(code)) {
			codeItem = pgmSetService.find(code);
		}

		if (codeItem != null) {
			result.putAll(new AjaxFormResult(codeItem.toJSONObject(
					CapEntityUtil.getColumnName(codeItem), null)));
		}

		return result;
	}

	public IResult loadPgm(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		String SYSTYP = request.get("SYSTYP");
		String TYPE = request.get("TYPE");

		List<CodeItem> codeItems = pgmSetService.findBySystypAndStep(SYSTYP,
				TYPE);

		if (!CollectionUtils.isEmpty(codeItems)) {
			JSONArray codeItem = new JSONArray();
			for(CodeItem item : codeItems){
				codeItem.add(item.toJSONObject(
						CapEntityUtil.getColumnName(item), null));
			}
			result.set("codeItem", codeItem.toString());
		}

		return result;
	}

	public IResult queryRole(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		String SYSTYP = request.get("SYSTYP");
		// String code = request.get("pgmCode");

		List<Map<String, Object>> roleItems = pgmSetService.findAllRole(SYSTYP);

		if (!CollectionUtils.isEmpty(roleItems)) {
			result.set("roles", JSONArray.fromObject(roleItems).toString());
		}

		return result;
	}

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
		String code = request.get("code");
		JSONArray roleItem = JSONArray.fromObject(request.get("roleItem"));
		String isNew = request.get("isNew");
		CodeItem codeItem = null;

		if (!CapString.isEmpty(code)) {
			codeItem = pgmSetService.find(code);
			if (isNew.equals("true") && codeItem != null) {
				throw new CapMessageException(
						CapAppContext.getMessage("js.data.exists"),
						PgmSetHandler.class);
			}
		}
		if (codeItem == null) {
			codeItem = new CodeItem();
		}
		CapBeanUtil.map2Bean(request, codeItem, CodeItem.class);
		codeItem.setUPDATER(CapSecurityContext.getUserId());
		codeItem.setUPDATETIME(CapDate.getCurrentTimestamp());

		List<RoleFunction> rlfList = new ArrayList<RoleFunction>();
		if (roleItem != null) {
			for (Object role : roleItem) {
				JSONObject rle = (JSONObject) role;
				RoleFunction rlf = new RoleFunction();
				rlf.setRolCode(rle.getString("rolCode"));
				rlf.setPgmCode(Integer.toString(codeItem.getCode()));
				rlf.setUPDATER(CapSecurityContext.getUserId());
				rlf.setUPDTIME(CapDate.getCurrentTimestamp());
				rlfList.add(rlf);
			}
		}
		codeItem.setRlfList(rlfList);

		pgmSetService.savePgm(codeItem);

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
		CodeItem code = pgmSetService.find(request.get("pgmCode"));
		if (code != null) {
			commonSrv.delete(code);
		}
		return result;
	}

}
