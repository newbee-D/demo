package com.newbee.demo.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * @author dingjiasheng@sinoiov.com
 * @description TODO
 * @date 2019/8/20 11:20
 */
@Slf4j
public class ParamUtil {

    private static final String FIELD_TYPE = "class java.lang.String";
    private static final String CODE_TYPE = "UTF-8";

    /**
     * bean String类型参数转码
     */
    public static Object paramDecode(Object obj) {
        if (obj != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if (FIELD_TYPE.equals(field.getGenericType().toString()) &&
                            field.get(obj) != null) {
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), obj.getClass());
                        Method wM = pd.getWriteMethod();
                        wM.invoke(obj, URLDecoder.decode(field.get(obj).toString(), CODE_TYPE));
                    }
                } catch (Exception e) {
                    log.error("参数转码失败->{}", e.getMessage());
                    return obj;
                }
            }
        }
        return obj;
    }
}
