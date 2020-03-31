package com.newbee.demo.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 19:29
 * @description 通用返回参数
 */
@Data
public class Result<T> {

    /**
     * 状态
     */
    private Result.Status status;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误内容
     */
    private String errorMsg;

    /**
     * 错误内容
     */
    private T content;

    public Result() {
        this.status = Status.SUCCESS;
    }

    public Result(T content) {
        this.status = Status.SUCCESS;
        this.content = content;
        ;
    }

    public Result(String errorCode, String errorMsg, Result.Status status) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.status = status;
    }

    public static Result error(String errorCode, String errorMsg) {
        return new Result(errorCode, errorMsg, Status.ERROR);
    }

    public Result success() {
        return new Result();
    }

    public Result success(T content) {
        return new Result(content);
    }

    /**
     * 状态枚举
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static enum Status {
        SUCCESS("成功"),
        ERROR("失败");
        private String desc;
    }
}
