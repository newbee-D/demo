package com.newbee.demo.core.handle;

import com.newbee.demo.core.dto.UserListDTO;

import java.util.List;

/**
 * @author dingjiasheng@sinoiov.com
 * @date 2019/10/20 21:52
 * @description 用户处理器
 * <p>
 *     T
 * </p>
 */
public interface UserHandle<T> {

    List<UserListDTO> userList(T t);
}
