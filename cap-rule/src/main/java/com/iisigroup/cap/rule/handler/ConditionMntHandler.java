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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.IBeanFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.rule.model.DivCtDtl;
import com.iisigroup.cap.rule.model.DivCtItm;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;
import com.iisigroup.cap.rule.service.ConditionMntService;
import com.iisigroup.cap.rule.service.FactorMntService;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

import net.sf.json.JSONObject;

/**
 * <pre>
 * Condition Maintain Handler
 * </pre>
 * 
 * @since 2013/12/24
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/24,TimChiang,new
 *          </ul>
 */
@Scope("request")
@Controller("conditionMnthandler")
public class ConditionMntHandler extends MFormHandler {

    @Resource
    private ConditionMntService conditionMntService;
    @Resource
    private FactorMntService factorMntService;

    @Resource
    private ICommonService commonService;

    private static final Logger logger = LoggerFactory.getLogger(ConditionMntHandler.class);

    /**
     * 查詢Condition資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.FORM)
    public IResult query(IRequest request) {
        String oid = request.get("mainOid");
        String divCtNo = request.get("divCtNo");
        AjaxFormResult result = new AjaxFormResult();
        DivCtItm ctItm = null;
        if (!CapString.isEmpty(oid)) {
            ctItm = conditionMntService.getById(oid);
        } else if (!CapString.isEmpty(divCtNo)) {
            ctItm = conditionMntService.findByDivCtItmNo(divCtNo);
        }
        if (ctItm != null) {
            result.putAll(ctItm.toJSONObject(new String[] { "divCtNo", "divCtNm", "divCtTyp", "divCtSetting", "divCtAction", "oid" }, null));
            // if(ctItm.getDivCtDtls()!=null && !ctItm.getDivCtDtls().isEmpty()){
            // DivCtDtl ctDtl = ctItm.getDivCtDtls().get(0);
            // JSONObject jsObj = JSONObject.fromObject(ctDtl.getDivCtJson());
            // String rangeNoKey = jsObj.optString("gridData");
            // String[] rangeNos = rangeNoKey.split(",");
            // for(int i = 0; i<rangeNos.length; i++){
            // String[] key = rangeNos[i].split("\\|");
            // List<DivFtDtl> ftDtls =
            // factorMntService.findByFactorNoAndRangeNos(key[0], key[1]);
            //
            //// for(DivFtDtl ftDtl : ftDtls){
            //// result.append(ftDtl.getRangeNm()+",");
            //// }
            // if (params.containsKey("factorNo") && !CapString.isEmpty(params.get("factorNo"))) {
            // search.addSearchModeParameters(SearchMode.EQUALS, "factorNo",
            // params.get("factorNo"));
            // }else{
            // return new GridResult();
            // }
            //
            // Page<DivFtDtl> page = commonService.findPage(DivFtDtl.class, search);
            // Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
            //// fmt.put("updateTime", new ADDateFormatter());
            // fmt.put("rangeNm", new RangeNmFormatter());
            // fmt.put("factorNm", new FactorNmFormatter());
            // return new GridResult(page.getContent(), page.getTotalRow(), fmt);
            // }
            // }
        }

        return result;
    }// ;

    /**
     * modify Condition Item and Detail
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult saveConditionDtl(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String type = request.get("type");
        String divCtNo = request.get("divCtNo");
        // Factor DETAIL
        String[] ftGridData = request.getParamsAsStringArray("grid[]");
        DivCtItm ctItm = conditionMntService.findByDivCtItmNo(divCtNo);

        if ("A".equals(type)) {
            if (ctItm != null) {
                // conditionMnt.0001 條件代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("condition.0001"), getClass());
            }
            ctItm = new DivCtItm();
        } else {
            if (ctItm != null && !ctItm.getOid().equals(request.get("oid"))) {
                // conditionMnt.0001 條件代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("condition.0001"), getClass());
            } else if (ctItm == null && !CapString.isEmpty(request.get("oid"))) {
                ctItm = conditionMntService.getById(request.get("oid"));
            } else if (ctItm == null) {
                ctItm = new DivCtItm();
            }
        }
        CapBeanUtil.map2Bean(request, ctItm);
        if ("A".equals(type)) {
            ctItm.setOid(null);
        }
        List<DivCtDtl> delCtDtl = new ArrayList<DivCtDtl>();
        if (ftGridData != null) {
            List<DivCtDtl> ctDtls = new LinkedList<DivCtDtl>();
            if (ctItm.getDivCtDtls() != null && !ctItm.getDivCtDtls().isEmpty()) {
                delCtDtl = ctItm.getDivCtDtls();
            }
            for (int i = 0; i < ftGridData.length; i++) {
                JSONObject jsData = JSONObject.fromObject(ftGridData[i]);
                DivCtDtl ctDtl = new DivCtDtl();
                // int j = 0;
                // boolean haveOld = false;
                // if(!CapString.isEmpty(jsData.getString("oid")) && !ctItm.getDivCtDtls().isEmpty()){
                // for(DivCtDtl ctDtl2 : ctDtls){
                // j++;
                // if(ctDtl2.getOid().equals(jsData.opt("oid"))){
                // ctDtl = ctDtl2;
                // haveOld = true;
                // break;
                // }
                // }
                // }
                CapBeanUtil.map2Bean(jsData, ctDtl);
                ctDtl.setDivCtNo(ctItm.getDivCtNo());
                ctDtl.setDivCtSor(new BigDecimal(i + 1));
                ctDtl.setRangeNo(jsData.optString("rangeNo"));
                DivFtDtl ftDtl = factorMntService.findByFactorNoAndRangeNo(jsData.optString("factorNo"), jsData.optString("rangeNo"));
                ctDtl.setDivFtDtl(ftDtl);
                ctDtl.setDivCtItm(ctItm);
                // if(haveOld){
                // ctDtls.set(j, ctDtl);
                // }else{
                ctDtls.add(ctDtl);
                // }
            }

            ctItm.setDivCtDtls(ctDtls);
        }
        String userId = CapSecurityContext.getUserId();
        if (userId.length() > 6)
            userId = userId.substring(0, 6);
        ctItm.setUpdater(userId);
        ctItm.setUpdateTime(CapDate.getCurrentTimestamp());
        ctItm.setDivCtTyp("C");
        conditionMntService.saveDivCtItm(ctItm);
        if (!delCtDtl.isEmpty())
            conditionMntService.deleteCtDtlByList(delCtDtl);
        result.set(Constants.AJAX_NOTIFY_MESSAGE, CapAppContext.getMessage("condition.0002"));
        return result;
    }

    /**
     * delete Division Condition Item and Detail
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult delete(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        conditionMntService.deleteById(request.get("oid"));
        result.set(Constants.AJAX_NOTIFY_MESSAGE, CapAppContext.getMessage("condition.0003"));
        return result;
    }

    public IResult getFtSelOption(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        List<DivFtItm> ftItms = factorMntService.findAllDivFtItm();
        if (ftItms != null) {
            result.set(" ", "請選擇 -");
            for (DivFtItm ftItm : ftItms) {
                result.set(ftItm.getFactorNo(), ftItm.getFactorNm());
            }
        }
        return result;
    }

    /*********** Grid ***************************************************/
    /**
     * 查詢Condition Item Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryConditionItmByDivCtNo(ISearch search, IRequest params) {
        search.addSearchModeParameters(SearchMode.NOT_EQUALS, "divCtNo", "");

        Page<DivCtItm> page = commonService.findPage(DivCtItm.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        // fmt.put("updateTime", new ADDateFormatter());
        fmt.put("condVal", new CondValFormatter(factorMntService));
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    /**
     * 查詢Condition Detail Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryConditionDtlByDivCtNo(ISearch search, IRequest params) {
        if (params.containsKey("divCtNo") && !CapString.isEmpty(params.get("divCtNo"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", params.get("divCtNo"));
        } else {
            return new GridResult();
        }

        Page<DivCtDtl> page = commonService.findPage(DivCtDtl.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("updateTime", new ADDateFormatter());
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
    public GridResult queryFactorDetailByFactorNo(ISearch search, IRequest params) {
        if (params.containsKey("factorNo") && !CapString.isEmpty(params.get("factorNo"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "factorNo", params.get("factorNo"));
        } else {
            return new GridResult();
        }

        Page<DivFtDtl> page = commonService.findPage(DivFtDtl.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        // fmt.put("updateTime", new ADDateFormatter());
        fmt.put("rangeNm", new RangeNmFormatter());
        fmt.put("factorNm", new FactorNmFormatter());
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
    public GridResult queryConditionDtlGridByDivCtNo(ISearch search, IRequest params) {
        if (params.containsKey("divCtNo") && !CapString.isEmpty(params.get("divCtNo"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", params.get("divCtNo"));
        } else {
            return new GridResult();
        }
        Page<DivCtDtl> page = commonService.findPage(DivCtDtl.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("factorNm", new CondFactorNmFormatter());
        fmt.put("rangeNm", new CondRangeNmFormatter());
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }// ;

    /**
     * RangeNmFormatter formatter
     */
    class RangeNmFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer rangeNm = new StringBuffer();
            if (in instanceof DivFtDtl) {
                DivFtDtl ftDtl = ((DivFtDtl) in);
                if (ftDtl != null) {
                    rangeNm.append(ftDtl.getRangeNm());
                }
            }
            return rangeNm.toString();
        }
    }

    /**
     * RangeNmFormatter formatter
     */
    class CondValFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;

        private FactorMntService factorMntService2;

        public CondValFormatter(FactorMntService factorMntService) {
            this.factorMntService2 = factorMntService;
        }

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer result = new StringBuffer();
            if (in instanceof DivCtItm) {
                DivCtItm ctItm = ((DivCtItm) in);
                if (ctItm.getDivCtDtls() != null && !ctItm.getDivCtDtls().isEmpty()) {
                    for (DivCtDtl ctDtl : ctItm.getDivCtDtls()) {
                        DivFtDtl ftDtl = factorMntService2.findByFactorNoAndRangeNo(ctDtl.getFactorNo(), ctDtl.getRangeNo());
                        result.append(ftDtl.getRangeNm() + ",");
                    }
                    result.deleteCharAt(result.lastIndexOf(","));
                }
            }
            return result.toString();
        }
    }

    /**
     * factorNmFormatter formatter
     */
    class FactorNmFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer factorNm = new StringBuffer();
            if (in instanceof DivFtDtl) {
                DivFtDtl ftDtl = ((DivFtDtl) in);
                if (ftDtl.getDivFtItm() != null) {
                    factorNm.append(ftDtl.getDivFtItm().getFactorNm());
                }
            }
            return factorNm.toString();
        }
    }

    /**
     * CondRangeNmFormatter formatter
     */
    class CondRangeNmFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer rangeNm = new StringBuffer();
            if (in instanceof DivCtDtl) {
                DivCtDtl ctDtl = ((DivCtDtl) in);
                if (ctDtl.getDivFtDtl() != null) {
                    DivFtDtl ftDtl = ctDtl.getDivFtDtl();
                    rangeNm.append(ftDtl.getRangeNm());
                }
            }
            return rangeNm.toString();
        }
    }

    /**
     * RangeNmFormatter formatter
     */
    class CondFactorNmFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer rangeNm = new StringBuffer();
            if (in instanceof DivCtDtl) {
                DivCtDtl ctDtl = ((DivCtDtl) in);
                if (ctDtl.getDivFtDtl() != null) {
                    DivFtDtl ftDtl = ctDtl.getDivFtDtl();
                    rangeNm.append(ftDtl.getDivFtItm().getFactorNm());
                }
            }
            return rangeNm.toString();
        }
    }
}