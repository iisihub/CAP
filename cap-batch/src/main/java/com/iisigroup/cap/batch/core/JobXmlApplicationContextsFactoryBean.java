/* 
 * JobXmlApplicationContextsFactoryBean.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.core;

import java.util.List;

import org.springframework.batch.core.configuration.support.ClasspathXmlApplicationContextsFactoryBean;
import org.springframework.core.io.Resource;

import com.iisigroup.cap.batch.service.BatchJobService;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/11/6
 * @author iristu
 * @version <ul>
 *          <li>2012/11/6,iristu,new
 *          </ul>
 */
public class JobXmlApplicationContextsFactoryBean extends ClasspathXmlApplicationContextsFactoryBean {

    private BatchJobService jobService;

    public void setJobService(BatchJobService jobService) {
        this.jobService = jobService;
        setJobXmlResources();
    }

    public void setJobXmlResources() {
        List<Resource> resources = jobService.listJobResources();
        setResources(resources.toArray(new Resource[resources.size()]));
    }// ;

}// ~
