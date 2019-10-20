package com.newbee.demo.server.controller.base;

import com.newbee.demo.common.entity.Result;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:48
 */
public class BaseController {
    public Result success() {
        return new Result();
    }

    public Result success(Object content) {
        return new Result(content);
    }
}
