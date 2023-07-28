package com.lzp.lambda.example;

import java.util.function.Function;

/**
 * @author: LZPing
 * @date: 2023-01-08 13:07
 * @Description
 */

public class Example4 {
    public static void main(String[] args) {
        //匿名内部类
        int value = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
//        int value = typeConver(s -> Integer.valueOf(s));
        System.out.println(value);
        //lambda表达式
        int value1 = typeConver((String s) -> {
            return Integer.valueOf(s);
        });
        System.out.println(value1);

        int result = typeConver(s -> Integer.valueOf(s));
        System.out.println(result);

        String value2 = typeConver(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "demo";
            }
        });
        System.out.println(value2);

        String value3 = typeConver((String s) -> {
            return s + "demo";
        });
        System.out.println(value3);

        String result2 = typeConver(s -> s + "demo");
        System.out.println(result2);


    }


    public static <R> R typeConver(Function<String, R> function) {
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
}
