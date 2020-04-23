package com.chen.rpc.serialization;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * 序列化测试
 * <p>
 * @Author LeifChen
 * @Date 2020-04-19
 */
public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("LeifChen");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }
}