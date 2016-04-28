/* 
 * BatchJobService.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.service;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobParameters;
import org.springframework.core.io.Resource;

import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * 排程 service
 * </pre>
 * 
 * @since 2012/11/6
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/11/6,iristu,new
 *          </ul>
 */
public interface BatchJobService {

    List<Resource> listJobResources();

    Resource getJobResource(BatchJob job);

    Page<BatchJob> findJobsPage(SearchSetting search);

    List<BatchJob> listJobs();

    BatchJob findJobById(String jobId);

    void updateJob(BatchJob job);

    void insertJob(BatchJob job);

    void deleteJob(String jobId);

    Page<BatchSchedule> findSchPage(SearchSetting search);

    BatchSchedule findSchById(String schId);

    List<BatchSchedule> findSchByHostId(List<String> hostId);

    void updateSch(BatchSchedule schedule);

    void insertSch(BatchSchedule schedule);

    void deleteSch(String schId);

    Page<Map<String, Object>> findExecutionsPage(SearchSetting search);

    List<Map<String, Object>> findSteps(String executionId);

    Map<String, Object> findExecutionDetail(String executionId);

    void updateExecution(Long executionId, String executor);

    JobParameters findJobParams(String executionId);

}
