package com.chen.rpc.transport;

import com.chen.rpc.protocol.Peer;

import java.io.InputStream;

/**
 * 传输客户端接口
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public interface TransportClient {
    /**
     * 创建连接
     * @param peer
     */
    void connect(Peer peer);

    /**
     * 发送数据
     * @param data
     * @return
     */
    InputStream write(InputStream data);

    /**
     * 关闭连接
     */
    void close();
}
