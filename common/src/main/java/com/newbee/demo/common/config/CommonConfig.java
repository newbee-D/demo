package com.newbee.demo.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description 统一配置
 * @Author liupeng@sinoiov.com
 * @Date 2019/10/23 11:29
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement
@MapperScan("com.newbee.demo.core.dao")
public class CommonConfig {

    /**
     * mybatis分页拦截器
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
