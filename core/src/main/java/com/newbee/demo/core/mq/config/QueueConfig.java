package com.newbee.demo.core.mq.config;

import com.newbee.demo.core.mq.common.MqConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 * mq队列配置
 * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
 * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
 * exclusive  表示该消息队列是否只在当前connection生效,默认是false
 * @date 2019/12/31 11:40
 */
@Configuration
public class QueueConfig {

    @Autowired
    private MqConstant mqConstant;

    @Bean
    public Queue projectCodeQueue() {
        return new Queue(mqConstant.getTestQueue(), true);
    }

}
