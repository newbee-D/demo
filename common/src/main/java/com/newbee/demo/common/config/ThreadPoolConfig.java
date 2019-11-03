package com.newbee.demo.common.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/11/3 15:29
 * @description 线程池配置
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig implements AsyncConfigurer {

    @Autowired
    private ThreadPoolProperties threadPoolProperties;

    @Bean
    public Executor taskExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadPoolProperties.getThreadNamePrefix()).build();
        return new ThreadPoolExecutor(
                threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaxPoolSize(),
                threadPoolProperties.getKeepAliveSeconds(), TimeUnit.SECONDS,
                threadPoolProperties.getLinkedBlockingDeque(),threadFactory);
    }

}
