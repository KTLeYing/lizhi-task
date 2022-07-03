package com.mzl.integralactivity.schedule;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName :   QuartzConfig
 * @Description: 任务调度配置列
 * @Author: mzl
 * @CreateDate: 2022/7/3 10:34
 * @Version: 1.0
 */
@Configuration
public class QuartzConfig {

    /**
     * 注入积分发放调度任务bean
     * @return
     */
    @Bean
    public JobDetail integralIssueJobDetail(){
        //这里传入Job定时任务业务类
        return JobBuilder.newJob(IntegralIssueJob.class).storeDurably().build();
    }

    /**
     * 积分发放任务定时去调用
     * @return
     */
    @Bean
    public Trigger  IntegralIssueTrigger(){
        return TriggerBuilder.newTrigger()
                .withIdentity("积分发放任务","组1")
                //每10分钟秒执行一次(发放积分)
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/10 * * * ?"))
                .forJob(integralIssueJobDetail()) //这个定时任务要执行的是哪个调度器
                .build();
    }

}
