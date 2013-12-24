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
package com.iisigroup.cap.base.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.DivCtDtl;
import com.iisigroup.cap.base.model.DivCtItm;
import com.iisigroup.cap.base.model.DivFtItm;
import com.iisigroup.cap.base.model.DivRlDtl;
import com.iisigroup.cap.base.model.DivRlItm;
import com.iisigroup.cap.base.service.ConditionMntService;
import com.iisigroup.cap.base.service.FactorMntService;
import com.iisigroup.cap.base.service.RuleTbMntService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapFormatException;
import com.iisigroup.cap.formatter.IBeanFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * Condition Maintain Handler
 * </pre>
 * 
 * @since 2013/12/24
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/24,TimChiang,new
 *          </ul>
 */
@Scope("request")
@Controller("ruleTbMnthandler")
public class RuleTbMntHandler extends MFormHandler {

	@Resource
	private ConditionMntService conditionMntService;
	@Resource
	private FactorMntService factorMntService;
	@Resource
	private RuleTbMntService ruleTbMntService;

	@Resource(name = "CommonBeanService")
	private ICommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(RuleTbMntHandler.class);
	
	/**
	 * 查詢Condition資料明細
	 * @param search
	 * @param params
	 * @return
	 */
	@HandlerType(HandlerTypeEnum.FORM)
	public IResult query(IRequest request) {
		String oid = request.get("mainOid");
		String divCtNo = request.get("divRlNo");
		AjaxFormResult result = new AjaxFormResult();
		DivCtItm ctItm = null;
		if(!CapString.isEmpty(oid)){
			ctItm = conditionMntService.getById(oid);
		}else if(!CapString.isEmpty(divCtNo)){
			ctItm = conditionMntService.findByDivCtItmNo(divCtNo);
		}
		if(ctItm!=null){
			result.putAll(ctItm.toJSONObject(new String[]{"divRlNo", "divRlNm"
					, "divRlTyp", "RadioGroup1", "oid"}, null));
		}
		
		return result;
	}// ;

	/**
	 * modify Condition Item and Detail
	 * @param request request
	 * @return IResult
	 */
	public IResult saveRuleTbDtl(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String type = request.get("type");
		String divCtNo = request.get("divRlNo");
		//Factor DETAIL
		String[] ftGridData = request.getParamsAsStringArray("grid");
		DivRlItm rlItm = ruleTbMntService.findByDivRlNo(divCtNo);

		if ("A".equals(type)) {
			if (rlItm != null) {
				// conditionMnt.0001 條件代碼重覆!
//				throw new CapMessageException(
//						CapAppContext.getMessage("conditionMnt.0001"), getClass());
			}
			rlItm = new DivRlItm();
		} else {
			if (rlItm != null && !rlItm.getOid().equals(request.get("oid"))) {
				// conditionMnt.0001 條件代碼重覆!
//				throw new CapMessageException(
//						CapAppContext.getMessage("conditionMnt.0001"), getClass());
			} else if (rlItm == null && !CapString.isEmpty(request.get("oid"))) {
				rlItm = ruleTbMntService.getById(request.get("oid"));
			} else if (rlItm == null){
				rlItm = new DivRlItm();
			}
		}
		CapBeanUtil.map2Bean(request, rlItm);
		if ("A".equals(type)) {
			rlItm.setOid(null);
		}
		List<DivRlDtl> delRlDtl = new ArrayList<DivRlDtl>();
		if(ftGridData!=null){
			List<DivRlDtl> rlDtls = new LinkedList<DivRlDtl>();
			if(!rlItm.getDivRlDtls().isEmpty()){
				delRlDtl = rlItm.getDivRlDtls();
			}
			for(int i = 0; i<ftGridData.length; i++){
				JSONObject jsData = JSONObject.fromObject(ftGridData[i]);
				DivRlDtl rlDtl = new DivRlDtl();
//				int j = 0;
//				boolean haveOld = false;
//				if(!CapString.isEmpty(jsData.getString("oid")) && !rlItm.getDivRlDtls().isEmpty()){
//					for(DivRlDtl rlDtl2 : rlDtls){
//						j++;
//						if(rlDtl2.getOid().equals(jsData.opt("oid"))){
//							rlDtl = rlDtl2;
//							haveOld = true;
//							break;
//						}
//					}
//				}
				CapBeanUtil.map2Bean(jsData, rlDtl);
				rlDtl.setDivRlNo(rlItm.getDivRlNo());
				rlDtl.setDivRlSor(new BigDecimal(i+1));
				rlDtl.setDivCtNo(jsData.optString("divCtNo"));
				DivCtItm ctItm = conditionMntService.getById(jsData.optString("divCtOid"));
				rlDtl.setDivCtItm(ctItm);
				rlDtl.setDivRlItm(rlItm);
//				if(haveOld){
//					rlDtls.set(j, rlDtl);
//				}else{
					rlDtls.add(rlDtl);
//				}
			}
			
			rlItm.setDivRlDtls(rlDtls);
		}
		String userId = CapSecurityContext.getUserId();
		if(userId.length()>6)userId = userId.substring(0,6);
		rlItm.setUpdater(userId);
		rlItm.setUpdateTime(CapDate.getCurrentTimestamp());
		rlItm.setDivRlTyp("C");
		ruleTbMntService.saveDivRlItm(rlItm);
		if(!delRlDtl.isEmpty())
			ruleTbMntService.deleteRlDtlByList(delRlDtl);
		return result;
	}

