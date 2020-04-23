package com.chen.rpc.transport;

import com.chen.rpc.protocol.Peer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HTTP传输客户端的实现类
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class HttpTransportClient implements TransportClient {

    private String url;

    @Override
    public void connect(Peer peer) {
        url = "http://" + peer.getHost() + ":" + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");

            httpConn.connect();
            IOUtils.copy(data, httpConn.getOutputStream());

            int resultCode = httpConn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                return httpConn.getInputStream();
            } else {
                return httpConn.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {
        // Do nothing
    }
}
