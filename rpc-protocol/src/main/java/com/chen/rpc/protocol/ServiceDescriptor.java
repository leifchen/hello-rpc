package com.chen.rpc.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 服务描述
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDescriptor {
    private String clazz;
    private String method;
    private String returnType;
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class<?>[] parameterTypeClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterTypeClasses.length];
        for (int i = 0; i < parameterTypeClasses.length; i++) {
            parameterTypes[i] = parameterTypeClasses[i].getName();
        }
        sdp.setParameterTypes(parameterTypes);

        return sdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServiceDescriptor that = (ServiceDescriptor) o;
        return this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}