	/**
	 * delete Division Condition Item and Detail
	 * @param request request
	 * @return IResult
	 */
	public IResult delete(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		conditionMntService.deleteById(request.get("oid"));
		return result;
	}
	
	public IResult getFtSelOption(IRequest request){
		AjaxFormResult result = new AjaxFormResult();
		List<DivFtItm> ftItms = factorMntService.findAllDivFtItm();
		if(ftItms!=null){
			result.set(" ", "請選擇 -");
			for(DivFtItm ftItm : ftItms){
				result.set(ftItm.getFactorNo(), ftItm.getFactorNm());
			}
		}
		return result;
	}
	
	/***********Grid***************************************************/
	/**
	 * ViewPage查詢Rule Item Grid資料明細
	 * @param search
	 * @param params
	 * @return
	 */
	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult queryRuleItmByDivRlNo(ISearch search, IRequest params) {
		search.addSearchModeParameters(SearchMode.NOT_EQUALS, "divRlNo", "");
		
		Page<DivRlItm> page = commonService.findPage(DivRlItm.class, search);
		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("ruleCont", new RuleValFormatter(this.conditionMntService));
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;


	/**
	 * 查詢Condition Detail Grid資料明細
	 * @param search
	 * @param params
	 * @return
	 */
	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult queryConditionDetail(ISearch search, IRequest params) {
//		if (params.containsKey("divRlNo") && !CapString.isEmpty(params.get("divRlNo"))) {
//			search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo",
//					params.get("divRlNo"));
//		}else{
//			return new GridResult();
//		}
//		search.addSearchModeParameters(SearchMode.EQUALS, "divCtNo", "C000001");
		Page<DivCtItm> page = commonService.findPage(DivCtItm.class, search);
		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("divCtCont", new CondValNmFormatter());
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/**
	 * 查詢Rule Detail Grid資料明細
	 * @param search
	 * @param params
	 * @return
	 */
	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult queryRuleTbDetailByDivRlNo(ISearch search, IRequest params) {
		if (params.containsKey("divRlNo")
				&& !CapString.isEmpty(params.get("divRlNo"))) {
			search.addSearchModeParameters(SearchMode.EQUALS, "divRlNo",
					params.get("divRlNo"));
		} else {
			return new GridResult();
		}
		
		Page<DivRlDtl> page = commonService.findPage(DivRlDtl.class, search);
		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("CondNm", new ConditionNmFormatter());
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/*********      Grid Formatter    **********/
	
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
				if(ctItm.getDivCtDtls()!=null){
					for(DivCtDtl ctDtl : ctItm.getDivCtDtls()){
						result.append(ctDtl.getDivFtDtl().getRangeNm()+",");
					}
					if(result.length()>0)
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
		public RuleValFormatter(ConditionMntService conditionMntService){
			this.conditionMntService = conditionMntService;
		}
		@SuppressWarnings("unchecked")
		public String reformat(Object in) throws CapFormatException {
			StringBuffer result = new StringBuffer();
			if (in instanceof DivRlItm) {
				DivRlItm rlItm = ((DivRlItm) in);
				if(rlItm.getDivRlDtls()!=null && !rlItm.getDivRlDtls().isEmpty()){
					for(DivRlDtl rlDtl : rlItm.getDivRlDtls()){
						DivCtItm ctItm = 
								conditionMntService.findByDivCtItmNo(rlDtl.getDivCtNo());
						if(ctItm!=null)
							result.append(ctItm.getDivCtNm()+",");
					}
					if(result.length()>0)
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

		@SuppressWarnings("unchecked")
		public String reformat(Object in) throws CapFormatException {
			StringBuffer result = new StringBuffer();
			if (in instanceof DivRlDtl) {
				DivRlDtl rlDtl = ((DivRlDtl) in);
				if(rlDtl.getDivCtItm()!=null){
					result.append(rlDtl.getDivCtItm().getDivCtNm());
				}
			}
			return result.toString();
		}
	}
	
//	/**
//	 * CondRangeNmFormatter formatter
//	 */
//	class CondRangeNmFormatter implements IBeanFormatter {
//		private static final long serialVersionUID = 1L;
//
//		@SuppressWarnings("unchecked")
//		public String reformat(Object in) throws CapFormatException {
//			StringBuffer rangeNm = new StringBuffer();
//			if (in instanceof DivCtDtl) {
//				DivCtDtl ctDtl = ((DivCtDtl) in);
//				if(ctDtl.getDivFtDtl()!=null){
//					DivFtDtl ftDtl = ctDtl.getDivFtDtl();
//					rangeNm.append(ftDtl.getRangeNm());
//				}
//			}
//			return rangeNm.toString();
//		}
//	}

}
