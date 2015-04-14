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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.IBeanFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;
import com.iisigroup.cap.rule.service.FactorMntService;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * Factor Maintain Handler
 * </pre>
 * 
 * @since 2013/12/12
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/12,TimChiang,new
 *          </ul>
 */
@Scope("request")
@Controller("factorMntGridhandler")
public class FactorMntGridHandler extends MFormHandler {

    @Resource
    private FactorMntService factorMntService;

    @Resource
    private ICommonService commonService;

    private static final Logger logger = LoggerFactory.getLogger(FactorMntGridHandler.class);

    /**
     * 查詢Factor Item Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryFactorItmGridByFactorNo(ISearch search, IRequest params) {
        // if (params.containsKey("factorNo") &&
        // !CapString.isEmpty(params.get("factorNo"))) {
        // search.addSearchModeParameters(SearchMode.EQUALS, "factorNo",
        // params.get("factorNo"));
        // }
        // search.addSearchModeParameters(SearchMode.EQUALS,
        // "divFtDtls.factorNo", ?);

        Page<DivFtItm> page = commonService.findPage(DivFtItm.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        // fmt.put("updateTime", new ADDateFormatter());
        fmt.put("rangeNm", new RangeNmFormatter());
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    /**
     * 查詢Factor Detail Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryFactorDtlGridByFactorNo(ISearch search, IRequest params) {
        if (params.containsKey("factorNo") && !CapString.isEmpty(params.get("factorNo"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", params.get("factorNo"));
        } else {
            return new GridResult();
        }

        Page<DivFtDtl> page = commonService.findPage(DivFtDtl.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("updateTime", new ADDateFormatter());
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    /**
     * RangeNmFormatter formatter
     */
    class RangeNmFormatter implements IBeanFormatter {
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
