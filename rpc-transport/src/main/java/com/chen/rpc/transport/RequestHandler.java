package com.chen.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的处理器
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public interface RequestHandler {
    /**
     * 处理请求
     * @param from
     * @param to
     */
    void onRequest(InputStream from, OutputStream to);
}
