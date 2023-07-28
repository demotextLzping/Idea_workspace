package com.lzp.classloader;

/**
 * @author: LZPing
 * @date: 2023-03-25 16:07
 * @Description
 */

public class TestWayToRun {
    public static void main(String[] args) {
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int m() {
        int a = 0;
        for (long i = 0; i < 10_0000L; i++) {
            long j = i % 3;
            a += j;
        }
        return a;
    }
}
