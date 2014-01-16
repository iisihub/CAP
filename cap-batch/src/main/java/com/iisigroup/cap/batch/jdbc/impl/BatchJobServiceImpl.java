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
package com.iisigroup.cap.batch.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameter.ParameterType;
import org.springframework.batch.core.JobParameters;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;
import com.iisigroup.cap.batch.support.BatchJobRowMapper;
import com.iisigroup.cap.batch.support.BatchScheduleRowMapper;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.jdbc.CapNamedJdbcTemplate;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapSystemConfig;

/**
 * <pre>
 * 排程批次處理
 * </pre>
 * 
 * @since 2012/11/6
 * @author iristu
 * @version <ul>
 *          <li>2012/11/6,iristu,new
 *          </ul>
 */
public class BatchJobServiceImpl implements BatchJobService {

	private CapNamedJdbcTemplate jdbc;

	@Resource
	private CapSystemConfig config;

	public void setJdbc(CapNamedJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.batch.service.BatchJobService#listJobResources()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<org.springframework.core.io.Resource> listJobResources() {
		List<BatchJob> list = jdbc.query("batchJob.findPage", null,
				MapUtils.EMPTY_MAP, new BatchJobRowMapper());
		List<org.springframework.core.io.Resource> resources = new ArrayList<org.springframework.core.io.Resource>(
				list.size());
		for (BatchJob job : list) {
			resources.add(getJobResource(job));
		}
		return resources;
	}// ;

	@Override
	public org.springframework.core.io.Resource getJobResource(BatchJob job) {
		return CapAppContext.getResource(new StringBuffer(config.getProperty(
				"batch.jobsroot", "")).append(job.getJobResource()).toString());
	}

	@Override
	public Page<BatchJob> findJobsPage(ISearch search) {
		return jdbc.queryForPage("batchJob.findPage", search,
				new BatchJobRowMapper());
	}

	@Override
	public List<BatchJob> listJobs() {
		return jdbc.query("batchJob.findPage", null, null,
				new BatchJobRowMapper());
	}

	@Override
	public BatchJob findJobById(String jobId) {
		Map<String, Object> job = new HashMap<String, Object>();
		job.put("jobId", jobId);
		return jdbc.queryForObject("batchJob.findById", job,
				new BatchJobRowMapper());
	}

	@Override
	public void updateJob(BatchJob job) {
		Map<String, Object> args = CapBeanUtil.bean2Map(job,
				CapBeanUtil.getFieldName(BatchJob.class, true));
		jdbc.update("batchJob.update", args);
	}

	@Override
	public void insertJob(BatchJob job) {
		Map<String, Object> args = CapBeanUtil.bean2Map(job,
				CapBeanUtil.getFieldName(BatchJob.class, true));
		jdbc.update("batchJob.insert", args);
	}

	@Override
	public void deleteJob(String jobId) {
		Map<String, Object> job = new HashMap<String, Object>();
		job.put("jobId", jobId);
		jdbc.update("batchJob.delete", job);
		jdbc.update("batchSch.deleteByJob", job);
	}

	@Override
	public Page<BatchSchedule> findSchPage(ISearch search) {
		return jdbc.queryForPage("batchSch.findPage", search,
				new BatchScheduleRowMapper());
	}

	@Override
	public List<BatchSchedule> findSchByHostId(List<String> hostIds) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("hostIds", hostIds);
		return jdbc.query("batchSch.findByHost", null, args,
				new BatchScheduleRowMapper());
	}

	@Override
	public BatchSchedule findSchById(String schId) {
		Map<String, Object> sch = new HashMap<String, Object>();
		sch.put("schId", schId);
		return jdbc.queryForObject("batchSch.findById", sch,
				new BatchScheduleRowMapper());
	}

	@Override
	public void updateSch(BatchSchedule schedule) {
		Map<String, Object> args = CapBeanUtil.bean2Map(schedule,
				CapBeanUtil.getFieldName(BatchSchedule.class, true));
		jdbc.update("batchSch.update", args);
	}

	@Override
	public void insertSch(BatchSchedule schedule) {
		Map<String, Object> args = CapBeanUtil.bean2Map(schedule,
				CapBeanUtil.getFieldName(BatchSchedule.class, true));
		jdbc.update("batchSch.insert", args);
	}

	@Override
	public void deleteSch(String schId) {
		Map<String, Object> sch = new HashMap<String, Object>();
		sch.put("schId", schId);
		jdbc.update("batchSch.delete", sch);
	}

	@Override
	public Page<Map<String, Object>> findExecutionsPage(ISearch search) {
		return jdbc.queryForPage("JobExecution.findPage", search);
	}// ;

	@Override
	public List<Map<String, Object>> findSteps(String executionId) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("jobExecutionId", executionId);
		return jdbc.query("stepExecution.findByExId", args);
	}// ;

	@Override
	public Map<String, Object> findExecutionDetail(String executionId) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("jobExecutionId", executionId);
		return jdbc.queryForMap("jobExecution.findById", args);
	}

	@Override
	public JobParameters findJobParams(String executionId) {
		final Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		RowCallbackHandler handler = new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ParameterType type = ParameterType.valueOf(rs
						.getString("TYPE_CD"));
				JobParameter value = null;
				if (type == ParameterType.STRING) {
					value = new JobParameter(rs.getString("STRING_VAL"));
				} else if (type == ParameterType.LONG) {
					value = new JobParameter(rs.getLong("LONG_VAL"));
				} else if (type == ParameterType.DOUBLE) {
					value = new JobParameter(rs.getDouble("DOUBLE_VAL"));
				} else if (type == ParameterType.DATE) {
					value = new JobParameter(rs.getTimestamp("DATE_VAL"));
				}
				map.put(rs.getString("KEY_NAME"), value);
			}
		};
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("jobExecutionId", executionId);
		jdbc.query("jobParams.findById", args, handler);
		return new JobParameters(map);
	}// ;

	@Override
	public void updateExecution(Long executionId, String executor) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobExecutionId", executionId);
		map.put("executor", executor);
		jdbc.update("jobExecution.updateById", map);
	}

}// ~
