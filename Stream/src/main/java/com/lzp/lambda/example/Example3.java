package com.lzp.lambda.example;

import java.util.function.IntPredicate;

/**
 * @author: LZPing
 * @date: 2023-01-08 12:59
 * @Description
 */

public class Example3 {
    public static void main(String[] args) {
        //匿名内部类写法
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return true;
            }
        });
//          printNum(value -> true);
        System.out.println();
        //lambda表达式
        printNum((int value) -> {
            return true;
        });
        //lambda最简洁表达式
        printNum(value -> true);
    }


    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
