package com.chen.rpc.server;

import com.chen.rpc.common.util.ReflectionUtils;
import com.chen.rpc.protocol.Request;

/**
 * 具体服务调用
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }
}
