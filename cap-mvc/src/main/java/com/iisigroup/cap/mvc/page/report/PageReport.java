/* 
 * IPageReport.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.mvc.page.report;

import java.util.Map;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.service.Service;

/**
 * <pre>
 * page report service
 * </pre>
 * 
 * @since 2012/3/14
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2012/3/14,rodeschen,new
 *          </ul>
 */
public interface PageReport extends Service {

    /**
     * report action
     * 
     * @param request
     *            request
     * @return report data
     * @throws CapException
     */
    Map<String, Object> excute(IRequest request);
}
