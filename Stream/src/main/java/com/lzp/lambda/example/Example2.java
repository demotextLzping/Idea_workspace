package com.lzp.lambda.example;

import java.util.function.IntBinaryOperator;

/**
 * @author: LZPing
 * @date: 2023-01-08 12:33
 * @Description
 */

public class Example2 {
    public static void main(String[] args) {
        //内部类
        int value = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(value);
        //将匿名内部类是hi有idea快捷键自动转换lambda表达式
        //使用alt+enter可以再匿名内部类和lambda表示中切换
        int value3 = calculateNum((left, right) -> left + right);
        System.out.println(value3);


        //Lambda表达式
        int value2 = calculateNum((int left, int right) -> {
            return left + right;
        });
        System.out.println(value2);


    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
