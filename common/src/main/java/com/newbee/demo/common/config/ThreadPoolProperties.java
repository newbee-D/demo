package com.newbee.demo.common.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/11/3 15:29
 * @description 线程池参数
 */
@Data
@Component
public class ThreadPoolProperties {
    /**
     * 核心线程数
     * IO密集型 = CPU核数 * 2
     * 计算密集型 = CPU核数 + 1
     */
    private int corePoolSize = 10;
    /**
     * 最大线程数
     */
    private int maxPoolSize = 20;
    /**
     * 空闲线程存活时间(秒)
     */
    private int keepAliveSeconds = 10;
    /**
     * 线程队列大小
     */
    private int queueSize = 2000;
    /**
     * 线程名前缀
     */
    private String threadNamePrefix = "DemoThread-";
    /**
     * 使用何种线程等待队列
     */
    private LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>(queueSize);
}
