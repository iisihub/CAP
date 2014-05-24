/* 
 * RoleSetHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.auth.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.auth.model.RoleFunction;
import com.iisigroup.cap.auth.model.RoleSet;
import com.iisigroup.cap.auth.service.RoleSetService;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.IBeanFormatter;
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
 * 角色權限維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("rolesethandler")
public class RoleSetHandler extends MFormHandler {

	@Resource
	private ICommonService commonSrv;

	@Autowired
	private CodeTypeService codeTypeService;

	@Resource
	private RoleSetService roleSetService;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {

		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("usrCount", new IBeanFormatter() {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			public Integer reformat(Object in) throws CapFormatException {
				if (in instanceof Role) {
					return ((Role) in).getrSetList().size();
				}
				return 0;
			}
		});

		Page<Role> page = commonSrv.findPage(Role.class, search);
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	@HandlerType(HandlerTypeEnum.GRID)
	public MapGridResult queryGridUsr(ISearch search, IRequest params) {
		String code = params.get("rolCode");
		if (CapString.isEmpty(code)) {
			return new MapGridResult();
		}

		Page<Map<String, Object>> page = roleSetService.findPageUsr(search,
				code);
		return new MapGridResult(page.getContent(), page.getTotalRow(), null);
	}// ;

	@HandlerType(HandlerTypeEnum.GRID)
	public MapGridResult queryGridFunc(ISearch search, IRequest params) {
		String code = params.get("rolCode");
		if (CapString.isEmpty(code)) {
			return new MapGridResult();
		}

		Page<Map<String, Object>> page = roleSetService.findPageFunc(search,
				code);
		return new MapGridResult(page.getContent(), page.getTotalRow(), null);
	}// ;

	@HandlerType(HandlerTypeEnum.GRID)
	public MapGridResult queryEditUsr(ISearch search, IRequest params)
			throws CapException {
		String unit = params.get("unit");
		String code = params.get("rolCode");

		Page<Map<String, Object>> page = roleSetService.findPageEditUsr(search,
				code, unit);
		return new MapGridResult(page.getContent(), page.getTotalRow(), null);
	}

	@HandlerType(HandlerTypeEnum.GRID)
	public MapGridResult queryEditFunc(ISearch search, IRequest params)
			throws CapException {
		String pgmTyp = params.get("pgmTyp");
		String code = params.get("rolCode");
		String systyp = params.get("systyp");

		Page<Map<String, Object>> page = roleSetService.findPageEditFunc(
				search, code, systyp, pgmTyp);
		return new MapGridResult(page.getContent(), page.getTotalRow(), null);
	}

	public IResult queryForm(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String code = request.get("rolCode");
		Role role = null;

		if (!CapString.isEmpty(code)) {
			role = commonSrv.findById(Role.class, code);
		}

		if (role != null) {
			result.putAll(new AjaxFormResult(role.toJSONObject(
					CapEntityUtil.getColumnName(role), null)));
		}

		return result;
	}

	public IResult getAllBranch(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		result.set("All", CapAppContext.getMessage("All"));
		result.putAll(roleSetService.findAllBranch());

		return result;
	}

	public IResult getAllFunc(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		String systyp = request.get("systyp");
		if (CapString.isEmpty(systyp)) {
			return result;
		}

		result.set("All", CapAppContext.getMessage("All"));
		result.putAll(roleSetService.findAllFunc(systyp));

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
		String code = request.get("roleId");
		String isNew = request.get("isNew");
		Role role = null;

		if (!CapString.isEmpty(code)) {
			role = commonSrv.findById(Role.class, code);
			if (isNew.equals("true") && role != null) {
				throw new CapMessageException(
						CapAppContext.getMessage("js.data.exists"),
						RoleSetHandler.class);
			}
		} else {
			throw new CapMessageException(
					CapAppContext.getMessage("EXCUE_ERROR"),
					RoleSetHandler.class);
		}
		if (role == null) {
			role = new Role();
		}
		CapBeanUtil.map2Bean(request, role, Role.class);
		role.setUpdater(CapSecurityContext.getUserId());
		role.setUpdTime(CapDate.getCurrentTimestamp());
		role.setApprId(CapSecurityContext.getUserId());
		role.setApprTime(CapDate.getCurrentTimestamp());

		commonSrv.save(role);

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
	public IResult saveRlSet(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String code = request.get("rolCode");
		JSONArray usrItem = JSONArray.fromObject(request.get("usrItem"));
		Role role = null;

		if (!CapString.isEmpty(code)) {
			role = commonSrv.findById(Role.class, code);
		}
		if (role == null) {
			throw new CapMessageException(
					CapAppContext.getMessage("EXCUE_ERROR"),
					RoleSetHandler.class);
		}

		List<RoleSet> setUsr = new ArrayList<RoleSet>();
		if (usrItem != null) {
			for (Object item : usrItem) {
				JSONObject usr = (JSONObject) item;
				RoleSet rlset = new RoleSet();
				rlset.setUserId(usr.getString("userId"));
				rlset.setRolCode(role.getRoleId());
				rlset.setUpdater(CapSecurityContext.getUserId());
				rlset.setUpdateTime(CapDate.getCurrentTimestamp());
				setUsr.add(rlset);
			}
		}
		commonSrv.save(setUsr);

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
	public IResult saveRlf(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String code = request.get("rolCode");
		JSONArray funcItem = JSONArray.fromObject(request.get("funcItem"));
		Role role = null;

		if (!CapString.isEmpty(code)) {
			role = commonSrv.findById(Role.class, code);
		}
		if (role == null) {
			throw new CapMessageException(
					CapAppContext.getMessage("EXCUE_ERROR"),
					RoleSetHandler.class);
		}

		List<RoleFunction> setFunc = new ArrayList<RoleFunction>();
		if (funcItem != null) {
			for (Object item : funcItem) {
				JSONObject func = (JSONObject) item;
				RoleFunction rlf = new RoleFunction();
				rlf.setRolCode(role.getRoleId());
				rlf.setPgmCode(func.getString("code"));
				rlf.setUpdater(CapSecurityContext.getUserId());
				rlf.setUpdTime(CapDate.getCurrentTimestamp());
				setFunc.add(rlf);
			}
		}
		commonSrv.save(setFunc);

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
		String roleId = request.get("rolCode");
		Role role = commonSrv.findById(Role.class, roleId);
		if (role != null) {
			commonSrv.delete(role);
		}
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
	public IResult deleteRlSet(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String code = request.get("rolCode");
		JSONArray usrItem = JSONArray.fromObject(request.get("usrItem"));

		if (CapString.isEmpty(code)) {
			throw new CapMessageException(
					CapAppContext.getMessage("EXCUE_ERROR"),
					RoleSetHandler.class);
		}

		List<String> delUsr = new ArrayList<String>();
		if (usrItem != null) {
			for (Object item : usrItem) {
				JSONObject usr = (JSONObject) item;
				delUsr.add(usr.getString("userId"));
			}
		}
		roleSetService.deleteRlset(code, delUsr);

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
	public IResult deleteRlf(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String code = request.get("rolCode");
		JSONArray funcItem = JSONArray.fromObject(request.get("funcItem"));

		if (CapString.isEmpty(code)) {
			throw new CapMessageException(
					CapAppContext.getMessage("EXCUE_ERROR"),
					RoleSetHandler.class);
		}

		List<String> delFunc = new ArrayList<String>();
		if (funcItem != null) {
			for (Object item : funcItem) {
				JSONObject usr = (JSONObject) item;
				delFunc.add(usr.getString("code"));
			}
		}
		roleSetService.deleteRlf(code, delFunc);

		return result;
	}

}
