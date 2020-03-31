package com.newbee.demo.core.concurrent;

/**
 * @author dingjiasheng@sinoiov.com
 * @description 双重检查锁实现单例
 * @date 2020/2/28 14:45
 */
public class DoubleCheckLock {

    /**
     * volatile: 禁止指令重排序, 保证多线程下访问对象时未初始化
     */
    private volatile static DoubleCheckLock uniqueSingleton;

    public DoubleCheckLock getInstance() {
        if (uniqueSingleton == null) {
            synchronized (this) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new DoubleCheckLock();
                }
            }
        }
        return uniqueSingleton;
    }

}
