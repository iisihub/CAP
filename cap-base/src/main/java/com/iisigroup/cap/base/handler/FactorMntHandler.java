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

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.model.DivFtItm;
import com.iisigroup.cap.base.service.FactorMntService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapAppContext;
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
	
	private static final Logger logger = LoggerFactory
			.getLogger(FactorMntHandler.class);
	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {
		if (params.containsKey("factorNo")) {
			search.addSearchModeParameters(SearchMode.EQUALS, "factorNo",
					params.get("factorNo"));
		}
//		if (params.containsKey("inputFlg")) {
//			search.addSearchModeParameters(SearchMode.EQUALS, "inputFlg",
//					params.get("inputFlg"));
//		}
		
		Page<CodeType> page = commonService.findPage(CodeType.class, search);
		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("updateTime", new ADDateFormatter());
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/**
	 * modify codetype
	 * 
	 * @param request
	 *            request
	 * @return IResult
	 */
	public IResult modify(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		String type = request.get("type");
		String divFtItmNo = request.get("divFtItmNo");
//		String locale = CapSecurityContext.getLocale().toString();
		DivFtItm ftItm = factorMntService.findByDivFtItmNo(divFtItmNo);

		if ("A".equals(type)) {
			if (ftItm != null) {
				// factorMnt.0001 代碼重覆!
				throw new CapMessageException(
						CapAppContext.getMessage("factorMnt.0001"), getClass());
			}
			ftItm = new DivFtItm();
		} else {
			if (ftItm != null && !ftItm.getOid().equals(request.get("oid"))) {
				// factorMnt.0001 代碼重覆!
				throw new CapMessageException(
						CapAppContext.getMessage("factorMnt.0001"), getClass());
			} else if (ftItm == null) {
				ftItm = factorMntService.getById(request.get("oid"));
			}
		}
		CapBeanUtil.map2Bean(request, ftItm);
		if ("A".equals(type)) {
			ftItm.setOid(null);
		}
		ftItm.setUpdater(CapSecurityContext.getUserId());
		ftItm.setUpdateTime(CapDate.getCurrentTimestamp());
		factorMntService.saveDivFtItm(ftItm);
		return result;
	}

	/**
	 * delete codetype
	 * 
	 * @param request
	 *            request
	 * @return IResult
	 */
	public IResult delete(IRequest request) {
		AjaxFormResult result = new AjaxFormResult();
		factorMntService.deleteById(request.get("oid"));
		return result;
	}

	/**
	 * get combo list By Keys
	 * 
	 * @param request
	 *            request
	 * @return IResult
	 */
	@SuppressWarnings("rawtypes")
	public IResult queryByKeys(IRequest request) {
		factorMntService.insertTestCaseInfoData();
		if(true){
			return new AjaxFormResult();
		}
		
//		String locale = CapSecurityContext.getLocale().toString();
		String[] ftItmNos = request.getParamsAsStringArray("ftItmNos");
		AjaxFormResult mresult = new AjaxFormResult();
		if (ftItmNos.length > 0 && !CapString.isEmpty(ftItmNos[0])) {
			Set<String> k = new HashSet<String>(Arrays.asList(ftItmNos));// 排除重覆的key
			Map<String, AjaxFormResult> m = factorMntService.getDivFtItmByNos(
					k.toArray(new String[k.size()]));
			mresult.setResultMap(m);
		}
//		if (aKeys.length > 0 && !CapString.isEmpty(aKeys[0])) {
//			Class[] paramTypes = { IRequest.class };
//			IResult rtn = null;
//			for (String key : aKeys) {
//				if (mresult.containsKey(key)) {
//					continue;
//				}
//				Method method = ReflectionUtils.findMethod(this.getClass(),
//						key, paramTypes);
//				if (method != null) {
//					try {
//						rtn = (IResult) method.invoke(this, request);
//					} catch (Exception e) {
//						logger.error("load ComboBox error : key = " + key, e);
//					}
//					mresult.set(key, (AjaxFormResult) rtn);
//				}
//			}
//		}
		return mresult;
	}// ;

}
