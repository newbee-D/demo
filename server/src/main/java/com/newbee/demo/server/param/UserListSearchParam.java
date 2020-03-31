package com.newbee.demo.server.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:33
 * @description 用户列表获取入参
 */
@Data
public class UserListSearchParam {
    /**
     * 用户类型
     */
    @NotBlank(message = "用户类型不能为空")
    private String userType;

    /**
     * 名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 创建时间-起
     */
    private Date startCreateTime;

    /**
     * 创建时间止
     */
    private Date endCreate;
}
