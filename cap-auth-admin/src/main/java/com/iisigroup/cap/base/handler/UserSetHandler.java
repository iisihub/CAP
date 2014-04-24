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
package com.iisigroup.cap.base.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.formatter.CodeTypeFormatter;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.model.Role;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.base.service.RoleSetService;
import com.iisigroup.cap.base.service.UserSetService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
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
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapWebUtil;

/**
 * <pre>
 * system users handler
 * </pre>
 * 
 * @since 2014/02/13
 * @author yunglinliu
 * @version <ul>
 *          <li>2014/02/13,yunglinliu,new
 *          </ul>
 */
@Scope("request")
@Controller("usershandler")
public class UserSetHandler extends MFormHandler {

    @Resource
    private UserSetService userService;
    @Resource
    private RoleSetService roleSetService;
    @Resource
    private CodeTypeService codeTypeService;
    @Resource
    private ICommonService commonService;

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult query(ISearch search, IRequest params) {
        logger.debug("UsersHandler : " + this.getClass().hashCode());
        String userId = params.get("userId");
        String userName = params.get("userName");
        String[] roleOids = params.getParamsAsStringArray("roleOids");
        String[] status = params.getParamsAsStringArray("status");
        Page<Map<String, Object>> page = userService.findUser(userId, userName,
                roleOids, status, search.getMaxResults(),
                search.getFirstResult());
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("createTime", new ADDateFormatter());
        fmt.put("updateTime", new ADDateFormatter());
        fmt.put("status", new CodeTypeFormatter(codeTypeService, "userStatus",
                (Locale) SimpleContextHolder.get(CapWebUtil.localeKey)));
        return new MapGridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    @SuppressWarnings("rawtypes")
    @HandlerType(HandlerTypeEnum.GRID)
    public IGridResult findRole(ISearch search, IRequest params) {
        logger.debug("UsersHandler : " + this.getClass().hashCode());
        String type = params.get("type");
        if ("modify".equalsIgnoreCase(type)) {
            List<Map<String, Object>> roleList = null;
            String userOid = params.get("userOid");
            roleList = roleSetService.findAllRoleWithSelectedByUserOid(userOid);
            MapGridResult gridResult = new MapGridResult();
            if (!CollectionUtils.isEmpty(roleList)) {
                gridResult.setRowData(roleList);
            }
            return gridResult;
        } else {
            search.addOrderBy("roleId", false);
            Page<Role> page = commonService.findPage(Role.class, search);
            return new GridResult(page.getContent(), page.getTotalRow(), null);
        }
    }

    public IResult add(IRequest request) {
        String userId = request.get("userId");
        User user = userService.findUserByUserId(userId);
        if (user != null) {
            throw new CapMessageException(CapAppContext.getMessage(
                    "users.exist", new Object[] { userId }), getClass());
        }
        String userName = request.get("userName");
        String password = request.get("password");
        String confirm = request.get("confirm");
        checkPasswordRule(null, password, confirm);
        String email = request.get("email");
        String[] roleOids = request.getParamsAsStringArray("roleOids");
        userService.createUser(userId, userName, password, email, roleOids);
        return new AjaxFormResult();
    }

    public IResult modify(IRequest request) {
        String oid = request.get("oid");
        String userId = request.get("userId");
        String password = request.get("password");
        String confirm = request.get("confirm");
        boolean reset = !StringUtils.isBlank(password);
        if (reset) {
            // 代表要修改密碼
            checkPasswordRule(userId, password, confirm);
        }
        User user = userService.findUserByUserId(userId);
        if (user != null && !user.getOid().equals(oid)) {
            throw new CapMessageException(CapAppContext.getMessage(
                    "users.exist", new Object[] { userId }), getClass());
        }
        String userName = request.get("userName");
        String email = request.get("email");
        String[] roleOids = request.getParamsAsStringArray("roleOids");
        userService.updateUserByOid(oid, userId, userName, reset, password,
                email, roleOids);
        return new AjaxFormResult();
    }

    public IResult delete(IRequest request) {
        String[] oids = request.getParamsAsStringArray("oids");
        for (String oid : oids) {
            // userService.deleteUserRoleByUserOid(oid);
            userService.deleteUserByOid(oid);
        }
        return new AjaxFormResult();
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryAllRole(ISearch search, IRequest params) {
        search.addOrderBy("roleId", false);
        Page<Role> page = commonService.findPage(Role.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), null);
    }// ;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryAllUserStatus(ISearch search, IRequest params) {
        search.addOrderBy("codeValue", false);
        search.addSearchModeParameters(SearchMode.EQUALS, "codeType",
                "userStatus");
        search.addSearchModeParameters(SearchMode.EQUALS, "locale",
                ((Locale) SimpleContextHolder.get(CapWebUtil.localeKey))
                        .toString());
        Page<CodeType> page = commonService.findPage(CodeType.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), null);
    }// ;

    public IResult lock(IRequest request) {
        String[] oids = request.getParamsAsStringArray("oids");
        for (String oid : oids) {
            userService.lockUserByOid(oid);
        }
        return new AjaxFormResult();
    }

    public IResult unlock(IRequest request) {
        String[] oids = request.getParamsAsStringArray("oids");
        for (String oid : oids) {
            userService.unlockUserByOid(oid);
        }
        return new AjaxFormResult();
    }

    private void checkPasswordRule(String userId, String password,
            String confirm) {
        SysParm parmPwdRule = commonService.findById(SysParm.class, "pwd_rule");
        SysParm parmPwdMinLen = commonService.findById(SysParm.class,
                "pwd_min_length");
        SysParm parmPwdMaxHistory = commonService.findById(SysParm.class,
                "pwd_max_history");
        int minLen = Integer.parseInt(parmPwdMinLen.getParmValue());
        int maxHistory = Integer.parseInt(parmPwdMaxHistory.getParmValue());
        String ruleType = parmPwdRule.getParmValue();
        CodeType rule = codeTypeService.getByCodeTypeAndValue("pwdrule",
                ruleType);
        if (!userService.checkPasswordRule(userId, password, confirm,
                ruleType, minLen, maxHistory)) {
            throw new CapMessageException(CapAppContext.getMessage(
                    "error.008", new Object[] { rule.getCodeDesc() }),
                    getClass());
        }
    }

    public IResult changePassword(IRequest request) {
        String password = request.get("password");
        String newPwd = request.get("newPwd");
        String confirm = request.get("confirm");
        if (userService.validatePassword(password)) {
            String userId = CapSecurityContext.getUserId();
            checkPasswordRule(userId, newPwd, confirm);
            userService.changeUserPassword(newPwd);
        } else {
            throw new CapMessageException(
                    CapAppContext.getMessage("error.009"), getClass());
        }
        return new AjaxFormResult();
    }

}
