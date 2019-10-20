package com.newbee.demo.core.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:44
 */
@Data
public class UserListSearchDTO {
    private String userType;
    private String userName;
    private String mobile;
    private Date startCreateTime;
    private Date endCreate;
}
