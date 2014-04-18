package com.iisigroup.cap.batch.dao;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobParameters;

import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

public interface BatchExecutionDao extends IGenericDao<Object> {
	Page<Map<String, Object>> findExecutionsForPage(ISearch search);
	
	List<Map<String, Object>> findStepsById(String executionId);
	
	Map<String, Object> findExecutionDetailById(String executionId);
	
	JobParameters findJobParamsById(String executionId);
	
	void updateExecution(Long executionId, String executor);
}
