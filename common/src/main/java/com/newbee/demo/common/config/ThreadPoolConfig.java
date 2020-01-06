package com.newbee.demo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/11/3 15:29
 * @description 线程池配置
 *
 * <p>
 *     spring 线程池
 * </p>
 *
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig implements AsyncConfigurer {

    @Autowired
    private ThreadPoolProperties threadPoolProperties;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置线程池核心容量
        executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        // 设置线程池最大容量
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        // 设置任务队列长度
        executor.setQueueCapacity(threadPoolProperties.getQueueSize());
        // 设置线程超时时间
        executor.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());
        // 设置线程名称前缀
        executor.setThreadNamePrefix(threadPoolProperties.getThreadNamePrefix());
        // 设置任务丢弃后的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
