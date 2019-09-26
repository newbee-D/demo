package com.newbee.demo.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newbee.demo.core.domain.UserInfo;
import com.newbee.demo.core.dao.UserInfoDao;
import com.newbee.demo.core.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * Auto created by codeAppend plugin
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

    // use "baseMapper" to call jdbc
    // example: baseMapper.insert(entity);
    // example: baseMapper.selectByPage(params);
   
}