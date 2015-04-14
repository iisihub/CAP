/* 
 * BatchJobRowMapper.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iisigroup.cap.batch.model.BatchJob;

/**
 * <pre>
 * Job RowMapper
 * </pre>
 * 
 * @since 2012/11/8
 * @author iristu
 * @version <ul>
 *          <li>2012/11/8,iristu,new
 *          </ul>
 */
public class BatchJobRowMapper implements RowMapper<BatchJob> {

    @Override
    public BatchJob mapRow(ResultSet rs, int rowNum) throws SQLException {
        BatchJob job = new BatchJob();
        job.setJobId(rs.getString("JOBID"));
        job.setJobDesc(rs.getString("JOBDESC"));
        job.setJobResource(rs.getString("JOBRESOURCE"));
        job.setUpdater(rs.getString("UPDATER"));
        job.setUpdateTime(rs.getTimestamp("UPDATETIME"));
        return job;
    }

}
