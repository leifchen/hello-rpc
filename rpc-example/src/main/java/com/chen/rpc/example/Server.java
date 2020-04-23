package com.chen.rpc.example;

import com.chen.rpc.server.RpcServer;
import com.chen.rpc.server.RpcServerConfig;

/**
 * 服务端
 * <p>
 * @Author LeifChen
 * @Date 2020-04-23
 */
public class Server {

    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalculatorService.class, new CalculatorServiceImpl());
        server.start();
    }
}
