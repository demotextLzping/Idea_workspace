package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: LZPing
 * @date: 2023-01-16 12:42
 * @Description
 */

public class Test7 {
    static List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test7 t = new Test7();
        Thread thread = new Thread(() -> {
            System.out.println("计数开始");
            if (list.size() != 5) {
                LockSupport.park();
            }
            System.out.println("计数结束");
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("添加开始");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i + " --- size " + t.size());
                if (t.size() == 5) {
                    LockSupport.unpark(thread);
                    LockSupport.park();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("添加结束");
        }).start();
    }
}
