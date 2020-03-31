package com.newbee.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@PropertySource(value = {"classpath:application-test.properties"})
@Slf4j
public class BaseTest {
    @Autowired
    private MockMvc mockMvc;
}
