/* 
 * CapBatchScheduler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.support.PropertiesConverter;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.batch.constants.CapBatchConstants;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;

/**
 * <pre>
 * Cap Scheduler
 * 啟動quartz scheduler
 * </pre>
 * 
 * @since 2012/11/12
 * @author iristu
 * @version <ul>
 *          <li>2012/11/12,iristu,new
 *          </ul>
 */
public class CapBatchScheduler implements CapBatchConstants {

    private final Logger logger = LoggerFactory.getLogger(CapBatchScheduler.class);

    private BatchJobService batchService;
    private String hostId = LOCALHOST;
    private Scheduler scheduler;
    private JobLocator jobLocator;
    private JobLauncher jobLauncher;
    private JobParametersIncrementer defaultIncrementer;
    private JobListener globalListener;

    @SuppressWarnings({ "unchecked" })
    public void loadSchedule() throws Exception {
        Set<String> hosts = new HashSet<String>();
        hosts.add(getHostId());
        hosts.add(LOCALHOST);
        List<BatchSchedule> schedules = batchService.findSchByHostId(CollectionUtils.arrayToList(hosts.toArray()));
        Map<JobDetail, List<Trigger>> triggersAndJobs = new LinkedHashMap<JobDetail, List<Trigger>>();
        for (BatchSchedule sch : schedules) {
            if (sch.isEnabled()) {
                Trigger trigger = buildTrigger(sch);
                JobDetail job = buildJobDetail(sch);
                triggersAndJobs.put(job, Arrays.asList(new Trigger[] { trigger }));
            }
        }
        if (globalListener != null) {
            scheduler.getListenerManager().addJobListener(globalListener);
        }
        scheduler.scheduleJobs(triggersAndJobs, true);
        scheduler.start();
    }// ;

    /**
     * 重新排程
     * 
     * @param oldSch
     *            舊排程
     * @param newSch
     *            新排程
     * @throws SchedulerException
     */
    public void reSchedule(BatchSchedule oldSch, BatchSchedule newSch) throws SchedulerException {
        boolean reSch = (oldSch == null);
        if (!reSch) {
            for (String c : SCHEDULE_KEYWORDS) {
                Object o = newSch.get(c);
                if (o != null && !o.equals(oldSch.get(c))) {
                    reSch = true;
                    break;
                }
            }
        }
        if (reSch) {
            TriggerKey triggerKey = TriggerKey.triggerKey(newSch.getSchId());
            if (newSch.isEnabled() && (LOCALHOST.equals(newSch.getExeHost()) || getHostId().equals(newSch.getExeHost()))) {
                Trigger trigger = buildTrigger(newSch);
                if (scheduler.checkExists(triggerKey)) {
                    scheduler.rescheduleJob(triggerKey, trigger);
                } else {
                    scheduler.scheduleJob(buildJobDetail(newSch), trigger);
                }
                logger.debug("reSchedule:" + newSch.toTriggerString());
            } else {
                deleteSchedule(newSch);
            }
        }

    }// ;

    public void deleteSchedule(BatchSchedule sch) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(sch.getSchId());
        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
            logger.debug("deleteSchedule:" + sch.toTriggerString());
        }
    }// ;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Trigger buildTrigger(BatchSchedule sch) {
        TriggerBuilder tirggerBuilder = TriggerBuilder.newTrigger().withIdentity(sch.getSchId()).withPriority(sch.getPriority());
        if ("T".equals(sch.getSchType())) {
            tirggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(sch.getRepeatInterval()).withRepeatCount(sch.getRepeatCount())).startAt(
                    new Date(System.currentTimeMillis() + 60000));

        } else if ("C".equals(sch.getSchType())) {
            tirggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(sch.getCronExpression()).inTimeZone(TimeZone.getTimeZone(sch.getTimeZoneId())));
        }
        return tirggerBuilder.build();
    }// ;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected JobDetail buildJobDetail(BatchSchedule sch) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.putAll((Map) PropertiesConverter.stringToProperties(sch.getJobData()));
        map.put(EXECUTOR, getHostId());
        map.put(JOB_NAME, sch.getJobId());
        map.put("jobLauncher", jobLauncher);
        map.put("jobLocator", jobLocator);
        map.put("batchService", batchService);
        // 放入JobParametersIncrementer要確保不會有重覆的Parameters出現
        map.put("defaultIncrementer", defaultIncrementer);
        JobDetailFactoryBean jobFactory = new JobDetailFactoryBean();
        jobFactory.setName(sch.getSchId());
        jobFactory.setDescription(sch.getSchDesc());
        jobFactory.setJobClass(JobLauncherDetail.class);
        jobFactory.setJobDataAsMap(map);
        jobFactory.afterPropertiesSet();
        return jobFactory.getObject();
    }// ;

    public void setBatchService(BatchJobService batchService) {
        this.batchService = batchService;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getHostId() {
        if (!LOCALHOST.equals(hostId)) {
            synchronized (hostId) {
                try {
                    hostId = InetAddress.getLocalHost().getHostName();
                } catch (UnknownHostException e) {
                    hostId = LOCALHOST;
                }
            }
        }
        return this.hostId;
    }// ;

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setJobLocator(JobLocator jobLocator) {
        this.jobLocator = jobLocator;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setDefaultIncrementer(JobParametersIncrementer defaultIncrementer) {
        this.defaultIncrementer = defaultIncrementer;
    }

    public void setGlobalListener(JobListener globalListener) {
        this.globalListener = globalListener;
    }

}// ~
