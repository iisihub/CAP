/* 
 * SampilePageReport.java
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

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.component.IRequest;

/**
 * <pre>
 * 啟用 page report
 * </pre>
 * 
 * @since 2012/3/14
 * @author rodeschen
 * @version <ul>
 *          <li>2012/3/14,rodeschen,new
 *          </ul>
 */
@Scope("request")
@Service("SamplePR")
public class SampilePageReport implements IPageReport {

    @Override
    public Map<String, Object> excute(IRequest request) {
        Map<String, Object> m = new HashMap<String, Object>();
        // TODO put data to m
        return m;
    }

}
