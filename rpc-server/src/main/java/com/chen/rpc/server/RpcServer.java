package com.chen.rpc.server;

import com.chen.rpc.common.util.ReflectionUtils;
import com.chen.rpc.protocol.Request;
import com.chen.rpc.protocol.Response;
import com.chen.rpc.serialization.Decoder;
import com.chen.rpc.serialization.Encoder;
import com.chen.rpc.transport.RequestHandler;
import com.chen.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * RPC服务
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
@Slf4j
public class RpcServer {

    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;
    private RequestHandler handler = (from, to) -> {
        Response response = new Response();
        try {
            byte[] inBytes = IOUtils.readFully(from, from.available());
            Request request = decoder.decode(inBytes, Request.class);
            log.info("get request: {}", request);

            ServiceInstance service = serviceManager.lookup(request);
            Object obj = serviceInvoker.invoke(service, request);
            response.setData(obj);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            response.setCode(1);
            response.setMessage("RpcServer got error: " + e.getClass().getName() + " : " + e.getMessage());
        } finally {
            byte[] outBytes = encoder.encode(response);
            try {
                to.write(outBytes);
                log.info("response client");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    };

    public RpcServer(RpcServerConfig config) {
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, Object bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }
}
