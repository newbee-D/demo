package com.newbee.demo.common.exception.handle;

import com.newbee.demo.common.entity.Result;
import com.newbee.demo.common.exception.ErrorCodeEnum;
import com.newbee.demo.common.exception.ProjectException;
import com.newbee.demo.common.exception.base.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 19:24
 * @description 异常处理器，拦截全局异常
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        log.info("系统异常 --> {}", e.getMessage(), e);
        return Result.error(ErrorCodeEnum.SYSTEM_ERROR.getErrorCode(),ErrorCodeEnum.SYSTEM_ERROR.getErrorMsg());
    }
    @ExceptionHandler(value = ProjectException.class)
    @ResponseBody
    public Result handler(ProjectException e) {
        log.info("ProjectException --> {}", e.getErrorMsg(), e);
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Result handleBaseException(BaseException e) {
        log.info("业务异常: {}", e.getErrorCode(), e);
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }
}
