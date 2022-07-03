package com.mzl.integralactivity.schedule;

import com.mzl.integralapi.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName :   IntegralIssueJob
 * @Description: 积分发放定时任务，具体的任务业务逻辑
 * @Author: mzl
 * @CreateDate: 2022/7/3 10:36
 * @Version: 1.0
 */
@Slf4j
@Component
public class IntegralIssueJob implements Job {

    @Autowired
    private ActivityService activityService;

    /**
     * 具体额定时任务的业务逻辑
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //定时进行积分发放
        log.info( "执行了定时进行积分发放..." );
        activityService.issueIntegral();
    }

}
