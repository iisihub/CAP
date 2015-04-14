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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.formatter.CodeTypeFormatter;
import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.base.service.CodeTypeService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.ADDateTimeFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.jpa.utils.CapEntityUtil;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
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
 * @version <ul>
 *          <li>2014/2/1,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("remindhandler")
public class RemindHandler extends MFormHandler {

    @Resource
    private ICommonService commonSrv;

    @Autowired
    private CodeTypeService codeTypeService;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult query(ISearch search, IRequest params) {
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();

        Page<Remind> page = commonSrv.findPage(Remind.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryDetail(ISearch search, IRequest params) {

        String pid = params.get("oid");
        if (CapString.isEmpty(pid)) {
            return null;
        }
        search.addSearchModeParameters(SearchMode.EQUALS, "pid", pid);

        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("styleTyp", new CodeTypeFormatter(codeTypeService, "styleTyp"));
        fmt.put("unit", new CodeTypeFormatter(codeTypeService, "unitMins"));

        Page<Reminds> page = commonSrv.findPage(Reminds.class, search);
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    public IResult queryForm(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String oid = request.get("oid");
        Remind remind = null;

        if (!CapString.isEmpty(oid)) {
            remind = commonSrv.findById(Remind.class, oid);
        }

        if (remind != null) {
            Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
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
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult save(IRequest request) {
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
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult saveDetail(IRequest request) {
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
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult delete(IRequest request) {
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
     * @return {@link tw.com.iisi.cap.response.IResult}
     * @throws CapException
     */
    public IResult deleteDetail(IRequest request) {
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
