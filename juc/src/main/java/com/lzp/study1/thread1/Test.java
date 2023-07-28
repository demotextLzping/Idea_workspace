package com.lzp.study1.thread1;

/**
 * @author: LZPing
 * @date: 2023-01-08 11:59
 * @Description Yield 方法
 */

public class Test {
    public static void main(String[] args) {
        testYield();
    }

    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("A------" + i);
                if (i % 4 == 0) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(i + "-----------B");
                if (i % 4 == 0) Thread.yield();
            }
        }).start();
    }
}
