package com.chen.rpc.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class ReflectionUtils {

    private ReflectionUtils() {
    }

    /**
     * 根据class创建对象
     * @param clazz 待创建对象的类
     * @param <T>   对象类型
     * @return 创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个class的公共方法
     * @param clazz 对象类
     * @return 当前类声明的公共方法
     */
    public static Method[] getPublicMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        for (Method m : methods) {
            if (Modifier.isPublic(m.getModifiers())) {
                methodList.add(m);
            }
        }
        return methodList.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     * @param obj    被调用的对象
     * @param method 被调用的方法
     * @param args   方法的参数
     * @return 返回结果
     */
    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
