package com.chen.rpc.client;

import com.chen.rpc.protocol.Peer;
import com.chen.rpc.serialization.Decoder;
import com.chen.rpc.serialization.Encoder;
import com.chen.rpc.serialization.JSONDecoder;
import com.chen.rpc.serialization.JSONEncoder;
import com.chen.rpc.transport.HttpTransportClient;
import com.chen.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * RPC客户端配置
 * <p>
 * @Author LeifChen
 * @Date 2020-04-23
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selector = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));
}
