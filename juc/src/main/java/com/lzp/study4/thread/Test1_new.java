package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: LZPing
 * @date: 2023-01-16 12:24
 * @Description
 */

public class Test1_new {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            System.out.println("添加开始");
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("add " + i + " --- size " + list.size());
                if (list.size() == 5) {
                    latch.countDown();
                }
//               当没有时间限制的时候，门栓打开之后马上就会进行线程的争抢
//               当有时间的限制，门栓打开之后，添加线程会睡眠，计数线程马上抢占执行，睡眠结束，添加线程又会重新抢占（此时计数线程已经结束）线程执行
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
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

