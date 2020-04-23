package com.chen.rpc.serialization;

import com.alibaba.fastjson.JSON;

/**
 * 基于JSON的反序列化实现
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
