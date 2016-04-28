/* 
 * BatchJobServiceImpl.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.batch.core.JobParameters;

import com.iisigroup.cap.batch.dao.BatchExecutionDao;
import com.iisigroup.cap.batch.dao.BatchJobDao;
import com.iisigroup.cap.batch.dao.BatchScheduleDao;
import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapSystemConfig;

/**
 * <pre>
 * 排程批次處理
 * </pre>
 * 
 * @since 2012/11/6
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/11/6,iristu,new
 *          </ul>
 */
public class BatchJobServiceImpl implements BatchJobService {

    @Resource
    private BatchJobDao batchJobDao;

    @Resource
    private BatchScheduleDao batchScheduleDao;

    @Resource
    private BatchExecutionDao batchExecutionDao;

    @Resource
    private CapSystemConfig config;

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.batch.service.BatchJobService#listJobResources()
     */
    @Override
    public List<org.springframework.core.io.Resource> listJobResources() {
        List<BatchJob> list = listJobs();
        List<org.springframework.core.io.Resource> resources = new ArrayList<org.springframework.core.io.Resource>(list.size());
        for (BatchJob job : list) {
            resources.add(getJobResource(job));
        }
        return resources;
    }

    @Override
    public org.springframework.core.io.Resource getJobResource(BatchJob job) {
        return CapAppContext.getResource(new StringBuffer(config.getProperty("batch.jobsroot", "")).append(job.getJobResource()).toString());
    }

    @Override
    public Page<BatchJob> findJobsPage(SearchSetting search) {
        return batchJobDao.findForPage(search);
    }

    @Override
    public List<BatchJob> listJobs() {
        return batchJobDao.listAll();
    }

    @Override
    public BatchJob findJobById(String jobId) {
        return batchJobDao.findByJobId(jobId);
    }

    @Override
    public void updateJob(BatchJob job) {
        batchJobDao.update(job);
    }

    @Override
    public void insertJob(BatchJob job) {
        batchJobDao.create(job);
    }

    @Override
    public void deleteJob(String jobId) {
        batchJobDao.deleteByJobId(jobId);
    }

    @Override
    public Page<BatchSchedule> findSchPage(SearchSetting search) {
        return batchScheduleDao.findForPage(search);
    }

    @Override
    public List<BatchSchedule> findSchByHostId(List<String> hostIds) {
        return batchScheduleDao.findByHostId(hostIds);
    }

    @Override
    public BatchSchedule findSchById(String schId) {
        return batchScheduleDao.findById(schId);
    }

    @Override
    public void updateSch(BatchSchedule schedule) {
        batchScheduleDao.update(schedule);
    }

    @Override
    public void insertSch(BatchSchedule schedule) {
        batchScheduleDao.create(schedule);
    }

    @Override
    public void deleteSch(String schId) {
        batchScheduleDao.deleteById(schId);
    }

    @Override
    public Page<Map<String, Object>> findExecutionsPage(SearchSetting search) {
        return batchExecutionDao.findExecutionsForPage(search);
    }

    @Override
    public List<Map<String, Object>> findSteps(String executionId) {
        return batchExecutionDao.findStepsById(executionId);
    }

    @Override
    public Map<String, Object> findExecutionDetail(String executionId) {
        return batchExecutionDao.findExecutionDetailById(executionId);
    }

    @Override
    public JobParameters findJobParams(String executionId) {
        return batchExecutionDao.findJobParamsById(executionId);
    }

    @Override
    public void updateExecution(Long executionId, String executor) {
        batchExecutionDao.updateExecution(executionId, executor);
    }

}// ~
