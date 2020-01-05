package com.newbee.demo.core.mq.sender;

import com.alibaba.fastjson.JSON;
import com.newbee.demo.core.mq.common.AbstractSender;
import com.newbee.demo.core.mq.common.MqConstant;
import com.newbee.demo.core.mq.message.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 *              mq发送测试test
 * @date 2019/12/31 14:33
 */
@Slf4j
@Component
public class TestSender extends AbstractSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MqConstant mqConstant;

    /* 测试 */
    public void sendTest(TestMessage message) {
        send(JSON.toJSONString(message));
    }

    @Override
    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    @Override
    public String getExchange() {
        return mqConstant.getTestExchange();
    }

    @Override
    public String getRouteKey() {
        return mqConstant.getTestRouteKey();
    }
}
