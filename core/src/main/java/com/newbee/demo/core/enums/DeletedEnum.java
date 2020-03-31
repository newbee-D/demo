package com.newbee.demo.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author djs
 * @description 是否删除
 * @date 2019/9/26 14:51
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum {
    YES(1, "已删除"),
    NO(0, "未删除");

    private int code;
    private String desc;
}
