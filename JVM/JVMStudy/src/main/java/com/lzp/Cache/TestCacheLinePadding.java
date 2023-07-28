package com.lzp.Cache;

/**
 * @author: LZPing
 * @date: 2023-03-26 14:04
 * @Description 使得arr[0]和arr[1]在同一个缓存行，修改其中一个另一个会被受限
 */

public class TestCacheLinePadding {
    public static class T {
        public volatile long x = 0L;
    }

    public static TestCacheLinePadding2.T[] arr = new TestCacheLinePadding2.T[2];

    static {
        arr[0] = new TestCacheLinePadding2.T();
        arr[1] = new TestCacheLinePadding2.T();
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
