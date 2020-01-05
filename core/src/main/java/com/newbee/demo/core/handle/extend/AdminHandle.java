package com.newbee.demo.core.handle.extend;

import com.newbee.demo.core.dto.UserListDTO;
import com.newbee.demo.core.dto.UserListSearchDTO;
import com.newbee.demo.core.handle.UserHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:53
 * @description 管理员处理器
 */
@Slf4j
@Component
public class AdminHandle implements UserHandle<UserListSearchDTO> {

    public List<UserListDTO> userList(UserListSearchDTO obj) {
        log.info("调用管理员处理器");
        return Collections.emptyList();
    }
}
