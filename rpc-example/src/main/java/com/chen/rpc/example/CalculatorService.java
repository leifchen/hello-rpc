package com.chen.rpc.example;

/**
 * 计算接口
 * <p>
 * @Author LeifChen
 * @Date 2020-04-23
 */
public interface CalculatorService {

    /**
     * 相加
     * @param a
     * @param b
     * @return
     */
    int plus(int a, int b);

    /**
     * 相减
     * @param a
     * @param b
     * @return
     */
    int minus(int a, int b);
}
