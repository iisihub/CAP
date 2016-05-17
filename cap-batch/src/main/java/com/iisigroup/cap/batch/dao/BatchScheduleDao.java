package com.iisigroup.cap.batch.dao;

import java.util.List;

import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.db.dao.GenericDao;
import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;

public interface BatchScheduleDao extends GenericDao<BatchSchedule> {
    Page<BatchSchedule> findForPage(SearchSetting search);

    List<BatchSchedule> findByHostId(List<String> hostIds);

    BatchSchedule findById(String id);

    void update(BatchSchedule schedule);

    void create(BatchSchedule schedule);

    void deleteById(String id);
}
