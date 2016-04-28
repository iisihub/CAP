/* 
 * BatchHandler.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.handler;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.quartz.SchedulerException;
import org.springframework.batch.admin.service.JobService;
import org.springframework.batch.admin.web.JobExecutionInfo;
import org.springframework.batch.admin.web.JobInfo;
import org.springframework.batch.admin.web.JobParametersExtractor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.ClassPathXmlApplicationContextFactory;
import org.springframework.batch.core.configuration.support.ReferenceJobFactory;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.batch.core.CapBatchScheduler;
import com.iisigroup.cap.batch.model.BatchJob;
import com.iisigroup.cap.batch.model.BatchSchedule;
import com.iisigroup.cap.batch.service.BatchJobService;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.formatter.ADDateFormatter;
import com.iisigroup.cap.formatter.ADDateTimeFormatter;
import com.iisigroup.cap.formatter.DurationFormatter;
import com.iisigroup.cap.formatter.I18NFormatter;
import com.iisigroup.cap.formatter.BeanFormatter;
import com.iisigroup.cap.formatter.Formatter;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.response.MapGridResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapSystemConfig;

/**
 * <pre>
 * 排程批次處理
 * </pre>
 * 
 * @since 2012/11/5
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/11/5,iristu,new
 *          </ul>
 */
@Controller("batchshandler")
public class BatchHandler extends MFormHandler {

    @Resource
    private CapSystemConfig config;
    @Resource
    private JobRegistry jobRegistry;
    @Resource
    private JobService jobService;
    @Resource
    private BatchJobService batchSrv;
    @Resource
    private CapBatchScheduler capScheduler;

    private JobParametersExtractor jobParametersExtractor = new JobParametersExtractor();

