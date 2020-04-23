package com.chen.rpc.server;

import com.chen.rpc.common.util.ReflectionUtils;
import com.chen.rpc.protocol.Request;
import com.chen.rpc.protocol.ServiceDescriptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;

/**
 * 管理RPC注册服务的测试类
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class ServiceManagerTest {

    ServiceManager sm;

    @Before
    public void init() {
        sm = new ServiceManager();
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
        assertNotNull(sm);
    }

    @Test
    public void lookup() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);

        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(sdp);

        ServiceInstance instance = sm.lookup(request);
        assertNotNull(instance);
    }
}