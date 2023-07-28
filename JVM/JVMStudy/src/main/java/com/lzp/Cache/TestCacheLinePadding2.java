package com.lzp.Cache;

/**
 * @author: LZPing
 * @date: 2023-03-26 14:04
 * @Description 通过七个占位的数据，使得arr[0]和arr[1]不在同一个缓存行，运行速度变快
 */

public class TestCacheLinePadding2 {
    private static class Padding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    public static class T extends Padding {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        System.out.println((end - start) / 100_0000 + "ms");
    }
}
