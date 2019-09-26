package com.newbee.demo.common.utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author djs
 * @description 对象拷贝工具
 * @date 2019/9/26 14:38
 */
public class BeanCopierUtil {

    private static final int DEFAULT_INITIAL_CAPACITY = 500;
    private final static Map<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<String, BeanCopier>(DEFAULT_INITIAL_CAPACITY);
    private static final Map<String, ConstructorAccess> CONSTRUCTOR_ACCESS_CACHE = new ConcurrentHashMap<String, ConstructorAccess>(DEFAULT_INITIAL_CAPACITY);


    /**
     * 对象属性拷贝
     *
     * @param srcObj  有值对象
     * @param destObj 无值目标对象
     */
    public static <S, D> void copy(S srcObj, D destObj) {
        if (srcObj == null) {
            return;
        }
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, null);
    }

    /**
     * 对象属性拷贝
     *
     * @param srcObj    有值对象
     * @param destClazz 无值目标对象
     */
    public static <S, D> D copy(S srcObj, Class<D> destClazz) {
        if (srcObj == null) {
            return null;
        }
        String key = genKey(srcObj.getClass(), destClazz);
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destClazz, false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        ConstructorAccess<D> constructorAccess = getConstructorAccess(destClazz);
        D d = constructorAccess.newInstance();
        copier.copy(srcObj, d, null);
        return d;
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

    public static <T> List<T> copyList(List<?> sourceList, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return null;
        }

        List<T> resultList = new ArrayList<T>(sourceList.size());
        for (Object o : sourceList) {
            T t;
            try {
                t = copy(o, targetClass);
                resultList.add(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        ConstructorAccess<T> constructorAccess = CONSTRUCTOR_ACCESS_CACHE.get(targetClass.toString());
        if (constructorAccess != null) {
            return constructorAccess;
        }
        try {
            constructorAccess = ConstructorAccess.get(targetClass);
            constructorAccess.newInstance();
            CONSTRUCTOR_ACCESS_CACHE.put(targetClass.toString(), constructorAccess);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        return constructorAccess;
    }

}
