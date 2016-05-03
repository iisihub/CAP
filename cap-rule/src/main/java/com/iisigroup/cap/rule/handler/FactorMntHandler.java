/* 
 * SampleHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.rule.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.handler.MFormHandler;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.constants.Constants;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;
import com.iisigroup.cap.rule.service.FactorMntService;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

import net.sf.json.JSONObject;

/**
 * <pre>
 * Factor Maintain Handler
 * </pre>
 * 
 * @since 2013/12/12
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/12,TimChiang,new
 *          </ul>
 */
@Controller("factorMnthandler")
public class FactorMntHandler extends MFormHandler {

    @Resource
    private FactorMntService factorMntService;

    @Resource
    private CommonService commonService;

    private final Logger logger = LoggerFactory.getLogger(FactorMntHandler.class);

    /**
     * 查詢Factor資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.FORM)
    public Result query(Request request) {
        String oid = request.get("mainOid");
        String factorNo = request.get("factorNo");
        AjaxFormResult result = new AjaxFormResult();
        DivFtItm ftItm = null;
        if (!CapString.isEmpty(oid)) {
            ftItm = factorMntService.getById(oid);
        } else if (!CapString.isEmpty(factorNo)) {
            ftItm = factorMntService.findByDivFtItmNo(factorNo);
        }
        if (ftItm != null) {
            result.putAll(ftItm.toJSONObject(new String[] { "factorNo", "factorNm", "dataType", "oid", "tableNm", "columnNm" }, null));
        }
        return result;
    }

    /**
     * modify Factor Item and Detail
     * 
     * @param request
     *            request
     * @return IResult
     */
    public Result saveFactorDtl(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        String type = request.get("type");
        String divFtItmNo = request.get("factorNo");
        String[] sary = request.getParamsAsStringArray("grid[]");
        DivFtItm ftItm = factorMntService.findByDivFtItmNo(divFtItmNo);

        if ("A".equals(type)) {
            if (ftItm != null) {
                // factorMnt.0001 代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("factorMntPage.0001"), getClass());
            }
            ftItm = new DivFtItm();
        } else {
            if (ftItm != null && !ftItm.getOid().equals(request.get("oid"))) {
                // factorMnt.0001 代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("factorMntPage.0001"), getClass());
            } else if (ftItm == null && !CapString.isEmpty(request.get("oid"))) {
                ftItm = factorMntService.getById(request.get("oid"));
            } else if (ftItm == null) {
                ftItm = new DivFtItm();
            }
        }
        CapBeanUtil.map2Bean(request, ftItm);
        if ("A".equals(type)) {
            ftItm.setOid(null);
        }
        List<DivFtDtl> delFtDtl = new ArrayList<DivFtDtl>();
        if (ftItm.getDivFtDtls() != null && !ftItm.getDivFtDtls().isEmpty()) {
            delFtDtl = ftItm.getDivFtDtls();
        }
        if (sary != null) {
            List<DivFtDtl> ftDtls = new ArrayList<DivFtDtl>();
            for (int i = 0; i < sary.length; i++) {
                JSONObject gridData = JSONObject.fromObject(sary[i]);
                DivFtDtl ftDtl = new DivFtDtl();
                CapBeanUtil.map2Bean(gridData, ftDtl);
                ftDtl.setFactorNo(ftItm.getFactorNo());
                if (!CapString.isEmpty(gridData.optString("rangeNo"))) {
                    ftDtl.setRangeNo(gridData.optString("rangeNo"));
                } else {
                    ftDtl.setRangeNo(CapString.fillString(String.valueOf(i), 5, true, '0'));
                }
                if (!CapString.isEmpty(gridData.optString("oid"))) {
                    ftDtl.setOid(gridData.optString("oid"));
                }
                ftDtl.setRangeSor(new BigDecimal(i));
                ftDtl.setDivFtItm(ftItm);
                ftDtls.add(ftDtl);
            }
            ftItm.setDivFtDtls(ftDtls);
        }
        String userId = CapSecurityContext.getUserId();
        if (userId.length() > 6)
            userId = userId.substring(0, 6);
        ftItm.setUpdater(userId);
        ftItm.setUpdateTime(CapDate.getCurrentTimestamp());
        factorMntService.saveDivFtItm(ftItm);
        if (!delFtDtl.isEmpty())
            factorMntService.deleteFtDtlByList(delFtDtl);
        result.set(Constants.AJAX_NOTIFY_MESSAGE, CapAppContext.getMessage("factorMntPage.0002"));
        return result;
    }

    /**
     * delete Division Factor Item and Detail
     * 
     * @param request
     *            request
     * @return IResult
     */
    public Result delete(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        factorMntService.deleteById(request.get("oid"));
        result.set(Constants.AJAX_NOTIFY_MESSAGE, CapAppContext.getMessage("factorMntPage.0003"));
        return result;
    }

    public Result insertTestCases(Request request) {
        AjaxFormResult result = new AjaxFormResult();
        factorMntService.insertTestCaseInfoData();
        return result;
    }

}
