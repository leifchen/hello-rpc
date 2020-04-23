package com.chen.rpc.protocol;

import lombok.Data;

/**
 * 响应
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Data
public class Response {
    private int code;
    private String message;
    private Object data;
}
