package com.newbee.demo.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author djs
 * @description 用户类型枚举
 * @date 2019/9/26 14:49
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    ORDINARY("普通用户"),
    ADMIN("管理员");
    private String desc;
}
