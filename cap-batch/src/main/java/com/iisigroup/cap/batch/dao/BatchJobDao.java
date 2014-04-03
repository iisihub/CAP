package com.iisigroup.cap.batch.dao;

import java.util.List;

import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

public interface BatchJobDao extends IGenericDao<BatchJob> {
	List<BatchJob> listAll();

	Page<BatchJob> findForPage(ISearch search);

	BatchJob findByJobId(String jobId);

	void update(BatchJob job);

	void create(BatchJob job);

	void deleteByJobId(String jobId);
}
