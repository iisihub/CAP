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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.DecisionTableConfiguration;
import org.drools.builder.DecisionTableInputType;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.DroolsConstants;
import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.IBeanFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.ByteArrayDownloadResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.rule.model.CaseInfo;
import com.iisigroup.cap.rule.model.DivCtDtl;
import com.iisigroup.cap.rule.model.DivCtItm;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;
import com.iisigroup.cap.rule.model.DivRlDtl;
import com.iisigroup.cap.rule.model.DivRlItm;
import com.iisigroup.cap.rule.service.ConditionMntService;
import com.iisigroup.cap.rule.service.FactorMntService;
import com.iisigroup.cap.rule.service.RuleTbMntService;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.CommonService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
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
@Controller("ruleTbMnthandler")
public class RuleTbMntHandler extends MFormHandler {

    @Resource
    private ConditionMntService conditionMntService;
    @Resource
    private FactorMntService factorMntService;
    @Resource
    private RuleTbMntService ruleTbMntService;

    @Resource
    private CommonService commonService;

    private final Logger logger = LoggerFactory.getLogger(RuleTbMntHandler.class);

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
        String divCtNo = request.get("divRlNo");
        AjaxFormResult result = new AjaxFormResult();
        DivRlItm rlItm = null;
        if (!CapString.isEmpty(oid)) {
            rlItm = ruleTbMntService.getById(oid);
        } else if (!CapString.isEmpty(divCtNo)) {
            rlItm = ruleTbMntService.findByDivRlNo(divCtNo);
        }
        if (rlItm != null) {
            result.putAll(rlItm.toJSONObject(new String[] { "divRlNo", "divRlNm", "oid" }, null));
            result.set("RadioGroup1", rlItm.getDivRlTyp());
        }

