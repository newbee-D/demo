package com.newbee.demo.server.param;

import lombok.Data;

import java.util.Date;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:33
 * @description 用户列表获取入参
 */
@Data
public class UserListSearchParam {
    private String userType;
    private String userName;
    private String mobile;
    private Date startCreateTime;
    private Date endCreate;
}
