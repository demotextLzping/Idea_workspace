package com.lzp.lambda.example;

import java.util.function.IntConsumer;

/**
 * @author: LZPing
 * @date: 2023-01-08 13:20
 * @Description
 */

public class Example5 {
    public static void main(String[] args) {

        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value+" ");
            }
        });
//        foreachArr(value -> System.out.print(value+" "));
        System.out.println();
        foreachArr((int value) -> {
            System.out.print(value+" ");
        });
        foreachArr(value -> System.out.println(value+" "));
    }

    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            consumer.accept(i);
        }
    }
}
