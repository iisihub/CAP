package com.iisigroup.cap.batch.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.batch.dao.BatchScheduleDao;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.support.BatchScheduleRowMapper;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.CapBeanUtil;

@Repository
public class BatchScheduleDaoImpl extends GenericDao<BatchSchedule> implements
		BatchScheduleDao {

	@Override
	public Page<BatchSchedule> findForPage(ISearch search) {
		return getNamedJdbcTemplate().queryForPage("batchSch.findPage", search,
				new BatchScheduleRowMapper());
	}

	@Override
	public List<BatchSchedule> findByHostId(List<String> hostIds) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("hostIds", hostIds);
		return getNamedJdbcTemplate().query("batchSch.findByHost", null, args,
				new BatchScheduleRowMapper());
	}

	@Override
	public BatchSchedule findById(String id) {
		Map<String, Object> sch = new HashMap<String, Object>();
		sch.put("schId", id);
		return getNamedJdbcTemplate().queryForObject("batchSch.findById", sch,
				new BatchScheduleRowMapper());
	}

	@Override
	public void update(BatchSchedule schedule) {
		Map<String, Object> args = CapBeanUtil.bean2Map(schedule,
				CapBeanUtil.getFieldName(BatchSchedule.class, true));
		getNamedJdbcTemplate().update("batchSch.update", args);
	}

	@Override
	public void create(BatchSchedule schedule) {
		Map<String, Object> args = CapBeanUtil.bean2Map(schedule,
				CapBeanUtil.getFieldName(BatchSchedule.class, true));
		getNamedJdbcTemplate().update("batchSch.insert", args);
	}

	@Override
	public void deleteById(String id) {
		Map<String, Object> sch = new HashMap<String, Object>();
		sch.put("schId", id);
		getNamedJdbcTemplate().update("batchSch.delete", sch);
	}
}
