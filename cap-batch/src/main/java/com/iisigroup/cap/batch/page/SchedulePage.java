/* 
 * SchedulePage.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.page;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.batch.service.BatchJobService;
import com.iisigroup.cap.mvc.action.BaseActionController;
import com.iisigroup.cap.service.CodeTypeService;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/11/15
 * @author iristu
 * @version <ul>
 *          <li>2012/11/15,iristu,new
 *          </ul>
 */
@Controller
public class SchedulePage extends BaseActionController {

	@Autowired
	private CodeTypeService codeTypeSrv;
	@Autowired
	private BatchJobService batchSrv;

	@RequestMapping(value = { "/batch/schedule" })
	public ModelAndView notifyStatus(Locale locale, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		Map<String, Map<String, String>> codes = codeTypeSrv.findByCodeTypes(
				new String[] { "jobExitCode", "timeZoneId", "schExeHost" },
				locale.toString());
		ModelAndView model = new ModelAndView(path);
		for (Entry<String, Map<String, String>> c : codes.entrySet()) {
			model.addObject(c.getKey(), c.getValue());
		}
		List<BatchJob> jobs = batchSrv.listJobs();
		model.addObject("batchJob",jobs);
		return model;
	}// ;
}
