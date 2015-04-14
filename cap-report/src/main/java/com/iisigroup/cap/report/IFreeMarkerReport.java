/* 
 * IFreeMarkerAware.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.report;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.iisigroup.cap.mvc.page.report.IPageReport;
import com.iisigroup.cap.utils.CapSystemConfig;

/**
 * <pre>
 * FreeMarker report of page report
 * </pre>
 * 
 * @since 2013/11/12
 * @author Sunkist Wang
 * @version <ul>
 *          <li>2013/11/12,Sunkist Wang,new
 *          </ul>
 */
public interface IFreeMarkerReport extends IPageReport {

    /**
     * Get configure FreeMarker for web usage
     * 
     * @return
     */
    FreeMarkerConfigurer getFmConfg();

    /**
     * Get system config util
     * 
     * @return
     */
    CapSystemConfig getSysConfig();

}
