package com.chen.rpc.protocol;

import lombok.Data;

/**
 * 请求
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
