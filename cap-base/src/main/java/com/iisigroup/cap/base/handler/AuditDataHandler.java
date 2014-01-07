/* 
 * AuditConfigHandler.java
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.model.AuditData;
import com.iisigroup.cap.base.model.AuditLog;
import com.iisigroup.cap.base.service.AuditDataService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.formatter.ADDateTimeFormatter;
import com.iisigroup.cap.formatter.IFormatter;
import com.iisigroup.cap.formatter.SimpleToStringStyle;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.service.ICommonService;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 使用者操作記錄查詢
 * </pre>
 * 
 * @since 2014/1/6
 * @author tammy
 * @version <ul>
 *          <li>2014/1/6,tammy,new
 *          </ul>
 */
@Scope("request")
@Controller("auditDatahandler")
public class AuditDataHandler extends MFormHandler {

	@Resource(name = "CommonBeanService")
	private ICommonService commonSrv;

	@Resource
	private AuditDataService auditDataService;

	// @Autowired
	// private CodeTypeService codeTypeService;

	@HandlerType(HandlerTypeEnum.GRID)
	public GridResult query(ISearch search, IRequest params) {

		String date = params.get("sdate");
		String time = params.get("time");
		String userId = params.get("userId");
		String mainId = params.get("mainId");
		String sysId = params.get("sysId");
		String invokeTarget = params.get("invokeTarget");
		String sno = params.get("sno");

		search.addSearchModeParameters(SearchMode.EQUALS, "sysId", sysId);

		if (!CapString.isEmpty(date)) {
			search.addSearchModeParameters(SearchMode.GREATER_EQUALS,
					"startTime", getDate(date, time));
		}
		if (!CapString.isEmpty(userId)) {
			search.addSearchModeParameters(SearchMode.LIKE, "userId", userId);
		}
		if (!CapString.isEmpty(mainId)) {
			search.addSearchModeParameters(SearchMode.LIKE, "mainId", mainId);
		}
		if (!CapString.isEmpty(invokeTarget)) {
			search.addSearchModeParameters(SearchMode.LIKE, "invokeTarget", "%"
					+ invokeTarget + "%");
		}
		if (!CapString.isEmpty(sno)) {
			search.addSearchModeParameters(SearchMode.EQUALS, "sno", sno);
		}
		search.addOrderBy("startTime", true);

		Map<String, IFormatter> fmt = new HashMap<String, IFormatter>();
		fmt.put("endTime", new ADDateTimeFormatter("yyyy-MM-dd HH:mm:ss:SSS"));
		fmt.put("startTime", new ADDateTimeFormatter("yyyy-MM-dd HH:mm:ss:SSS"));

		Page<AuditLog> page = commonSrv.findPage(AuditLog.class, search);
		return new GridResult(page.getContent(), page.getTotalRow(), fmt);
	}// ;

	/**
	 * 日期
	 * 
	 * @param updatedDate
	 * @param updatedTime
	 * @return
	 */
	private Date getDate(String updatedDate, String updatedTime) {
		try {
			if (StringUtils.isBlank(updatedTime)) {
				return new SimpleDateFormat("yyyy-MM-dd").parse(updatedDate);
			} else {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm")
						.parse(updatedDate + " " + updatedTime);
			}
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 查詢LOG明細
	 * 
	 * @param params
	 * @param parent
	 * @return
	 * @throws CapException
	 */
	public IResult queryAuditData(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		String logSno = request.get("logSno");
		String sysId = request.get("sysId");
		List<AuditData> list = auditDataService.findAuditData(sysId, logSno);
		ToStringBuilder in = new ToStringBuilder(this,
				new SimpleToStringStyle());
		ToStringBuilder out = new ToStringBuilder(this,
				new SimpleToStringStyle());

		for (AuditData m : list) {
			String flag = m.getFlag();
			if (StringUtils.equals(AuditData.TYPE_REQUEST, flag)) {
				in.append(m.getData());
			} else if (StringUtils.equals(AuditData.TYPE_RESPONSE, flag)) {
				out.append(m.getData());
			}
		}

		result.set("inData", escapeContent(in.toString()));
		result.set("outData", escapeContent(out.toString()));

		return result;
	}

	private String escapeContent(String src) {
		return // StringEscapeUtils.escapeJavaScript(src.toString());
		src.replaceAll("\\{", "｛").replaceAll("\\}", "｝").replaceAll("<", "＜")
				.replaceAll(">", "＞").replaceAll("\\[", "〔")
				.replaceAll("\\]", "〕").replaceAll("\\|", "｜");
	}

}
