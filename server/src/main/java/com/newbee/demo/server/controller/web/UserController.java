package com.newbee.demo.server.controller.web;

import com.newbee.demo.common.entity.Result;
import com.newbee.demo.common.utils.BeanCopierUtil;
import com.newbee.demo.common.utils.SpringContextUtil;
import com.newbee.demo.core.dto.UserListDTO;
import com.newbee.demo.core.dto.UserListSearchDTO;
import com.newbee.demo.core.enums.UserTypeEnum;
import com.newbee.demo.server.controller.base.BaseController;
import com.newbee.demo.server.param.UserListSearchParam;
import com.newbee.demo.server.vo.UserListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author djs
 * @description 用户控制器
 * @date 2019/9/26 15:28
 */
@RequestMapping(value = "/web/user")
@RestController
public class UserController extends BaseController {

    @PostMapping("/list")
    public Result userList(@RequestBody @Valid UserListSearchParam param) {
        UserListSearchDTO searchDTO = BeanCopierUtil.copy(param, UserListSearchDTO.class);
        // 根据用户类型自适配处理器
        List<UserListDTO> dtoList = UserTypeEnum.valueOf(searchDTO.getUserType()).getHandle()
                .apply(SpringContextUtil.getApplicationContext(), searchDTO);
        return success(BeanCopierUtil.copyList(dtoList, UserListVO.class));
    }

}
