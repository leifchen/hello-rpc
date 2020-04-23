package com.chen.rpc.client;

import com.chen.rpc.protocol.Peer;
import com.chen.rpc.transport.TransportClient;

import java.util.List;

/**
 * 连接选择器
 * <p>
 * @Author LeifChen
 * @Date 2020-04-23
 */
public interface TransportSelector {

    /**
     * 初始化selector
     * @param peers 可以连接的server端点信息
     * @param count client和server建立的连接数
     * @param clazz client实现类
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);

    /**
     * 选择一个TransportClient
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     * @param client
     */
    void release(TransportClient client);

    /**
     * 关闭client
     */
    void close();
}
