package com.iisigroup.cap.batch.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameter.ParameterType;
import org.springframework.batch.core.JobParameters;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.batch.dao.BatchExecutionDao;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.dao.impl.GenericDaoImpl;
import com.iisigroup.cap.model.Page;

@Repository
public class BatchExecutionDaoImpl extends GenericDaoImpl<Object> implements BatchExecutionDao {

    @Override
    public Page<Map<String, Object>> findExecutionsForPage(SearchSetting search) {
        return getNamedJdbcTemplate().queryForPage("JobExecution.findPage", search);
    }

    @Override
    public List<Map<String, Object>> findStepsById(String executionId) {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("jobExecutionId", executionId);
        return getNamedJdbcTemplate().query("stepExecution.findByExId", args);
    }

    @Override
    public Map<String, Object> findExecutionDetailById(String executionId) {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("jobExecutionId", executionId);
        return getNamedJdbcTemplate().queryForMap("jobExecution.findById", args);
    }

    @Override
    public JobParameters findJobParamsById(String executionId) {
        final Map<String, JobParameter> map = new HashMap<String, JobParameter>();
        RowCallbackHandler handler = new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ParameterType type = ParameterType.valueOf(rs.getString("TYPE_CD"));
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
        getNamedJdbcTemplate().query("jobParams.findById", args, handler);
        return new JobParameters(map);
    }

    @Override
    public void updateExecution(Long executionId, String executor) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jobExecutionId", executionId);
        map.put("executor", executor);
        getNamedJdbcTemplate().update("jobExecution.updateById", map);
    }

}
