package com.newbee.demo.common.exception;

import com.newbee.demo.common.exception.base.BaseException;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 19:18
 */
public class ProjectException extends BaseException {

    /**
     * 默认业务异常
     * @param errorCode 错误码
     * @param errorMsg 错误消息
     */
    public ProjectException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }


    public ProjectException(ErrorCodeEnum errorCode) {
        this(errorCode.getErrorCode(), errorCode.getErrorMsg());
    }

    public ProjectException(ErrorCodeEnum errorCode, String... extend) {
        this(errorCode.getErrorCode(), errorCode.getErrorMsg(), extend);
    }

    public ProjectException(String errorCode, String errorMsg, String... extend) {
        super(errorCode, MessageFormatter.arrayFormat(errorMsg, extend).getMessage());
    }
}
