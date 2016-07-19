package com.iisigroup.cap.batch.dao;

import java.util.List;

import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.db.dao.GenericDao;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;

public interface BatchJobDao extends GenericDao<BatchJob> {
    List<BatchJob> listAll();

    Page<BatchJob> findForPage(SearchSetting search);

    BatchJob findByJobId(String jobId);

    void update(BatchJob job);

    void create(BatchJob job);

    void deleteByJobId(String jobId);
}
