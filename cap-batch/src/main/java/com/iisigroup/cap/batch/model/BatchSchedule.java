/* 
 * BatchSchedule.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.model;

import java.sql.Timestamp;

import com.iisigroup.cap.batch.constants.CapBatchConstants;
import com.iisigroup.cap.model.GenericBean;

/**
 * <pre>
 * 排程設定檔
 * </pre>
 * 
 * @since 2012/11/12
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/11/12,iristu,new
 *          </ul>
 */
public class BatchSchedule extends GenericBean {

    /** Schedule ID */
    private String schId;
    /** 排程說明 */
    private String schDesc;
    private String jobId;
    /** 類別 C:Cron T:Trigger */
    private String schType;
    /** 是否啟用(Y/N) */
    private String isEnabled;
    /** 執行週期 */
    private String cronExpression;
    /** 時區代碼 */
    private String timeZoneId;
    /** 重覆次數 */
    private int repeatCount;
    /** 重覆時間區間 */
    private int repeatInterval;
    /** 優先順序 */
    private int priority;
    /** 執行主機 */
    private String exeHost;
    /** jobMapData參數 */
    private String jobData;
    /** 是否mail通知(Y/N) */
    private String isNotify;
    /** 執行狀態通知 */
    private String notifyStatus;
    /** mail收件人 */
    private String notifyTo;
    /** 修改人 */
    private String updater;
    /** 修改時間 */
    private Timestamp updateTime;

    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId;
    }

    public String getSchDesc() {
        return schDesc;
    }

    public void setSchDesc(String schDesc) {
        this.schDesc = schDesc;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getSchType() {
        return schType;
    }

    public void setSchType(String schType) {
        this.schType = schType;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(int repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getExeHost() {
        return exeHost;
    }

    public void setExeHost(String exeHost) {
        this.exeHost = exeHost;
    }

    public String getJobData() {
        return jobData;
    }

    public void setJobData(String jobData) {
        this.jobData = jobData;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public boolean isEnabled() {
        return "Y".equals(isEnabled);
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsNotify() {
        return isNotify;
    }

    public boolean isNotify() {
        return "Y".equals(isNotify);
    }

    public void setIsNotify(String isNotify) {
        this.isNotify = isNotify;
    }

    public String getNotifyStatus() {
        return notifyStatus;
    }

    public void setNotifyStatus(String notifyStatus) {
        this.notifyStatus = notifyStatus;
    }

    public String getNotifyTo() {
        return notifyTo;
    }

    public void setNotifyTo(String notifyTo) {
        this.notifyTo = notifyTo;
    }

    public String toTriggerString() {
        StringBuffer sb = new StringBuffer();
        sb.append("schId=").append(schId).append(',');
        for (String c : CapBatchConstants.SCHEDULE_KEYWORDS) {
            sb.append(c).append('=').append(get(c)).append(',');
        }
        return sb.toString();
    }

}
