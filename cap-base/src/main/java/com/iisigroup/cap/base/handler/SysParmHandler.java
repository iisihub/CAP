/* 
 * SysParmHandler.java
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

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;

/**
 * <pre>
 * 系統參數處理
 * </pre>
 * 
 * @since 2012/10/25
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/10/25,iristu,new
 *          </ul>
 */
@Controller("sysparmhandler")
public class SysParmHandler extends MFormHandler {

    @Resource
    private CommonService commonService;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult query(SearchSetting search, IRequest params) {

        if (params.containsKey("parmId")) {
            search.addSearchModeParameters(SearchMode.EQUALS, "parmId", params.get("parmId"));
        }
        if (!search.hasOrderBy()) {
            search.addOrderBy("parmId");
        }
        Page<SysParm> page = commonService.findPage(SysParm.class, search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("updateTime", new ADDateFormatter());
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * modify SysParm
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult modify(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        SysParm parm = commonService.findById(SysParm.class, request.get("parmId"));
        if (parm == null) {
            parm = new SysParm();
        }
        CapBeanUtil.map2Bean(request, parm, SysParm.class);
        parm.setUpdateTime(CapDate.getCurrentTimestamp());
        commonService.save(parm);
        return result;
    }

    /**
     * delete SysParm
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult delete(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        SysParm parm = commonService.findById(SysParm.class, request.get("parmId"));
        if (parm != null) {
            commonService.delete(parm);
        }
        return result;
    }

}
