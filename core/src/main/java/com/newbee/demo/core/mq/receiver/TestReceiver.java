package com.newbee.demo.core.mq.receiver;

import com.newbee.demo.core.mq.common.BaseReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 * 消息接受
 * @date 2019/12/31 13:20
 */
@Slf4j
@Component
public class TestReceiver extends BaseReceiver {

    @Resource
    private TaskExecutor taskExecutor;

    @RabbitHandler
    @RabbitListener(queues = "${test.queue}")
    public void receiveMessage(final String message) {
        log.info("【订单所属项目变更mq】收到mq，内容：{}", message);
        /* 异步消费 */
        handleMq(new Runnable() {
            @Override
            public void run() {
                try {
                    // todo do someThing
                } catch (Exception e) {
                    log.error("【订单所属项目变更mq】订单所属项目变更mq处理失败", e);
                    //TODO 邮件告警通知消费失败 || 手动ack告知发送者消费失败
                }
            }
        });

    }


}
