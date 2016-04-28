/* 
 * BranchHandler.java
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
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.auth.model.Department;
import com.iisigroup.cap.auth.service.DepartmentService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 分行維護
 * </pre>
 * 
 * @since 2014/1/13
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/13,tammy,new
 *          </ul>
 */
@Controller("departmenthandler")
public class DepartmentHandler extends MFormHandler {

    @Resource
    private CommonService commonSrv;

    @Resource
    private DepartmentService departmentService;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult query(SearchSetting search, IRequest params) {
        search.addOrderBy("code");

        Map<String, Formatter> fmt = new HashMap<String, Formatter>();

        Page<Department> page = commonSrv.findPage(Department.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
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
        String oid = request.get("oid");
        String brNo = request.get("code");
        Department branch = null;

        if (CapString.isEmpty(oid)) {
            branch = departmentService.findByBrno(brNo);
            if (branch != null) {
                result.set("exist", Boolean.TRUE);
                return result;
            }
        } else {
            branch = commonSrv.findById(Department.class, oid);
        }

        if (branch == null) {
            branch = new Department();
            branch.setOid(null);
        }
        CapBeanUtil.map2Bean(request, branch, Department.class);
        branch.setUpdater(CapSecurityContext.getUserId());
        branch.setUpdateTime(CapDate.getCurrentTimestamp());
        departmentService.save(branch);

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
        Department code = commonSrv.findById(Department.class, request.get("oid"));
        if (code != null) {
            commonSrv.delete(code);
        }
        return result;
    }

}
