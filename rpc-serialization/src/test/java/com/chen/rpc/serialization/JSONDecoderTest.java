package com.chen.rpc.serialization;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 反序列化测试类
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("LeifChen");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);

        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes, TestBean.class);
        assertEquals(bean.getName(), bean2.getName());
        assertEquals(bean.getAge(), bean2.getAge());
    }
}