    @SuppressWarnings("serial")
    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult jobQuery(SearchSetting search, IRequest params) {
        if (params.containsKey("jobId")) {
            search.addSearchModeParameters(SearchMode.LIKE, "jobId", params.get("jobId") + "%");
        }
        Page<BatchJob> page = batchSrv.findJobsPage(search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("updateTime", new ADDateFormatter());
        fmt.put("jobStatus", new BeanFormatter() {

            Collection<String> jobs = jobRegistry.getJobNames();

            @SuppressWarnings("unchecked")
            @Override
            public String reformat(Object in) {
                BatchJob job = (BatchJob) in;
                try {
                    checkFileExist(job);
                    if (jobs.contains(job.getJobId())) {
                        return "V";
                    } else {
                        return "";
                    }
                } catch (Exception e) {
                    return "X";
                }
            }
        });
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    /**
     * modify BatchJob
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult jobModify(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        BatchJob job = batchSrv.findJobById(request.get("jobId"));
        boolean isnew = false;
        if (job == null) {
            isnew = true;
            job = new BatchJob();
        }
        String oldResource = job.getJobResource();
        CapBeanUtil.map2Bean(request, job, BatchJob.class);
        checkFileExist(job);
        if (oldResource == null || !oldResource.equals(job.getJobResource())) {
            jobRegistryLoad(job); // 重新註冊
        }
        job.setUpdater(CapSecurityContext.getUserId());
        job.setUpdateTime(CapDate.getCurrentTimestamp());
        if (isnew) {
            batchSrv.insertJob(job);
        } else {
            batchSrv.updateJob(job);
        }
        return result;
    }

    /**
     * delete BatchJob
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult jobDelete(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        BatchJob job = batchSrv.findJobById(request.get("jobId"));
        if (job != null) {
            jobRegistry.unregister(job.getJobId());
            batchSrv.deleteJob(job.getJobId());
        }
        return result;
    }

    /**
     * 重新註冊
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult jobLoad(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        BatchJob job = batchSrv.findJobById(request.get("jobId"));
        if (job != null) {
            jobRegistryLoad(job);
        }
        return result;
    }

    /**
     * 手動執行
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult jobGetParam(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        String jobId = request.get("jobId");
        try {
            String strParams = jobParametersExtractor.fromJobParameters(jobService.getLastJobParameters(jobId));
            result.set("jobParams", strParams);
        } catch (NoSuchJobException e) {
            throw new CapMessageException("msg.job.noSuchJob", getClass());
        }
        return result;
    }

    /**
     * 手動執行
     * 
     * @param request
     *            request
     * @return IResult
     */
    public IResult jobExecute(IRequest request) {
        String params = request.get("jobParams");
        JobParameters jobParameters = jobParametersExtractor.fromString(params);

        BatchJob batchJob = batchSrv.findJobById(request.get("jobId"));
        if (batchJob != null) {
            String jobName = batchJob.getJobId();
            try {
                JobExecution jobExecution = jobService.launch(jobName, jobParameters);
                // new JobExecutionInfo(jobExecution, TimeZone.getDefault());
                batchSrv.updateExecution(jobExecution.getId(), CapSecurityContext.getUserId());
            } catch (NoSuchJobException e) {
                throw new CapMessageException("msg.job.noSuchJob", getClass());
            } catch (JobExecutionAlreadyRunningException e) {
                throw new CapMessageException("msg.job.alreadyRunning", getClass());
            } catch (JobRestartException e) {
                throw new CapMessageException("msg.job.canNotRestart", getClass());
            } catch (JobInstanceAlreadyCompleteException e) {
                throw new CapMessageException("msg.job.alreadyComplete", getClass());
            } catch (JobParametersInvalidException e) {
                throw new CapMessageException("msg.job.parametersInvalid", getClass());
            }
        }
        return new AjaxFormResult();
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public GridResult schQuery(SearchSetting search, IRequest params) {
        if (params.containsKey("schId")) {
            search.addSearchModeParameters(SearchMode.LIKE, "schId", params.get("schId") + "%");
        }
        Page<BatchSchedule> page = batchSrv.findSchPage(search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("updateTime", new ADDateFormatter());
        fmt.put("schType", new I18NFormatter("sch.schType."));
        return new GridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    public IResult schDetail(IRequest params) {
        AjaxFormResult result = new AjaxFormResult();
        BatchSchedule sch = batchSrv.findSchById(params.get("schId"));
        Map<String, Object> map = CapBeanUtil.bean2Map(sch, CapBeanUtil.getFieldName(BatchSchedule.class, false));
        map.put("notifyStatus", MapUtils.getString(map, "notifyStatus", "").split(","));
        result.putAll(map);
        return result;
    }

    /**
     * modify BatchSchedule
     * 
     * @param request
     *            request
     * @return IResult
     * @throws SchedulerException
     */
    public IResult schModify(IRequest request) throws SchedulerException {
        AjaxFormResult result = new AjaxFormResult();
        BatchSchedule oldSch = batchSrv.findSchById(request.get("schId"));
        BatchSchedule newSch = new BatchSchedule();
        boolean isnew = (oldSch == null);
        if (!isnew) {
            CapBeanUtil.copyBean(oldSch, newSch, CapBeanUtil.getFieldName(BatchSchedule.class, true));
        }
        CapBeanUtil.map2Bean(request, newSch, BatchSchedule.class);
        newSch.setNotifyStatus(CapString.array2String(request.getParamsAsStringArray("notifyStatus")));
        if (!"C".equals(newSch.getSchType())) {
            newSch.setCronExpression(null);
            newSch.setTimeZoneId(null);
        } else if (!"T".equals(newSch.getSchType())) {
            newSch.setRepeatCount(0);
            newSch.setRepeatInterval(0);
        }
        if (!newSch.isNotify()) {
            newSch.setNotifyStatus(null);
            newSch.setNotifyTo(null);
        }
        newSch.setUpdater(CapSecurityContext.getUserId());
        newSch.setUpdateTime(CapDate.getCurrentTimestamp());
        if (isnew) {
            batchSrv.insertSch(newSch);
        } else {
            batchSrv.updateSch(newSch);
        }
        capScheduler.reSchedule(oldSch, newSch);
        return result;
    }

    /**
     * delete BatchSchedule
     * 
     * @param request
     *            request
     * @return IResult
     * @throws SchedulerException
     */
    public IResult schDelete(IRequest request) throws SchedulerException {
        AjaxFormResult result = new AjaxFormResult();
        String[] ids = request.getParamsAsStringArray("schId");
        for (String id : ids) {
            BatchSchedule sch = batchSrv.findSchById(id);
            if (sch != null) {
                batchSrv.deleteSch(id);
                capScheduler.deleteSchedule(sch);
            }
        }
        return result;
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult executinsQuery(SearchSetting search, IRequest request) {

        if (!CapString.isEmpty(request.get("jobId"))) {
            search.addSearchModeParameters(SearchMode.LIKE, "i.job_name", request.get("jobId") + "%");
        }
        if (!CapString.isEmpty(request.get("jobExitCode"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "e.exit_code", request.get("jobExitCode"));
        }
        if (!CapString.isEmpty(request.get("jobExeId"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "e.job_execution_id", request.get("jobExeId"));
        }
        if (!CapString.isEmpty(request.get("jobInsId"))) {
            search.addSearchModeParameters(SearchMode.EQUALS, "e.job_instance_id", request.get("jobInsId"));
        }
        Date theDate = new Date();
        String startDate = !CapString.isEmpty(request.get("startDate")) ? request.get("startDate") : CapDate.formatDate(theDate, "yyyy-MM-dd");
        String startTime = !CapString.isEmpty(request.get("startTime")) ? request.get("startTime") : CapDate.formatDate(theDate, "HH:mm");
        search.addSearchModeParameters(SearchMode.GREATER_EQUALS, "e.start_time", new StringBuffer(startDate).append(" ").append(startTime).append(":00.000"));

        Page<Map<String, Object>> page = batchSrv.findExecutionsPage(search);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("startDate", new ADDateFormatter());
        fmt.put("START_TIME", new ADDateTimeFormatter("HH:mm:ss"));
        fmt.put("duration", new DurationFormatter("START_TIME", "END_TIME", "HH:mm:ss.SSS"));
        return new MapGridResult(page.getContent(), page.getTotalRow(), fmt);
    }

    public IResult executionDetail(IRequest request) {
        String executionId = request.get("jobExeId");
        String instancId = request.get("jobInstId");
        Map<String, Object> map = batchSrv.findExecutionDetail(executionId);
        String jobParams = jobParametersExtractor.fromJobParameters(batchSrv.findJobParams(instancId));
        AjaxFormResult result = new AjaxFormResult();
        result.set("jobParams", jobParams);
        result.set("JOB_NAME", (String) map.get("JOB_NAME"));
        result.set("START_TIME", new ADDateTimeFormatter().reformat(map.get("START_TIME")));
        result.set("duration", new DurationFormatter("START_TIME", "END_TIME", "HH:mm:ss.SSS").reformat(map));
        result.set("jobStatus", (String) map.get("STATUS"));
        result.set("EXIT_CODE", (String) map.get("EXIT_CODE"));
        result.set("JOB_EXECUTION_ID", String.valueOf(map.get("JOB_EXECUTION_ID")));
        result.set("exitMessage", (String) map.get("EXIT_MESSAGE"));
        result.set("EXECUTOR", (String) map.get("EXECUTOR"));
        result.set("JOB_INSTANCE_ID", String.valueOf(map.get("JOB_INSTANCE_ID")));
        return result;
    }

    /**
     * 中斷執行
     * 
     * @param request
     *            IRequest
     * @return IResult
     */
    public IResult executionStop(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        long jobExecutionId = Long.parseLong(request.get("jobExeId"));
        try {
            JobExecution jobExecution = jobService.stop(jobExecutionId);
            new JobExecutionInfo(jobExecution, TimeZone.getDefault());
        } catch (NoSuchJobExecutionException e) {
            throw new CapMessageException("msg.job.noSuchJob", getClass());
        } catch (JobExecutionNotRunningException e) {
            JobExecution jobExecution;
            try {
                jobExecution = jobService.getJobExecution(jobExecutionId);
                new JobExecutionInfo(jobExecution, TimeZone.getDefault());
            } catch (NoSuchJobExecutionException e1) {
                e1.getMessage();
            }
            throw new CapMessageException("msg.job.noRunnigJob", getClass()).setExtraInformation(new Object[] { jobExecutionId });
        }
        return result;
    }

    /**
     * 重新啟動
     * 
     * @param request
     *            IRequest
     * @return IResult
     */
    public IResult executionRestart(IRequest request) {
        AjaxFormResult result = new AjaxFormResult();
        try {
            String jobName = request.get("jobId");
            long jobInstanceId = Long.parseLong(request.get("jobInsId"));
            Collection<JobExecution> jobExecutions = jobService.getJobExecutionsForJobInstance(jobName, jobInstanceId);
            new JobInfo(jobName, jobExecutions.size() + 1);
            JobExecution jobExecution = jobExecutions.iterator().next();
            new JobExecutionInfo(jobExecution, TimeZone.getDefault());

            Long jobExecutionId = jobExecution.getId();

            try {

                jobExecution = jobService.restart(jobExecutionId);
                new JobExecutionInfo(jobExecution, TimeZone.getDefault());

            } catch (NoSuchJobExecutionException e) {
                throw new CapMessageException("msg.job.noSuchJob", getClass());
            } catch (JobExecutionAlreadyRunningException e) {
                throw new CapMessageException("msg.job.alreadyRunning", getClass());
            } catch (JobRestartException e) {
                throw new CapMessageException("msg.job.restartExecption", getClass()).setExtraInformation(new Object[] { jobName });
            } catch (JobInstanceAlreadyCompleteException e) {
                throw new CapMessageException("msg.job.alreadyComplete", getClass());
            } catch (JobParametersInvalidException e) {
                throw new CapMessageException("msg.job.parametersInvalid", getClass()).setExtraInformation(new Object[] { jobName });
            }
        } catch (NoSuchJobException e) {
            throw new CapMessageException("msg.job.noSuchJob", getClass());
        }
        return result;
    }

    @HandlerType(HandlerTypeEnum.GRID)
    public MapGridResult stepsQuery(SearchSetting search, IRequest request) {
        String executionId = request.get("jobExeId");
        List<Map<String, Object>> list = batchSrv.findSteps(executionId);
        Map<String, Formatter> fmt = new HashMap<String, Formatter>();
        fmt.put("duration", new DurationFormatter("START_TIME", "END_TIME", "HH:mm:ss.SSS"));
        return new MapGridResult(list, list.size(), fmt);
    }

    private void jobRegistryLoad(BatchJob job) {
        org.springframework.core.io.Resource resource = batchSrv.getJobResource(job);
        ApplicationContext context = createApplicationContextFactory(CapAppContext.getApplicationContext(), resource);
        Job j = context.getBean(job.getJobId(), Job.class);
        jobRegistry.unregister(j.getName());
        try {
            jobRegistry.register(new ReferenceJobFactory(j));
        } catch (DuplicateJobException e) {
            e.getMessage();
        }
    }

    protected ApplicationContext createApplicationContextFactory(ApplicationContext parent, org.springframework.core.io.Resource resource) {
        ClassPathXmlApplicationContextFactory applicationContextFactory = new ClassPathXmlApplicationContextFactory();
        applicationContextFactory.setResource(resource);
        if (parent != null) {
            applicationContextFactory.setApplicationContext(parent);
        }
        return applicationContextFactory.createApplicationContext();
    }

    public final ResourceLoader resourceLoader = new DefaultResourceLoader(getClass().getClassLoader());

    private void checkFileExist(BatchJob job) {
        String location = config.getProperty("batch.jobsroot", "") + job.getJobResource();
        try {
            org.springframework.core.io.Resource f = resourceLoader.getResource(location);
            if (f == null || !f.exists()) {
                throw new CapMessageException("msg.job.fileNotFund", getClass());
            }
        } catch (NullPointerException e) {
            throw new CapMessageException("msg.job.fileNotFund", getClass());
        } catch (CapMessageException me) {
            throw me;
        } catch (Exception e1) {
            throw new CapException(e1, getClass());
        }
    }

}// ~
