package com.chen.rpc.transport;

/**
 * 传输服务端接口
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public interface TransportServer {

    /**
     * 初始化
     * @param port    端口
     * @param handler 请求处理器
     */
    void init(int port, RequestHandler handler);

    /**
     * 开始传输
     */
    void start();

    /**
     * 结束传输
     */
    void stop();
}
