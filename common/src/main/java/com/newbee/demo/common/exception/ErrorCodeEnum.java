package com.newbee.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 19:08
 * @description 异常代码枚举
 *
 * 错误代码段10
 * <p>
 * 分配策略
 * 1.公共异常 10(0)xxx
 * 2.第三方异常 10(1)xxx
 * </p>
 *
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCodeEnum {
    /**系统异常**/
    SYSTEM_ERROR("100001","系统异常，请稍后重试"),
    BUSINESS_FREQUENT_ERROR("100002","请求过于频繁，请稍后重试");

    private String errorCode;
    private String errorMsg;
}
