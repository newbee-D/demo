package com.newbee.demo.server;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author dingjiasheng@sinoiov.com
 * @description hello world
 * @date 2020/2/27 17:02
 */
public class TimeTest extends BaseTest {

    @Test
    public void dateTimeFormatterTest() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:nn");
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        formatter.format(dateTime);
        formatter.format(zonedDateTime);

    }

}
