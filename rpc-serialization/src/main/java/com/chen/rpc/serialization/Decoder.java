package com.chen.rpc.serialization;

/**
 * 反序列化接口
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public interface Decoder {
    /**
     * 反序列化
     * @param bytes 二进制数据
     * @param clazz 对象类
     * @param <T>   对象类型
     * @return 二进制数据反序列化生成的类
     */
    <T> T decode(byte[] bytes, Class<T> clazz);
}
