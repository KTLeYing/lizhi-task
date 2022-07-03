package com.mzl.integralactivity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName :   ExecutorConfig
 * @Description: 线程池的配置
 * @Author: mzl
 * @CreateDate: 2022/7/3 17:17
 * @Version: 1.0
 */
@EnableAsync
@Configuration
@Slf4j
public class ExecutorConfig {

    @Value("${async.executor.corePoolSize}")
    private int corePoolSize;
    @Value("${async.executor.maxPoolSize}")
    private int maxPoolSize;
    @Value("${async.executor.queueCapacity}")
    private int queueCapacity;
    @Value("${async.executor.prefixName}")
    private String prefixName;

    @Bean(name = "issueIntegralExecutor")
    public Executor asyncServiceExecutor() {
        log.info("线程池的配置----->start asyncServiceExecutor...");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(prefixName);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

}
