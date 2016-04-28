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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.auth.model.RoleFunction;
import com.iisigroup.cap.auth.model.UserRole;
import com.iisigroup.cap.auth.service.RoleSetService;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.IBeanFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.response.MapGridResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapEntityUtil;
import com.iisigroup.cap.utils.CapString;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <pre>
 * 角色權限維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
@Controller("rolesethandler")
public class RoleSetHandler extends MFormHandler {

    @Resource
    private CommonService commonSrv;

    @Autowired
    private CodeTypeService codeTypeService;

    @Resource
    private RoleSetService roleSetService;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult query(SearchSetting search, IRequest params) {

        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("userCount", new IBeanFormatter() {
            private static final long serialVersionUID = 1L;

            @SuppressWarnings("unchecked")
            public Integer reformat(Object in) throws CapFormatException {
                if (in instanceof Role) {
                    return ((Role) in).getUrList().size();
                }
                return 0;
            }
        });

        Page<Role> page = commonSrv.findPage(Role.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult queryGridUser(SearchSetting search, IRequest params) {
        String code = params.get("code");
        if (CapString.isEmpty(code)) {
            return new MapGridResult();
        }

        Page<Map<String, Object>> page = roleSetService.findPageUser(search, code);
        return new MapGridResult(page.getContent(), page.getTotalRow(), null);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult queryGridFunc(SearchSetting search, IRequest params) {
        String code = params.get("code");
        if (CapString.isEmpty(code)) {
            return new MapGridResult();
        }

        Page<Map<String, Object>> page = roleSetService.findPageFunc(search, code);
        return new MapGridResult(page.getContent(), page.getTotalRow(), null);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult queryEditUsr(SearchSetting search, IRequest params) throws CapException {
        String depCode = params.get("depCode");
        String roleCode = params.get("roleCode");

        Page<Map<String, Object>> page = roleSetService.findPageEditUsr(search, roleCode, depCode);
        return new MapGridResult(page.getContent(), page.getTotalRow(), null);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult queryEditFunc(SearchSetting search, IRequest params) throws CapException {
        String parent = params.get("parent");
        String code = params.get("code");
        String sysType = params.get("sysType");

        Page<Map<String, Object>> page = roleSetService.findPageEditFunc(search, code, sysType, parent);
        return new MapGridResult(page.getContent(), page.getTotalRow(), null);
    }

    public IResult queryForm(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String code = request.get("code");
        Role role = null;

        if (!CapString.isEmpty(code)) {
            role = roleSetService.findRoleByCode(code);
        }

        if (role != null) {
            result.putAll(new AjaxFormResult(role.toJSONObject(CapEntityUtil.getColumnName(role), null)));
        }

        return result;
    }

    public IResult getAllDepartment(IRequest request) throws CapException {
        AjaxFormResult result = new AjaxFormResult();
        result.set("All", CapAppContext.getMessage("All"));
        result.putAll(roleSetService.findAllDepartment());

        return result;
    }

    public IResult getAllFunc(IRequest request) throws CapException {
        AjaxFormResult result = new AjaxFormResult();
        String sysType = request.get("sysType");
        if (CapString.isEmpty(sysType)) {
            return result;
        }

        result.set("All", CapAppContext.getMessage("All"));
        result.putAll(roleSetService.findAllFunc(sysType));

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
        String isNew = request.get("isNew");
        Role role = null;

        if (!CapString.isEmpty(code)) {
            role = roleSetService.findRoleByCode(code);
            if (isNew.equals("true") && role != null) {
                throw new CapMessageException(CapAppContext.getMessage("js.data.exists"), RoleSetHandler.class);
            }
        } else {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RoleSetHandler.class);
        }
        if (role == null) {
            role = new Role();
        }
        CapBeanUtil.map2Bean(request, role, Role.class);
        role.setUpdater(CapSecurityContext.getUserId());
        role.setUpdateTime(CapDate.getCurrentTimestamp());

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
    public IResult saveUrList(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String code = request.get("code");
        JSONArray users = JSONArray.fromObject(request.get("users"));
        Role role = null;

        if (!CapString.isEmpty(code)) {
            role = roleSetService.findRoleByCode(code);
        }
        if (role == null) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RoleSetHandler.class);
        }

        List<UserRole> list = new ArrayList<UserRole>();
        if (users != null) {
            for (Object item : users) {
                JSONObject user = (JSONObject) item;
                UserRole userRole = new UserRole();
                userRole.setUserCode(user.getString("code"));
                userRole.setRoleCode(role.getCode());
                userRole.setUpdater(CapSecurityContext.getUserId());
                userRole.setUpdateTime(CapDate.getCurrentTimestamp());
                list.add(userRole);
            }
        }
        commonSrv.save(list);

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
    public IResult saveRfList(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String code = request.get("code");
        JSONArray funcItem = JSONArray.fromObject(request.get("funcItem"));
        Role role = null;

        if (!CapString.isEmpty(code)) {
            role = roleSetService.findRoleByCode(code);
        }
        if (role == null) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RoleSetHandler.class);
        }

        List<RoleFunction> list = new ArrayList<RoleFunction>();
        if (funcItem != null) {
            for (Object item : funcItem) {
                JSONObject func = (JSONObject) item;
                RoleFunction roleFunc = new RoleFunction();
                roleFunc.setRoleCode(role.getCode());
                roleFunc.setFuncCode(func.getString("code"));
                roleFunc.setUpdater(CapSecurityContext.getUserId());
                roleFunc.setUpdateTime(CapDate.getCurrentTimestamp());
                list.add(roleFunc);
            }
        }
        commonSrv.save(list);

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
        String code = request.get("code");
        Role role = roleSetService.findRoleByCode(code);
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
    public IResult deleteUrList(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String code = request.get("code");
        JSONArray users = JSONArray.fromObject(request.get("users"));

        if (CapString.isEmpty(code)) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RoleSetHandler.class);
        }

        List<String> delUsr = new ArrayList<String>();
        if (users != null) {
            for (Object item : users) {
                JSONObject usr = (JSONObject) item;
                delUsr.add(usr.getString("code"));
            }
        }
        roleSetService.deleteUrList(code, delUsr);

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
    public IResult deleteRfList(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String code = request.get("code");
        JSONArray funcItem = JSONArray.fromObject(request.get("funcItem"));

        if (CapString.isEmpty(code)) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RoleSetHandler.class);
        }

        List<String> delFunc = new ArrayList<String>();
        if (funcItem != null) {
            for (Object item : funcItem) {
                JSONObject usr = (JSONObject) item;
                delFunc.add(usr.getString("code"));
            }
        }
        roleSetService.deleteRfList(code, delFunc);

        return result;
    }

}
