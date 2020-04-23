package com.chen.rpc.example;

import com.chen.rpc.client.RpcClient;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户端
 * <p>
 * @Author LeifChen
 * @Date 2020-04-23
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalculatorService service = client.getProxy(CalculatorService.class);

        int r1 = service.plus(10, 8);
        int r2 = service.minus(5, 2);

        log.info("加法结果: {}",r1);
        log.info("减法结果: {}",r2);
    }
}
