package com.chen.rpc.server;

import com.chen.rpc.common.util.ReflectionUtils;
import com.chen.rpc.protocol.Request;
import com.chen.rpc.protocol.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理RPC注册的服务
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> serviceMap;

    public ServiceManager() {
        this.serviceMap = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, Object bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance instance = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);

            serviceMap.put(sdp, instance);
            log.info("register service: {} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getService();
        return serviceMap.get(sdp);
    }
}
