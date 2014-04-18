package com.iisigroup.cap.batch.dao;

import java.util.List;

import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

public interface BatchScheduleDao extends IGenericDao<BatchSchedule> {
	Page<BatchSchedule> findForPage(ISearch search);

	List<BatchSchedule> findByHostId(List<String> hostIds);

	BatchSchedule findById(String id);

	void update(BatchSchedule schedule);

	void create(BatchSchedule schedule);

	void deleteById(String id);
}
