/* 
 * SequenceHandler.java
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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.base.service.SequenceService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.response.MapGridResult;

/**
 * <pre>
 * 流水號
 * </pre>
 * 
 * @since 2012/10/25
 * @author iristu
 * @version <ul>
 *          <li>2012/10/25,iristu,new
 *          </ul>
 */
@Controller("sequencehandler")
public class SequenceHandler extends MFormHandler {

	@Autowired
	private SequenceService seqSrv;

	@HandlerType(HandlerTypeEnum.GRID)
	public MapGridResult query(ISearch search, IRequest params) {

		Page<Map<String, Object>> page = seqSrv.findPage(
				search.getFirstResult(), search.getMaxResults());
		return new MapGridResult(page.getContent(), page.getTotalRow());
	}// ;

	public IResult getNewSeq(IRequest params) {
		AjaxFormResult result = new AjaxFormResult();
		String seqNode = params.get("seqNode");
		int theSeq = seqSrv.getNextSeqNo(seqNode, 1, 1, Integer.MAX_VALUE);
		result.set("theSeq", theSeq);
		return result;
	}// ;

}
