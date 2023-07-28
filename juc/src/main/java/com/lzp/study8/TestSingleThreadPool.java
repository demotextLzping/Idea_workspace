package com.lzp.study8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: LZPing
 * @date: 2023-02-19 14:56
 * @Description
 */

public class TestSingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executor.execute(() -> {
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
    }
}
