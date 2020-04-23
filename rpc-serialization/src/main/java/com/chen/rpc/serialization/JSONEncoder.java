package com.chen.rpc.serialization;

import com.alibaba.fastjson.JSON;

/**
 * 基于JSON的序列化实现
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
