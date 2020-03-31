package com.newbee.demo.server;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dingjiasheng@sinoiov.com
 * @description hello world
 * @date 2020/3/4 15:07
 */
public class RandomTest extends BaseTest {

    @Test
    public void test() throws Exception {
        ThreadLocalRandom.current().nextInt(3, 4);
    }

}
