package com.newbee.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author djs
 * @description 启动类
 * @date 2019/9/15 19:55
 */
@SpringBootApplication(scanBasePackages = {"com.newbee.demo.common", "com.newbee.demo.core", "com.newbee.demo.server"})
public class Demo extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Demo.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }
}
