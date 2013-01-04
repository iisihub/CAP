/* 
 * BatchScheduleRowMapper.java
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

import com.iisigroup.cap.batch.model.BatchSchedule;

/**<pre>
 * 排程設定檔 RowMapper
 * </pre>
 * @since  2012/11/12
 * @author iristu
 * @version <ul>
 *           <li>2012/11/12,iristu,new
 *          </ul>
 */
public class BatchScheduleRowMapper implements RowMapper<BatchSchedule> {

	@Override
	public BatchSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		BatchSchedule sch = new BatchSchedule();
		sch.setSchId(rs.getString("SCHID"));
		sch.setSchDesc(rs.getString("SCHDESC"));
		sch.setIsEnabled(rs.getString("ISENABLED"));
		sch.setJobId(rs.getString("JOBID"));
		sch.setSchType(rs.getString("SCHTYPE"));
		sch.setCronExpression(rs.getString("CRONEXPRESSION"));
		sch.setTimeZoneId(rs.getString("TIMEZONEID"));
		sch.setRepeatCount(rs.getInt("REPEATCOUNT"));
		sch.setRepeatInterval(rs.getInt("REPEATINTERVAL"));
		sch.setPriority(rs.getInt("PRIORITY"));
		sch.setExeHost(rs.getString("EXEHOST"));
		sch.setJobData(rs.getString("JOBDATA"));
		sch.setIsNotify(rs.getString("ISNOTIFY"));
		sch.setNotifyStatus(rs.getString("NOTIFYSTATUS"));
		sch.setNotifyTo(rs.getString("NOTIFYTO"));
		sch.setUpdater(rs.getString("UPDATER"));
		sch.setUpdateTime(rs.getTimestamp("UPDATETIME"));
		return sch;
	}

}
