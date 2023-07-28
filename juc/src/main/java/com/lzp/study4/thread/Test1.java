package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: LZPing
 * @date: 2023-01-16 09:33
 * @Description
 */

public class Test1 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        Thread t1 = new Thread(() -> {
            System.out.println("添加开始");
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("add " + i + " --- size " + list.size());
                latch.countDown();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("添加结束");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("计数开始");
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("计数结束");
        });
        t1.start();
        t2.start();
    }
}
