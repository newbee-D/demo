package com.newbee.demo.core.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dingjiasheng@sinoiov.com
 * @description hello world
 * @date 2020/2/10 18:16
 */
@Slf4j
public class Match {
    public static void main(String[] args) {
        String s = "qq12d45g";
        String s1 = "/[0-9]+/";
        if (s.matches(s1)) {
            log.info("a");
        }
    }
}
