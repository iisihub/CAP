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
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.DivFtDtl;
import com.iisigroup.cap.base.model.DivFtItm;
import com.iisigroup.cap.base.service.FactorMntService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
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
@Controller("factorMnthandler")
public class FactorMntHandler extends MFormHandler {

	@Resource
	private FactorMntService factorMntService;

	@Resource(name = "CommonBeanService")
	private ICommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(FactorMntHandler.class);
	
	/**
	 * 查詢Factor資料明細
	 * @param search
	 * @param params
	 * @return
	 */
	@HandlerType(HandlerTypeEnum.FORM)
	public IResult query(IRequest request) {
		String oid = request.get("mainOid");
		String factorNo = request.get("factorNo");
		AjaxFormResult result = new AjaxFormResult();
		DivFtItm ftItm = null;
		if(!CapString.isEmpty(oid)){
			ftItm = factorMntService.getById(oid);
		}else if(!CapString.isEmpty(factorNo)){
			ftItm = factorMntService.findByDivFtItmNo(factorNo);
		}
		if(ftItm!=null){
			result.putAll(ftItm.toJSONObject(new String[]{"factorNo", "factorNm", "dataType"
					, "oid", "tableNm", "columnNm"}, null));
		}
		return result;
	}// ;

	/**
	 * modify Factor Item and Detail
	 * @param request request
	 * @return IResult
	 */
	public IResult saveFactorDtl(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String type = request.get("type");
		String divFtItmNo = request.get("factorNo");
		String[] sary = request.getParamsAsStringArray("grid");
		DivFtItm ftItm = factorMntService.findByDivFtItmNo(divFtItmNo);

		if ("A".equals(type)) {
			if (ftItm != null) {
				// factorMnt.0001 代碼重覆!
//				throw new CapMessageException(
//						CapAppContext.getMessage("factorMnt.0001"), getClass());
			}
			ftItm = new DivFtItm();
		} else {
			if (ftItm != null && !ftItm.getOid().equals(request.get("oid"))) {
				// factorMnt.0001 代碼重覆!
//				throw new CapMessageException(
//						CapAppContext.getMessage("factorMnt.0001"), getClass());
			} else if (ftItm == null && !CapString.isEmpty(request.get("oid"))) {
				ftItm = factorMntService.getById(request.get("oid"));
			} else if (ftItm == null){
				ftItm = new DivFtItm();
			}
		}
		CapBeanUtil.map2Bean(request, ftItm);
		if ("A".equals(type)) {
			ftItm.setOid(null);
		}
		if(sary!=null){
			List<DivFtDtl> ftDtls = new ArrayList<DivFtDtl>();
			for(int i = 0 ; i<sary.length; i++){
				JSONObject gridData = JSONObject.fromObject(sary[i]);
				DivFtDtl ftDtl = new DivFtDtl();
				CapBeanUtil.map2Bean(gridData, ftDtl);
				ftDtl.setFactorNo(ftItm.getFactorNo());
				ftDtl.setRangeNo(CapString.fillString(String.valueOf(i), 5, true, '0'));
				ftDtl.setRangeSor(new BigDecimal(i));
				ftDtl.setDivFtItm(ftItm);
				ftDtls.add(ftDtl);
			}
			ftItm.setDivFtDtls(ftDtls);
		}
		String userId = CapSecurityContext.getUserId();
		if(userId.length()>6)userId = userId.substring(0,6);
		ftItm.setUpdater(userId);
		ftItm.setUpdateTime(CapDate.getCurrentTimestamp());
		factorMntService.saveDivFtItm(ftItm);
		return result;
	}

	/**
	 * delete Division Factor Item and Detail
	 * @param request request
	 * @return IResult
	 */
	public IResult delete(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		factorMntService.deleteById(request.get("oid"));
		return result;
	}

}
