package com.newbee.demo.core.mq.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author dingjiasheng@sinoiov.com
 * @description no time so no fix
 *              测试消息报文
 * @date 2019/12/26 15:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestMessage {

    /** 内容1 */
    private String textOne;

    /** 内容2 */
    private String textTwo;

    /** 消息发送时间 */
    private Date sendTime;

    /** 扩展字段 */
    private String extra;

}
