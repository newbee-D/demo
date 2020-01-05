package com.newbee.demo.core.mq.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 *              通用发送虚类，继承即可
 * @date 2019/12/31 13:43
 */
@Slf4j
public abstract class AbstractSender implements RabbitTemplate.ReturnCallback,RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * <p>
     *     失败才会触发
     * </p>
     */
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.warn("消息路由到queue失败，{}",message);
        /* 重新发送 */
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        getRabbitTemplate().convertAndSend(exchange, routingKey, message, correlationId);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息发送成功");
        } else {
            log.info("消息发送到exchange失败,原因:{}",cause);
        }
    }

    /** 公共发送方法 */
    protected void send(Object message) {
        log.info("发送mq：exchange->{},routingKey->{},message->{}", getExchange(), getRouteKey(), JSONObject.toJSONString(message));
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        getRabbitTemplate().convertAndSend(getExchange(), getRouteKey(), message, correlationId);
    }

    public abstract RabbitTemplate getRabbitTemplate();

    public abstract String getExchange();

    public abstract String getRouteKey();
}
