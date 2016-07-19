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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.impl.BeanGridResult;
import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.db.service.CommonService;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.formatter.BeanFormatter;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.formatter.impl.ADDateFormatter;
import com.iisigroup.cap.mvc.handler.MFormHandler;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;
import com.iisigroup.cap.rule.service.FactorMntService;
import com.iisigroup.cap.utils.CapString;

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
@Controller("factorMntGridhandler")
public class FactorMntGridHandler extends MFormHandler {

    @Resource
    private FactorMntService factorMntService;

    @Resource
    private CommonService commonService;

    private final Logger logger = LoggerFactory.getLogger(FactorMntGridHandler.class);

    /**
     * 查詢Factor Item Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult queryFactorItmGridByFactorNo(SearchSetting search, Request params) {
        // if (params.containsKey("factorNo") && !CapString.isEmpty(params.get("factorNo"))) {
        // search.addSearchModeParameters(SearchMode.EQUALS, "factorNo",
        // params.get("factorNo"));
        // }
        // search.addSearchModeParameters(SearchMode.EQUALS,
        // "divFtDtls.factorNo", ?);

        Page<DivFtItm> page = commonService.findPage(DivFtItm.class, search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        // fmt.put("updateTime", new ADDateFormatter());
        fmt.put("rangeNm", new RangeNmFormatter());
        return new BeanGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * 查詢Factor Detail Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public BeanGridResult queryFactorDtlGridByFactorNo(SearchSetting search, Request params) {
        if (params.containsKey("factorNo") && !CapString.isEmpty(params.get("factorNo"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", params.get("factorNo"));
        } else {
            return new BeanGridResult();
        }

        Page<DivFtDtl> page = commonService.findPage(DivFtDtl.class, search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("updateTime", new ADDateFormatter());
        return new BeanGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * RangeNmFormatter formatter
     */
    class RangeNmFormatter implements BeanFormatter {
        private static final long serialVersionUID = 1L;

        /*
         * (non-Javadoc)
         * 
         * @see tw.com.iisi.cap.formatter.IFormatter#reformat(java.lang.Object)
         */
        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer rangeNm = new StringBuffer();
            if (in instanceof DivFtItm) {
                DivFtItm ftItm = ((DivFtItm) in);
                if (ftItm.getDivFtDtls() != null && !ftItm.getDivFtDtls().isEmpty()) {
                    for (DivFtDtl ftDtl : ((DivFtItm) in).getDivFtDtls()) {
                        rangeNm.append(ftDtl.getRangeNm() + ",");
                    }
                    rangeNm.deleteCharAt(rangeNm.lastIndexOf(","));
                }
            }
            return rangeNm.toString();
        }
    }
}
