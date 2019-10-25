package com.newbee.demo.core.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 22:06
 * @description 容器启动后执行某些操作
 */
@Slf4j
@Component
public class ContainerInitService implements ApplicationListener<ApplicationStartedEvent> {

    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("容器初始化完毕");
    }
}
