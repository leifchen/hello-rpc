package com.chen.rpc.serialization;

/**
 * 序列化接口
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public interface Encoder {
    /**
     * 序列化
     * @param obj 对象
     * @return 对象序列化生成的二进制数据
     */
    byte[] encode(Object obj);
}
