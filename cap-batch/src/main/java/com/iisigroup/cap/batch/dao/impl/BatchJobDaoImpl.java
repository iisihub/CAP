package com.iisigroup.cap.batch.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.batch.dao.BatchJobDao;
import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.batch.support.BatchJobRowMapper;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.CapBeanUtil;

@Repository
public class BatchJobDaoImpl extends GenericDao<BatchJob> implements
		BatchJobDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BatchJob> listAll() {
		return getNamedJdbcTemplate().query("batchJob.findPage", null,
				MapUtils.EMPTY_MAP, new BatchJobRowMapper());
	}

	@Override
	public Page<BatchJob> findForPage(ISearch search) {
		return getNamedJdbcTemplate().queryForPage("batchJob.findPage", search,
				new BatchJobRowMapper());
	}

	@Override
	public BatchJob findByJobId(String jobId) {
		Map<String, Object> job = new HashMap<String, Object>();
		job.put("jobId", jobId);
		return getNamedJdbcTemplate().queryForObject("batchJob.findById", job,
				new BatchJobRowMapper());
	}

	@Override
	public void update(BatchJob job) {
		Map<String, Object> args = CapBeanUtil.bean2Map(job,
				CapBeanUtil.getFieldName(BatchJob.class, true));
		getNamedJdbcTemplate().update("batchJob.update", args);
	}

	@Override
	public void create(BatchJob job) {
		Map<String, Object> args = CapBeanUtil.bean2Map(job,
				CapBeanUtil.getFieldName(BatchJob.class, true));
		getNamedJdbcTemplate().update("batchJob.insert", args);
	}

	@Override
	public void deleteByJobId(String jobId) {
		Map<String, Object> job = new HashMap<String, Object>();
		job.put("jobId", jobId);
		getNamedJdbcTemplate().update("batchJob.delete", job);
		getNamedJdbcTemplate().update("batchSch.deleteByJob", job);
	}
}
