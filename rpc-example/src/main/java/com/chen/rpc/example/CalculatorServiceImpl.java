package com.chen.rpc.example;

/**
 * 计算实现类
 * <p>
 * @Author LeifChen
 * @Date 2020-04-23
 */
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
