package com.chen.rpc.server;

import com.chen.rpc.serialization.Decoder;
import com.chen.rpc.serialization.Encoder;
import com.chen.rpc.serialization.JSONDecoder;
import com.chen.rpc.serialization.JSONEncoder;
import com.chen.rpc.transport.HttpTransportServer;
import com.chen.rpc.transport.TransportServer;
import lombok.Data;

/**
 * RPC服务配置
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