        return result;
    }

    /**
     * modify Condition Item and Detail
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult saveRuleTbDtl(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String type = request.get("type");
        String divCtNo = request.get("divRlNo");
        // Factor DETAIL
        String[] ftGridData = request.getParamsAsStringArray("grid[]");
        DivRlItm rlItm = ruleTbMntService.findByDivRlNo(divCtNo);

        if ("A".equals(type)) {
            if (rlItm != null) {
                // 代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("ruleTb.0001"), getClass());
            }
            rlItm = new DivRlItm();
        } else {
            if (rlItm != null && !rlItm.getOid().equals(request.get("oid"))) {
                // 代碼重覆!
                throw new CapMessageException(CapAppContext.getMessage("ruleTb.0001"), getClass());
            } else if (rlItm == null && !CapString.isEmpty(request.get("oid"))) {
                rlItm = ruleTbMntService.getById(request.get("oid"));
            } else if (rlItm == null) {
                rlItm = new DivRlItm();
            }
        }
        CapBeanUtil.map2Bean(request, rlItm);
        if ("A".equals(type)) {
            rlItm.setOid(null);
        }
        List<DivRlDtl> delRlDtl = new ArrayList<DivRlDtl>();
        if (ftGridData != null) {
            List<DivRlDtl> rlDtls = new LinkedList<DivRlDtl>();
            if (rlItm.getDivRlDtls() != null && !rlItm.getDivRlDtls().isEmpty()) {
                delRlDtl = rlItm.getDivRlDtls();
            }
            for (int i = 0; i < ftGridData.length; i++) {
                JSONObject jsData = JSONObject.fromObject(ftGridData[i]);
                DivRlDtl rlDtl = new DivRlDtl();
                // int j = 0;
                // boolean haveOld = false;
                // if(!CapString.isEmpty(jsData.getString("oid")) && !rlItm.getDivRlDtls().isEmpty()){
                // for(DivRlDtl rlDtl2 : rlDtls){
                // j++;
                // if(rlDtl2.getOid().equals(jsData.opt("oid"))){
                // rlDtl = rlDtl2;
                // haveOld = true;
                // break;
                // }
                // }
                // }
                CapBeanUtil.map2Bean(jsData, rlDtl);
                rlDtl.setDivRlNo(rlItm.getDivRlNo());
                rlDtl.setDivRlSor(new BigDecimal(i + 1));
                rlDtl.setDivCtNo(jsData.optString("divCtNo"));
                DivCtItm ctItm = conditionMntService.getById(jsData.optString("divCtOid"));
                // rlDtl.setDivCtItm(ctItm);
                rlDtl.setDivRlItm(rlItm);
                // if(haveOld){
                // rlDtls.set(j, rlDtl);
                // }else{
                rlDtls.add(rlDtl);
                // }
            }

            rlItm.setDivRlDtls(rlDtls);
        }
        String userId = CapSecurityContext.getUserId();
        if (userId.length() > 6)
            userId = userId.substring(0, 6);
        rlItm.setUpdater(userId);
        rlItm.setUpdateTime(CapDate.getCurrentTimestamp());
        String divRltyp = request.get("RadioGroup1");
        rlItm.setDivRlTyp(divRltyp);
        ruleTbMntService.saveDivRlItm(rlItm);
        if (!delRlDtl.isEmpty())
            ruleTbMntService.deleteRlDtlByList(delRlDtl);
        result.set(Constants.AJAX_NOTIFY_MESSAGE, CapAppContext.getMessage("ruleTb.0002"));
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
        ruleTbMntService.deleteById(request.get("oid"));
        result.set(Constants.AJAX_NOTIFY_MESSAGE, CapAppContext.getMessage("ruleTb.0003"));
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

    @HandlerType(HandlerTypeEnum.FileDownload)
    public IResult dwnload(IRequest request) throws CapException {
        File file = createDecisionTable(request);
        FileInputStream is = null;
        try {
            is = FileUtils.openInputStream(file);
            // return new FileDownloadResult(request, file.getPath(), file.getName(), "xls/plain");
            return new ByteArrayDownloadResult(request, IOUtils.toByteArray(is), "xls/plain", file.getName());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return new AjaxFormResult();
    }

    public File createDecisionTable(IRequest request) {
        // String packageName = "com.iisigroup.cap.service";
        // String importClass = "com.iisigroup.cap.base.model.CaseInfo,com.iisigroup.cap.utils.CapDroolsUtil";r
        // String variablesName = "com.iisigroup.cap.utils.CapDroolsUtil comUtil";
        String divRlNo = request.get("divRlNo");
        String oid = request.get("oid");
        DivRlItm rlItm = ruleTbMntService.getByRlItmNo(divRlNo);
        if (rlItm == null || rlItm.getDivRlDtls() == null) {
            return null;
        }
        // 取得排序的Rule明細
        List<DivRlDtl> rlDtls = ruleTbMntService.findRlDtlsByRlNoAndSort(rlItm.getDivRlNo());// rlItm.getDivRlDtls();
        List<DivCtItm> ctItms = null;
        WritableWorkbook workbook = null;
        File relFile = null;
        try {
            File fileDir = new File("../Temp");
            FileUtils.forceMkdir(fileDir);
            // 使用Char(3.6) 取得承辦分行資料。
            List<Map<String, Object>> lnf312Data = new ArrayList<Map<String, Object>>();
            String BRNO = "", BRNM = "";
            StringBuffer BRNoNm = new StringBuffer();
            if (!CollectionUtils.isEmpty(lnf312Data)) {
                for (Map<String, Object> map : lnf312Data) {
                    BRNO = MapUtils.getString(map, "BRNO") + " ";
                    BRNM = MapUtils.getString(map, "BRNM") + " ";
                    BRNoNm.append(BRNO).append(BRNM);
                }
            }

            relFile = new File(fileDir + File.separator + CapDate.getCurrentDate("yyyyMMdd") + "_ruleExport.xls");
            relFile.createNewFile();
            // 2. 產生 workbook
            workbook = Workbook.createWorkbook(relFile);
            WritableSheet sheet1 = workbook.createSheet("Tables", 0);
            WritableFont myFont = new WritableFont(WritableFont.createFont("Arial"), 12);
            WritableFont boldWhiteFnt = new WritableFont(WritableFont.createFont("Arial"), 12, WritableFont.BOLD);
            boldWhiteFnt.setColour(Colour.WHITE);
            WritableFont blackFnt = new WritableFont(WritableFont.createFont("Arial"), 12, WritableFont.NO_BOLD);
            blackFnt.setColour(Colour.BLACK);
            // 第1行先放空白資料，並設定欄寬--->還沒設定
            // DecisionTable起始先告區(黑底白字)
            WritableCellFormat headCellFmt = new WritableCellFormat();
            // 自動換行
            headCellFmt.setWrap(false);
            // 水平靠左
            headCellFmt.setAlignment(Alignment.LEFT);
            // 垂直置中
            headCellFmt.setVerticalAlignment(VerticalAlignment.TOP);
            // 設字形
            headCellFmt.setFont(boldWhiteFnt);
            // 設欄位框(細)線
            // headCellFmt.setBorder(Border.ALL,BorderLineStyle.THIN, Colour.BLACK);
            // 設定顏色
            headCellFmt.setBackground(Colour.GRAY_80);

            // DecisionTable內容橘底黑字
            WritableCellFormat setCellFmt = new WritableCellFormat();
            // 自動換行
            setCellFmt.setWrap(true);
            // 水平靠左
            setCellFmt.setAlignment(Alignment.LEFT);
            // 垂直置中
            setCellFmt.setVerticalAlignment(VerticalAlignment.TOP);
            // 設字形
            setCellFmt.setFont(myFont);
            // 設欄位框(細)線
            setCellFmt.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            // 設定顏色(粉橘色)
            setCellFmt.setBackground(Colour.TAN);

            // DecisionTable內容白底黑字
            WritableCellFormat bodyCellFmt = new WritableCellFormat();
            // 自動換行
            bodyCellFmt.setWrap(false);
            // 水平靠左
            bodyCellFmt.setAlignment(Alignment.LEFT);
            // 垂直置中
            bodyCellFmt.setVerticalAlignment(VerticalAlignment.TOP);
            // 設字形
            bodyCellFmt.setFont(myFont);
            // 設欄位框(細)線
            bodyCellFmt.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            // 設定顏色
            // bodyCellFmt.setBackground(Colour.BLACK);

            // DecisionTable內容藍底黑字
            WritableCellFormat blueCellFmt = new WritableCellFormat();
            // 自動換行
            blueCellFmt.setWrap(false);
            // 水平靠左
            blueCellFmt.setAlignment(Alignment.LEFT);
            // 垂直置中
            blueCellFmt.setVerticalAlignment(VerticalAlignment.TOP);
            // 設字形
            blueCellFmt.setFont(myFont);
            // 設欄位框(細)線
            blueCellFmt.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            blueCellFmt.setBackground(Colour.LIGHT_TURQUOISE);

            // DecisionTable內容黃底黑字
            WritableCellFormat yellowCellFmt = new WritableCellFormat();
            // 自動換行
            yellowCellFmt.setWrap(false);
            // 水平靠左
            yellowCellFmt.setAlignment(Alignment.LEFT);
            // 垂直置中
            yellowCellFmt.setVerticalAlignment(VerticalAlignment.TOP);
            // 設字形
            yellowCellFmt.setFont(myFont);
            // 設欄位框(細)線
            yellowCellFmt.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            yellowCellFmt.setBackground(Colour.YELLOW);

            // DecisionTable內容綠底黑字
            WritableCellFormat greenCellFmt = new WritableCellFormat();
            // 自動換行
            greenCellFmt.setWrap(false);
            // 水平靠左
            greenCellFmt.setAlignment(Alignment.LEFT);
            // 垂直置中
            greenCellFmt.setVerticalAlignment(VerticalAlignment.TOP);
            // 設字形
            greenCellFmt.setFont(myFont);
            // 設欄位框(細)線
            greenCellFmt.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            greenCellFmt.setBackground(Colour.LIGHT_GREEN);

            // 設列高
            // int row = 0;
            // sheet1.setRowView(row,450);
            // 將第row行的欄寬設為100
            // sheet1.setColumnView(row, 100);
            // 合併儲存格（x,y, x1,y2）
            // sheet1.mergeCells(0, row, 11, row);
            // sheet1.addCell(new Label(0, 0, "", bodyCellFmt));
            // sheet1.setColumnView(0, 26);

            for (int i = 0; i < 65535; i++) {
                sheet1.setRowView(i + 1, 450);
                sheet1.setColumnView(i, 23);
            }
            sheet1.setRowView(12, 900);

            // DecisionTable開頭宣告-參數
            NumberFormat nf = new DecimalFormat("#.00");
            sheet1.addCell(new Label(1, 2, "RuleSet", headCellFmt));
            sheet1.addCell(new Label(1, 3, "Import", headCellFmt));
            sheet1.addCell(new Label(1, 4, "EscapeQuotes", headCellFmt));
            sheet1.addCell(new Label(1, 5, "Variables", headCellFmt));
            sheet1.addCell(new Label(1, 6, "Functions", headCellFmt));
            sheet1.addCell(new Label(1, 7, "Notes", headCellFmt));
            sheet1.addCell(new Label(1, 9, "RuleTable " + rlItm.getDivRlNm(), headCellFmt));

            // DecisionTable開頭宣告-值
            sheet1.addCell(new Label(2, 2, DroolsConstants.PACKAGE_NAME, headCellFmt));
            sheet1.addCell(new Label(2, 3, DroolsConstants.IMPORT_CLASS, headCellFmt));
            sheet1.addCell(new Label(2, 4, "false", headCellFmt));
            sheet1.addCell(new Label(2, 5, DroolsConstants.VARIABLES_NAME, headCellFmt));
            // 設定均量化參數
            sheet1.addCell(new Label(2, 6, "", headCellFmt));
            sheet1.addCell(new Label(2, 7, "This is decision table for " + rlItm.getDivRlNm(), headCellFmt));
            sheet1.addCell(new Label(2, 9, "", headCellFmt));
            // excel合併儲存格（著色）
            for (int i = 0; i < 6; i++) {
                sheet1.mergeCells(2, 2 + i, 7, 2 + i);
            }
            // 合併儲存格
            sheet1.mergeCells(2, 9, 7, 9);
            /* 以下為條件判斷,分案設定內容 */
            // 這一行要先決定開多少個condition和action
            // 查出所有condition detail
            int conditionMaxCount = 0;
            // 記錄有多少database table & column會用來做判斷
            List<String> tableNms = new ArrayList<String>();
            Map<String, DivCtDtl> colNms = new LinkedHashMap<String, DivCtDtl>();
            // 排序的條件明細把它放到一個總集合，之後要填條件內容值($param)
            List<DivCtItm> ctItmList = new ArrayList<DivCtItm>();
            for (DivRlDtl rlDtl : rlDtls) {
                DivCtItm ctItm = conditionMntService.findByDivCtItmNo(rlDtl.getDivCtNo());
                if (ctItm.getDivCtDtls() != null && ctItm.getDivCtDtls().size() > conditionMaxCount) {
                    conditionMaxCount = ctItm.getDivCtDtls().size();
                }
                // 排序的條件明細
                List<DivCtDtl> ctDtls = conditionMntService.findCtDtlsByCtNoAndSort(ctItm.getDivCtNo());
                // 算出有幾種因子(因子和條件為1to1)
                for (DivCtDtl ctDtl : ctDtls) {
                    if (ctDtl.getDivFtDtl() != null && ctDtl.getDivFtDtl().getDivFtItm() != null) {
                        DivFtItm ftItm = ctDtl.getDivFtDtl().getDivFtItm();
                        String tableNm = ftItm.getTableNm();
                        String colNm = ftItm.getColumnNm();
                        // 每一種因子只會出現在CONDITION欄位一次
                        if (!tableNms.contains(tableNm)) {
                            tableNms.add(tableNm);
                        }
                        if (!colNms.containsKey(colNm)) {
                            colNms.put(colNm, ctDtl);
                        }
                    }
                }
                ctItmList.add(ctItm);
            } // 算完rule detail的內容

            // 開始寫RuleTable第二行(抬頭)
            int i = 0, j = 0;
            Map<String, Integer> colSortNo = new HashMap<String, Integer>();
            for (String key : colNms.keySet()) {
                DivCtDtl ctDtl = colNms.get(key);
                // CONDITOIN宣告欄位
                sheet1.addCell(new Label(1 + j, 10, DroolsConstants.CONDITION_COL, setCellFmt));
                // 資料型別宣告
                sheet1.addCell(new Label(1 + j, 11, "beanClz:" + tableNms.get(0), setCellFmt));
                // 這一行要擺 物件.屬性 + "比較運算元" + param/$1,$2
                String operand = "";
                if (ctDtl.getDivFtDtl() != null) {
                    DivFtDtl ftDtl = ctDtl.getDivFtDtl();
                    if (!CapString.isEmpty(ftDtl.getRange1()) && !CapString.isEmpty(ftDtl.getRange2())) {
                        operand = "$1<" + key + "&&" + key + "<=$2";
                    } else {
                        operand = key + "==$param";
                    }
                }
                sheet1.addCell(new Label(1 + j, 12, operand, setCellFmt));
                sheet1.addCell(new Label(1 + j, 13, key, blueCellFmt));
                colSortNo.put(key, 1 + j);
                i++;
                j++;
            }
            // Bean 宣告合併欄位
            sheet1.mergeCells(1, 11, j, 11);

            // 宣告完CONDITION欄位，在宣告ACTIVITION-GROUP&NO-LOOP&PRIORITY
            int actGpColNo = 1 + j;
            sheet1.addCell(new Label(actGpColNo, 10, DroolsConstants.ACTIVATION_GROUP, setCellFmt));
            sheet1.addCell(new Label(actGpColNo, 11, "", setCellFmt));
            sheet1.addCell(new Label(actGpColNo, 12, "", setCellFmt));
            sheet1.addCell(new Label(actGpColNo, 13, "activation group", blueCellFmt));
            int noLpColNo = actGpColNo + 1;
            sheet1.addCell(new Label(noLpColNo, 10, DroolsConstants.NO_LOOP, setCellFmt));
            sheet1.addCell(new Label(noLpColNo, 11, "", setCellFmt));
            sheet1.addCell(new Label(noLpColNo, 12, "", setCellFmt));
            sheet1.addCell(new Label(noLpColNo, 13, "no loop", blueCellFmt));
            int priColNo = noLpColNo + 1;
            sheet1.addCell(new Label(priColNo, 10, DroolsConstants.PRIORITY, setCellFmt));
            sheet1.addCell(new Label(priColNo, 11, "", setCellFmt));
            sheet1.addCell(new Label(priColNo, 12, "", setCellFmt));
            sheet1.addCell(new Label(priColNo, 13, "priority", blueCellFmt));

            // 最後宣告ACTION
            int actColNo1 = priColNo + 1;
            sheet1.addCell(new Label(actColNo1, 10, DroolsConstants.ACTION_COL, setCellFmt));
            sheet1.addCell(new Label(actColNo1, 11, "", setCellFmt));
            sheet1.addCell(new Label(actColNo1, 12, "beanClz.setGrpUppId(\"$param\");", setCellFmt));
            sheet1.addCell(new Label(actColNo1, 13, "", yellowCellFmt));

            int actColNo2 = actColNo1 + 1;
            sheet1.addCell(new Label(actColNo2, 10, DroolsConstants.ACTION_COL, setCellFmt));
            sheet1.addCell(new Label(actColNo2, 11, "", setCellFmt));
            sheet1.addCell(new Label(actColNo2, 12, "beanClz.setDocStatus(\"$param\");", setCellFmt));
            sheet1.addCell(new Label(actColNo2, 13, "", yellowCellFmt));

            int actColNo3 = actColNo2 + 1;
            sheet1.addCell(new Label(actColNo3, 10, DroolsConstants.ACTION_COL, setCellFmt));
            sheet1.addCell(new Label(actColNo3, 11, "", setCellFmt));
            sheet1.addCell(new Label(actColNo3, 12, "System.out.println(\"$param\"+ \" CASEINFO IS " + "\" +beanClz.getCasNo()+\" ** 分組結果 = " + "\" +beanClz.getGrpUppId() );", setCellFmt));
            sheet1.addCell(new Label(actColNo3, 13, "", yellowCellFmt));
            sheet1.addCell(new Label(0, 13, "Base rules", greenCellFmt));

            /*
             * 將總明細資料一筆一筆拆開來，將condition-->factor的值域填到Excel
             */
            if (!ctItmList.isEmpty()) {
                int rowNo = 14, count = 0;
                for (DivCtItm ctItm : ctItmList) {
                    if (ctItm.getDivCtDtls() != null) {
                        // CtItm list對應到自己的CtDtl,所以一筆CtItm就是一行Rule Row
                        for (DivCtDtl ctDtl : ctItm.getDivCtDtls()) {
                            ctItm = ctDtl.getDivCtItm();
                            // 設定Action動作
                            sheet1.addCell(new Label(actColNo1, rowNo, ctItm.getDivCtAction(), bodyCellFmt));
                            sheet1.addCell(new Label(actColNo2, rowNo, ctItm.getDivCtSetting(), bodyCellFmt));
                            sheet1.addCell(new Label(actColNo3, rowNo, "Test Condition::" + ctItm.getDivCtNm(), bodyCellFmt));

                            DivFtDtl ftDtl = ctDtl.getDivFtDtl();
                            String colNm = ftDtl.getDivFtItm().getColumnNm();
                            // 取得要放到第幾個cell
                            Integer colNo = colSortNo.get(colNm);
                            String rangeVal = "";
                            if (!CapString.isEmpty(ftDtl.getRange1())) {
                                rangeVal = ftDtl.getRange1();
                            }
                            if (!CapString.isEmpty(ftDtl.getRange2())) {
                                rangeVal += "," + ftDtl.getRange2();
                            }
                            // 設定行row名稱(rule name)
                            sheet1.addCell(new Label(0, rowNo, ctDtl.getDivCtItm().getDivCtNm(), bodyCellFmt));
                            // 放入值域
                            sheet1.addCell(new Label(colNo, rowNo, rangeVal, bodyCellFmt));
                        }
                        sheet1.addCell(new Label(actGpColNo, rowNo, "group", bodyCellFmt));
                        sheet1.addCell(new Label(noLpColNo, rowNo, "true", bodyCellFmt));
                        sheet1.addCell(new Label(priColNo, rowNo, String.valueOf(ctItmList.size() - count), bodyCellFmt));
                        rowNo++;
                        count++;
                    }
                }
            }

            /* 內容END */

            workbook.write();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return relFile;
    }

    /**
     * 試算
     * 
     * @param request
     * @return IResult
     */
    public IResult testDrools(IRequest request) {

        File ruleXls = new File("/Volumes/RamDisk/rule_export.xls");
        AjaxFormResult result = new AjaxFormResult();
        try {
            Properties props = new Properties();
            props.setProperty("drools.dialect.java.compiler", "JANINO");
            KnowledgeBuilderConfiguration config = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration(props);
            KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(config);

            DecisionTableConfiguration dtconf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
            dtconf.setInputType(DecisionTableInputType.XLS);
            dtconf.setWorksheetName("Tables");
            kbuilder.add(ResourceFactory.newFileResource(ruleXls), ResourceType.DTABLE, dtconf);
            // kbuilder.add(ResourceFactory.newClassPathResource("rule_export.xls", getClass()), ResourceType.DTABLE, dtconf);

            if (kbuilder.hasErrors()) {
                KnowledgeBuilderErrors errs = kbuilder.getErrors();
                Iterator rr = errs.iterator();
                while (rr.hasNext()) {
                    Object obj = rr.next();
                    if (obj instanceof KnowledgeBuilderError) {
                        System.err.println(((KnowledgeBuilderError) obj).getMessage());
                    }
                }
                System.err.print(kbuilder.getErrors());
                result.set("tMsg", "試算發生錯誤，" + kbuilder.getErrors());
                return result;
            }

            KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
            kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

            // typical decision tables are used statelessly
            StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
            List<CaseInfo> csinfoList = ruleTbMntService.getNoneDispatchCaseInfo();
            // ksession2.setGlobal("currDate", CommonUtil.getSysDate());
            if (csinfoList != null && !csinfoList.isEmpty()) {
                int i = 0;
                for (CaseInfo csinfo : csinfoList) {
                    ksession.execute(Arrays.asList(new Object[] { csinfo }));
                }
            }
            ruleTbMntService.updateCaseInfo(csinfoList);
            System.out.println(" test dispatch success !");
            result.set("tMsg", "試算完成");
        } catch (Exception e) {
            result.set("tMsg", "試算發生錯誤，" + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return result;
    }

    /*********** Grid ***************************************************/
    /**
     * ViewPage查詢Rule Item Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryRuleItmByDivRlNo(SearchSetting search, IRequest params) {
        search.addSearchModeParameters(SearchMode.NOT_EQUALS, "divRlNo", "");

        Page<DivRlItm> page = commonService.findPage(DivRlItm.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("ruleCont", new RuleValFormatter(this.conditionMntService));
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * 查詢Condition Detail Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryConditionDetail(SearchSetting search, IRequest params) {
        // if (params.containsKey("divRlNo") && !CapString.isEmpty(params.get("divRlNo"))) {
        // search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo",
        // params.get("divRlNo"));
        // }else{
        // return new GridResult();
        // }
        // search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", "C000001");
        Page<DivCtItm> page = commonService.findPage(DivCtItm.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("divCtCont", new CondValNmFormatter());
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * 查詢Rule Detail Grid資料明細
     * 
     * @param search
     * @param params
     * @return
     */
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult queryRuleTbDetailByDivRlNo(SearchSetting search, IRequest params) {
        if (params.containsKey("divRlNo") && !CapString.isEmpty(params.get("divRlNo"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo", params.get("divRlNo"));
        } else {
            return new GridResult();
        }

        Page<DivRlDtl> page = commonService.findPage(DivRlDtl.class, search);
        Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
        fmt.put("divCtNm", new ConditionNmFormatter(conditionMntService));
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /********* Grid Formatter **********/

    /**
     * CondValNmFormatter formatter
     */
    class CondValNmFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer result = new StringBuffer();
            if (in instanceof DivCtItm) {
                DivCtItm ctItm = ((DivCtItm) in);
                if (ctItm.getDivCtDtls() != null) {
                    for (DivCtDtl ctDtl : ctItm.getDivCtDtls()) {
                        result.append(ctDtl.getDivFtDtl().getRangeNm() + ",");
                    }
                    if (result.length() > 0)
                        result.deleteCharAt(result.lastIndexOf(","));
                }
            }
            return result.toString();
        }
    }

    /**
     * RuleDetailNmFormatter formatter
     */
    class RuleValFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;
        private ConditionMntService conditionMntService;

        public RuleValFormatter(ConditionMntService conditionMntService) {
            this.conditionMntService = conditionMntService;
        }

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer result = new StringBuffer();
            if (in instanceof DivRlItm) {
                DivRlItm rlItm = ((DivRlItm) in);
                if (rlItm.getDivRlDtls() != null && !rlItm.getDivRlDtls().isEmpty()) {
                    for (DivRlDtl rlDtl : rlItm.getDivRlDtls()) {
                        DivCtItm ctItm = conditionMntService.findByDivCtItmNo(rlDtl.getDivCtNo());
                        if (ctItm != null)
                            result.append(ctItm.getDivCtNm() + ",");
                    }
                    if (result.length() > 0)
                        result.deleteCharAt(result.lastIndexOf(","));
                }
            }
            return result.toString();
        }
    }

    /**
     * ConditionNmFormatter formatter
     */
    class ConditionNmFormatter implements IBeanFormatter {
        private static final long serialVersionUID = 1L;
        private ConditionMntService conditionMntService;

        public ConditionNmFormatter(ConditionMntService conditionMntService) {
            this.conditionMntService = conditionMntService;
        }

        @SuppressWarnings("unchecked")
        public String reformat(Object in) throws CapFormatException {
            StringBuffer result = new StringBuffer();
            if (in instanceof DivRlDtl) {
                DivRlDtl rlDtl = ((DivRlDtl) in);
                DivCtItm ctItm = conditionMntService.findByDivCtItmNo(rlDtl.getDivCtNo());
                if (ctItm != null) {
                    result.append(ctItm.getDivCtNm());
                }
            }
            return result.toString();
        }
    }

    // /**
    // * CondRangeNmFormatter formatter
    // */
    // class CondRangeNmFormatter implements IBeanFormatter {
    // private static final long serialVersionUID = 1L;
    //
    // @SuppressWarnings("unchecked")
    // public String reformat(Object in) throws CapFormatException {
    // StringBuffer rangeNm = new StringBuffer();
    // if (in instanceof DivCtDtl) {
    // DivCtDtl ctDtl = ((DivCtDtl) in);
    // if(ctDtl.getDivFtDtl()!=null){
    // DivFtDtl ftDtl = ctDtl.getDivFtDtl();
    // rangeNm.append(ftDtl.getRangeNm());
    // }
    // }
    // return rangeNm.toString();
    // }
    // }

}
