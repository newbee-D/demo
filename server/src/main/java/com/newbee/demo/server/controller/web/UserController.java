package com.newbee.demo.server.controller.web;

import com.newbee.demo.common.entity.Result;
import com.newbee.demo.common.utils.BeanCopierUtil;
import com.newbee.demo.common.utils.SpringContextUtil;
import com.newbee.demo.core.dto.UserListSearchDTO;
import com.newbee.demo.core.enums.UserTypeEnum;
import com.newbee.demo.core.handle.UserHandle;
import com.newbee.demo.server.controller.base.BaseController;
import com.newbee.demo.server.param.UserListSearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djs
 * @description 用户控制器
 * @date 2019/9/26 15:28
 */
@RestController
public class UserController extends BaseController {

    @PostMapping("web/user/list")
    public Result userList(@RequestBody UserListSearchParam param) {
        UserListSearchDTO searchDTO = BeanCopierUtil.copy(param, UserListSearchDTO.class);
        //根据用户类型获取对应处理器
        UserHandle userHandle = (UserHandle)SpringContextUtil.getBean(UserTypeEnum.valueOf(searchDTO.getUserType()).getHandleClazz());
        userHandle.userList(searchDTO);
        return success();
    }

}
