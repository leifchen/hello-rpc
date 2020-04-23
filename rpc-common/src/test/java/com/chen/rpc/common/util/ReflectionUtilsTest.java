package com.chen.rpc.common.util;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 反射工具类的测试
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1, methods.length);

        String methodName = methods[0].getName();
        assertEquals("b", methodName);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];

        TestClass t = new TestClass();
        Object res = ReflectionUtils.invoke(t, b);
        assertEquals("b", res);
    }
}