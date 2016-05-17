/* 
 * RemindHandler.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.formatter.impl.CodeTypeFormatter;
import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.component.impl.BeanGridResult;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.db.service.CommonService;
import com.iisigroup.cap.db.utils.CapEntityUtil;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.formatter.impl.ADDateFormatter;
import com.iisigroup.cap.formatter.impl.ADDateTimeFormatter;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapMath;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapWebUtil;

/**
 * <pre>
 * 提醒通知
 * </pre>
 * 
 * @since 2014/2/1
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/2/1,tammy,new
 *          </ul>
 */
@Controller("remindhandler")
public class RemindHandler extends MFormHandler {

    @Resource
    private CommonService commonSrv;

    @Autowired
    private CodeTypeService codeTypeService;

    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult query(SearchSetting search, Request params) {
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();

        Page<Remind> page = commonSrv.findPage(Remind.class, search);
        return new BeanGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult queryDetail(SearchSetting search, Request params) {

        String pid = params.get("oid");
        if (CapString.isEmpty(pid)) {
            return null;
        }
        search.addSearchModeParameters(SearchMode.EQUALS, "pid", pid);

        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("styleTyp", new CodeTypeFormatter(codeTypeService, "styleTyp"));
        fmt.put("unit", new CodeTypeFormatter(codeTypeService, "unitMins"));

        Page<Reminds> page = commonSrv.findPage(Reminds.class, search);
        return new BeanGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    public Result queryForm(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String oid = request.get("oid");
        Remind remind = null;

        if (!CapString.isEmpty(oid)) {
            remind = commonSrv.findById(Remind.class, oid);
        }

        if (remind != null) {
            Map<String, Formatter> fmt = new HashMap<String, Formatter>();
            fmt.put("startDate", new ADDateFormatter());
            fmt.put("endDate", new ADDateFormatter());

            result.set("startTime", new ADDateTimeFormatter("HH:mm").reformat(remind.getStartDate()));
            result.set("endTime", new ADDateTimeFormatter("HH:mm").reformat(remind.getEndDate()));
            result.putAll(new AjaxFormResult(remind.toJSONObject(CapEntityUtil.getColumnName(remind), fmt)));
        }

        return result;
    }

    /**
     * 編輯資料
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.Result}
     * @throws CapException
     */
    public Result save(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String oid = request.get("oid");
        Remind remind = null;

        if (!CapString.isEmpty(oid)) {
            remind = commonSrv.findById(Remind.class, oid);
        }
        if (remind == null) {
            remind = new Remind();
            remind.setCrTime(CapDate.getCurrentTimestamp());
        }
        String startDate = request.get("startDate");
        String startTime = request.get("startTime");
        if (CapString.isEmpty(startTime)) {
            startTime = "00:00:00";
        } else {
            startTime = startTime + ":00";
        }
        request.put("startDate", startDate + " " + startTime);
        String endDate = request.get("endDate");
        String endTime = request.get("endTime");
        if (CapString.isEmpty(endTime)) {
            endTime = "00:00:00";
        } else {
            endTime = endTime + ":00";
        }
        request.put("endDate", endDate + " " + endTime);

        CapBeanUtil.map2Bean(request, remind, Remind.class);
        remind.setUpdater(CapSecurityContext.getUserId());
        remind.setUpdTime(CapDate.getCurrentTimestamp());
        remind.setLocale(SimpleContextHolder.get(CapWebUtil.localeKey).toString());

        commonSrv.save(remind);

        result.putAll(new AjaxFormResult(remind.toJSONObject(CapEntityUtil.getColumnName(remind), null)));
        return result;
    }

    /**
     * 新增通知方式
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.Result}
     * @throws CapException
     */
    public Result saveDetail(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String pid = request.get("pid");
        Remind remind = null;

        if (!CapString.isEmpty(pid)) {
            remind = commonSrv.findById(Remind.class, pid);
        }
        if (remind == null) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RemindHandler.class);
        }
        Reminds reminds = new Reminds();
        reminds.setPid(pid);
        reminds.setScopePid(remind.getScopePid());
        reminds.setStyle(CapMath.getBigDecimal(request.get("style")));
        reminds.setStyleTyp(request.get("styleTyp"));
        reminds.setUnit(CapMath.getBigDecimal(request.get("unit")));
        reminds.setYnFlag("0");

        commonSrv.save(reminds);

        return result;
    }

    /**
     * 刪除資料
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.Result}
     * @throws CapException
     */
    public Result delete(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String oid = request.get("oid");
        if (CapString.isEmpty(oid)) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RemindHandler.class);
        }
        Remind remind = commonSrv.findById(Remind.class, oid);
        if (remind != null) {
            commonSrv.delete(remind);
        }
        return result;
    }

    /**
     * 刪除資料
     * 
     * @param request
     *            IRequest
     * @return {@link tw.com.iisi.cap.response.Result}
     * @throws CapException
     */
    public Result deleteDetail(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String[] oids = (String[]) request.getParamsAsStringArray("oids");
        List<Reminds> models = new ArrayList<Reminds>();

        if (oids == null) {
            throw new CapMessageException(CapAppContext.getMessage("EXCUE_ERROR"), RemindHandler.class);
        }
        for (String oid : oids) {
            Reminds reminds = commonSrv.findById(Reminds.class, oid);
            if (reminds != null) {
                models.add(reminds);
            }
        }
        commonSrv.delete(models);

        return result;
    }

}
