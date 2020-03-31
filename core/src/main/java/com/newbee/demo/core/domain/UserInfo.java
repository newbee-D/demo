package com.newbee.demo.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_info")
public class UserInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;    // PRIMARY KEY
    @TableField("user_id")
    private String userId;    //用户id
    @TableField("user_type")
    private String userType;    //用户类型-ORDINARY：普通用户，ADMIN管理员
    @TableField("create_time")
    private Date createTime;    //创建时间
    @TableField("create_user_id")
    private String createUserId;    //创建人id
    @TableField("update_time")
    private Date updateTime;    //更新时间
    @TableField("user_name")
    private String userName;    //用户名
    @TableField("mobile")
    private String mobile;    //手机号
    @TableField("age")
    private Integer age;    //年龄
    @TableField("address")
    private String address;    //详细地址
    @TableField("user_province")
    private String userProvince;    //省
    @TableField("user_city")
    private String userCity;    //市
    @TableField("user_country")
    private String userCountry;    //区
    @TableField("deleted")
    private Integer deleted;    //是否删除 0-true，1-false

}
