package com.newbee.demo.core.handle.extend;

import com.alibaba.fastjson.JSON;
import com.newbee.demo.common.utils.BeanCopierUtil;
import com.newbee.demo.core.dto.UserListSearchDTO;
import com.newbee.demo.core.handle.UserHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:56
 * @description 普通用户处理器
 */
@Slf4j
@Component
public class OrdinaryHandle implements UserHandle {

    public void userList(Object obj) {
        UserListSearchDTO searchDTO = BeanCopierUtil.copy(obj, UserListSearchDTO.class);
        log.info(JSON.toJSONString(searchDTO) + "调用普通用户处理器");
        //TODO do something
    }
}
