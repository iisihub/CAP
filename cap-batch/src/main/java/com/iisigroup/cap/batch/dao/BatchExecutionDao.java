package com.iisigroup.cap.batch.dao;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobParameters;

import com.iisigroup.cap.dao.GenericDao;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.model.Page;

public interface BatchExecutionDao extends GenericDao<Object> {
    Page<Map<String, Object>> findExecutionsForPage(SearchSetting search);

    List<Map<String, Object>> findStepsById(String executionId);

    Map<String, Object> findExecutionDetailById(String executionId);

    JobParameters findJobParamsById(String executionId);

    void updateExecution(Long executionId, String executor);
}
