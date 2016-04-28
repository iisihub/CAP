/* 
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

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.auth.model.Role;
import com.iisigroup.cap.auth.model.User;
import com.iisigroup.cap.auth.service.RoleSetService;
import com.iisigroup.cap.auth.service.UserSetService;
import com.iisigroup.cap.base.formatter.CodeTypeFormatter;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IGridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.response.MapGridResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.service.IPasswordService;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapWebUtil;

/**
 * <pre>
 * system users handler
 * </pre>
 * 
 * @since 2014/02/13
 * @author yunglinliu
 * @version
 *          <ul>
 *          <li>2014/02/13,yunglinliu,new
 *          </ul>
 */
@Controller("usersethandler")
public class UserSetHandler extends MFormHandler {

    @Resource
    private UserSetService userService;
    @Resource
    private IPasswordService passwordService;
    @Resource
    private RoleSetService roleSetService;
    @Resource
    private CodeTypeService codeTypeService;
    @Resource
    private CommonService commonService;

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult query(SearchSetting search, IRequest params) {
        String code = params.get("code");
        String name = params.get("name");
        String[] roleCodes = params.getParamsAsStringArray("roleCodes");
        String[] status = params.getParamsAsStringArray("status");
        Page<Map<String, Object>> page = userService.findUser(code, name, roleCodes, status, search.getMaxResults(), search.getFirstResult());
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("createTime", new ADDateFormatter());
        fmt.put("updateTime", new ADDateFormatter());
        fmt.put("pwdExpiredTime", new ADDateFormatter());
        fmt.put("status", new CodeTypeFormatter(codeTypeService, "userStatus", (Locale) SimpleContextHolder.get(CapWebUtil.localeKey)));
        return new MapGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    @SuppressWarnings("rawtypes")
    @HandlerType(HandlerTypeEnum.GRID)
    public IGridResult findRole(SearchSetting search, IRequest params) {
        String type = params.get("type");
        if ("modify".equalsIgnoreCase(type)) {
            List<Map<String, Object>> roleList = null;
            String userCode = params.get("userCode");
            roleList = roleSetService.findAllRoleWithSelectedByUserCode(userCode);
            MapGridResult gridResult = new MapGridResult();
            if (!CollectionUtils.isEmpty(roleList)) {
                gridResult.setRowData(roleList);
            }
            return gridResult;
        } else {
            search.addOrderBy("code", false);
            Page<Role> page = commonService.findPage(Role.class, search);
            return new GridResult(page.getContent(), page.getTotalRow(), null);
        }
    }

    public IResult add(IRequest request) {
        String code = request.get("code");
        User user = userService.findUserByUserCode(code);
        if (user != null) {
            throw new CapMessageException(CapAppContext.getMessage("users.exist", new Object[] { code }), getClass());
        }
        String name = request.get("name");
        String password = request.get("password");
        String confirm = request.get("confirm");
        passwordService.checkPasswordRule(code, password, confirm, true);
        String email = request.get("email");
        String[] roleCodes = request.getParamsAsStringArray("roleCodes");
        userService.createUser(code, name, password, email, roleCodes);
        return new AjaxFormResult();
    }

    public IResult modify(IRequest request) {
        String oid = request.get("oid");
        String code = request.get("code");
        String password = request.get("password");
        String confirm = request.get("confirm");
        boolean reset = !StringUtils.isBlank(password);
        if (reset) {
            // 代表要修改密碼
            passwordService.checkPasswordRule(code, password, confirm, true);
        }
        User user = userService.findUserByUserCode(code);
        if (user != null && !user.getOid().equals(oid)) {
            throw new CapMessageException(CapAppContext.getMessage("users.exist", new Object[] { code }), getClass());
        }
        String name = request.get("name");
        String email = request.get("email");
        String[] roleCodes = request.getParamsAsStringArray("roleCodes");
        userService.updateUserByOid(oid, code, name, reset, password, email, roleCodes);
        return new AjaxFormResult();
    }

    public IResult delete(IRequest request) {
        String[] oids = request.getParamsAsStringArray("oids");
        userService.deleteUserByOids(oids);
        return new AjaxFormResult();
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryAllRole(SearchSetting search, IRequest params) {
        search.addOrderBy("code", false);
        Page<Role> page = commonService.findPage(Role.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), null);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryAllUserStatus(SearchSetting search, IRequest params) {
        search.addOrderBy("codeValue", false);
        search.addSearchModeParameters(SearchMode.EQUALS, "codeType", "userStatus");
        search.addSearchModeParameters(SearchMode.EQUALS, "locale", ((Locale) SimpleContextHolder.get(CapWebUtil.localeKey)).toString());
        Page<CodeType> page = commonService.findPage(CodeType.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), null);
    }

    public IResult lock(IRequest request) {
        String[] oids = request.getParamsAsStringArray("oids");
        userService.lockUserByOids(oids);
        return new AjaxFormResult();
    }

    public IResult unlock(IRequest request) {
        String[] oids = request.getParamsAsStringArray("oids");
        userService.unlockUserByOids(oids);
        return new AjaxFormResult();
    }

    public IResult changePassword(IRequest request) {
        String password = request.get("password");
        String newPwd = request.get("newPwd");
        String confirm = request.get("confirm");
        String userId = CapSecurityContext.getUserId();
        if (passwordService.validatePassword(userId, password)) {
            passwordService.checkPasswordRule(userId, newPwd, confirm, false);
            passwordService.changeUserPassword(userId, newPwd);
        } else {
            throw new CapMessageException(CapAppContext.getMessage("error.009"), getClass());
        }
        return new AjaxFormResult();
    }

}
