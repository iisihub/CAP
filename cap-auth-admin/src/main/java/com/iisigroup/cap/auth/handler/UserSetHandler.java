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
import com.iisigroup.cap.auth.model.DefaultRole;
import com.iisigroup.cap.auth.model.DefaultUser;
import com.iisigroup.cap.auth.service.RoleSetService;
import com.iisigroup.cap.auth.service.UserSetService;
import com.iisigroup.cap.base.formatter.impl.CodeTypeFormatter;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.GridResult;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.component.impl.BeanGridResult;
import com.iisigroup.cap.component.impl.MapGridResult;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.db.service.CommonService;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.formatter.impl.ADDateFormatter;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.service.PasswordService;
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
    private PasswordService passwordService;
    @Resource
    private RoleSetService roleSetService;
    @Resource
    private CodeTypeService codeTypeService;
    @Resource
    private CommonService commonService;

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult query(SearchSetting search, Request params) {
        String code = params.get("code");
        String name = params.get("name");
        String[] roleCodes = params.getParamsAsStringArray("roleCodes");
        String[] status = params.getParamsAsStringArray("status");
        Page<Map<String, Object>> page = userService.findUser(code, name, roleCodes, status, search.getMaxResults(), search.getFirstResult());
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("createTime", new ADDateFormatter());
        fmt.put("updateTime", new ADDateFormatter());
        fmt.put("pwdExpiredTime", new ADDateFormatter());
        fmt.put("status", new CodeTypeFormatter(codeTypeService, "userStatus", (Locale) SimpleContextHolder.get(CapWebUtil.localeKey)));
        return new MapGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    @SuppressWarnings("rawtypes")
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult findRole(SearchSetting search, Request params) {
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
            Page<DefaultRole> page = commonService.findPage(DefaultRole.class, search);
            return new BeanGridResult(page.getContent(), page.getTotalRow(), null);
        }
    }

    public Result add(Request request) {
        String code = request.get("code");
        DefaultUser user = userService.findUserByUserCode(code);
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

    public Result modify(Request request) {
        String oid = request.get("oid");
        String code = request.get("code");
        String password = request.get("password");
        String confirm = request.get("confirm");
        boolean reset = !StringUtils.isBlank(password);
        if (reset) {
            // 代表要修改密碼
            passwordService.checkPasswordRule(code, password, confirm, true);
        }
        DefaultUser user = userService.findUserByUserCode(code);
        if (user != null && !user.getOid().equals(oid)) {
            throw new CapMessageException(CapAppContext.getMessage("users.exist", new Object[] { code }), getClass());
        }
        String name = request.get("name");
        String email = request.get("email");
        String[] roleCodes = request.getParamsAsStringArray("roleCodes");
        userService.updateUserByOid(oid, code, name, reset, password, email, roleCodes);
        return new AjaxFormResult();
    }

    public Result delete(Request request) {
        String[] oids = request.getParamsAsStringArray("oids");
        userService.deleteUserByOids(oids);
        return new AjaxFormResult();
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult queryAllRole(SearchSetting search, Request params) {
        search.addOrderBy("code", false);
        Page<DefaultRole> page = commonService.findPage(DefaultRole.class, search);
        return new BeanGridResult(page.getContent(), page.getTotalRow(), null);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult queryAllUserStatus(SearchSetting search, Request params) {
        search.addOrderBy("codeValue", false);
        search.addSearchModeParameters(SearchMode.EQUALS, "codeType", "userStatus");
        search.addSearchModeParameters(SearchMode.EQUALS, "locale", ((Locale) SimpleContextHolder.get(CapWebUtil.localeKey)).toString());
        Page<CodeType> page = commonService.findPage(CodeType.class, search);
        return new BeanGridResult(page.getContent(), page.getTotalRow(), null);
    }

    public Result lock(Request request) {
        String[] oids = request.getParamsAsStringArray("oids");
        userService.lockUserByOids(oids);
        return new AjaxFormResult();
    }

    public Result unlock(Request request) {
        String[] oids = request.getParamsAsStringArray("oids");
        userService.unlockUserByOids(oids);
        return new AjaxFormResult();
    }

    public Result changePassword(Request request) {
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
