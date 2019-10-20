package com.newbee.demo.common.exception.base;

import lombok.Data;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 19:21
 */
@Data
public class BaseException extends RuntimeException {

    private String errorCode;

    private String errorMsg;

    public BaseException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
