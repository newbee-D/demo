package com.newbee.demo.core.mq.common;

import org.springframework.core.task.TaskExecutor;

import javax.annotation.Resource;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 * 公共消费类
 * @date 2020/1/5 21:01
 */
public class BaseReceiver {

    @Resource
    private TaskExecutor taskExecutor;

    protected void handleMq(Runnable task) {
        taskExecutor.execute(task);
    }

}
