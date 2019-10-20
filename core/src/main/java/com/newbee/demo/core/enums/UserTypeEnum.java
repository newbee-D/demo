package com.newbee.demo.core.enums;

import com.newbee.demo.core.handle.extend.AdminHandle;
import com.newbee.demo.core.handle.extend.OrdinaryHandle;
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
    ORDINARY("普通用户", OrdinaryHandle.class),
    ADMIN("管理员", AdminHandle.class);
    private String desc;
    private Class handleClazz; //处理器
}
