package com.newbee.demo.core.mq.config;

import com.newbee.demo.core.mq.common.MqConstant;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 *          交换机配置
 * @date 2019/12/31 11:31
 */
@Configuration
public class ExchangeConfig {

    @Autowired
    private MqConstant mqConstant;

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(mqConstant.getTestExchange(), true, false);
    }

}
