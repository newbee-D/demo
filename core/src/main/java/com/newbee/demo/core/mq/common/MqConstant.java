package com.newbee.demo.core.mq.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 * @date 2019/12/31 11:32
 */
@Data
@Component
public class MqConstant {
    /**
     * 基本配置
     */
    @Value("${rabbitmq.host}")
    public String host;

    @Value("${rabbitmq.port}")
    public String post;

    @Value("${rabbitmq.username}")
    public String userName;

    @Value("${rabbitmq.password}")
    public String password;

    @Value("${rabbitmq.virtual.host}")
    public String virtualHost;

    /**
     * 交换机
     */
    @Value("${test.rabbitmq.exchange}")
    public String testExchange;

    /**
     * test
     */
    /* 路由规则 */
    @Value("${test.route.key}")
    public String testRouteKey;
    /* 队列名称 */
    @Value("${test.queue}")
    public String testQueue;


}
