package com.newbee.demo.core.mq.config;

import com.newbee.demo.core.mq.common.MqConstant;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 * mq 配置
 * @date 2019/12/31 11:18
 */
@Configuration
public class RabbitMqConfig {

    @Autowired
    private QueueConfig queueConfig;
    @Autowired
    private MqConstant mqConstant;
    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * mq绑定
     */
    @Bean
    public Binding bindingTest() {
        return BindingBuilder.bind(queueConfig.projectCodeQueue()).to(exchangeConfig.orderExchange()).with(mqConstant.getTestRouteKey());
    }

    /**
     * 连接工厂
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(mqConstant.getHost());
        connectionFactory.setAddresses(mqConstant.getHost());
        connectionFactory.setUsername(mqConstant.getUserName());
        connectionFactory.setPassword(mqConstant.getPassword());
        connectionFactory.setVirtualHost(mqConstant.getVirtualHost());
        connectionFactory.setPublisherConfirms(true); // 消息发送到交换机确认
        connectionFactory.setPublisherReturns(true); // 消息路由到队列确认回调（失败才会触发）
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainerOne() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory());
        // 最大并发
        simpleMessageListenerContainer.setMaxConcurrentConsumers(6);
        // 消费线程
        simpleMessageListenerContainer.setConcurrentConsumers(3);
        // 自动ACK
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return simpleMessageListenerContainer;
    }


}
