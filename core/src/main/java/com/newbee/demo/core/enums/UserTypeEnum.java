package com.newbee.demo.core.enums;

import com.newbee.demo.core.dto.UserListDTO;
import com.newbee.demo.core.dto.UserListSearchDTO;
import com.newbee.demo.core.handle.extend.AdminHandle;
import com.newbee.demo.core.handle.extend.OrdinaryHandle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @author djs
 * @description 用户类型枚举
 * @date 2019/9/26 14:49
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    ORDINARY((content, searchDTO) -> content.getBean(OrdinaryHandle.class).userList(searchDTO), "普通用户"),
    ADMIN((content, searchDTO) -> content.getBean(AdminHandle.class).userList(searchDTO),"管理员");

    private BiFunction<ApplicationContext, UserListSearchDTO, List<UserListDTO>> handle;
    private String desc;
}
