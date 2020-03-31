package com.newbee.demo.core.test;

import com.newbee.demo.common.exception.ErrorCodeEnum;
import com.newbee.demo.common.exception.ProjectException;
import com.newbee.demo.core.dto.UserListDTO;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author dingjiasheng@sinoiov.com
 * @description hello world
 * @date 2020/3/20 16:09
 **/
@Slf4j
public class Lock {

    /** 锁时长 */
    private static final long LOCK_TIME_SECONDS = 5;

    @Resource
    private RedissonClient redissonClient;

    /**
     * 分布式锁测试（根据用户id加锁）
     *
     * <p>
     *     加锁正确方式：try catch ，在finally中释放锁
     * </p>
     *
     * @param userId 用户id
     * @return {@link UserListDTO}
     * @throws ProjectException
     */
    public UserListDTO lockTest(String userId) throws ProjectException {
        RLock rLock = redissonClient.getLock(userId);
        try {
            if (rLock.isLocked()) {
                log.error("未获取锁");
                throw new ProjectException(ErrorCodeEnum.BUSINESS_FREQUENT_ERROR);
            }
            // 直接加锁
            rLock.lock(LOCK_TIME_SECONDS, TimeUnit.SECONDS);
            // 重试锁(1s重试)
            rLock.tryLock(1L, LOCK_TIME_SECONDS, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return null;
    }

}
