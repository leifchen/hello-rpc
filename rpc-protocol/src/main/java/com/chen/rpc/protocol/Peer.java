package com.chen.rpc.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 网络传输端点
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
