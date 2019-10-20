package com.newbee.demo.core.handle.extend;

import com.alibaba.fastjson.JSON;
import com.newbee.demo.core.dto.UserListSearchDTO;
import com.newbee.demo.core.handle.UserHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:53
 * @description 管理员处理器
 */
@Slf4j
@Component
public class AdminHandle implements UserHandle {

    public void userList(Object obj) {
        UserListSearchDTO searchDTO = JSON.parseObject(JSON.toJSONString(obj), UserListSearchDTO.class);
        log.info(JSON.toJSONString(searchDTO) + "调用管理员处理器");
        //TODO do something
    }
}
