package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: LZPing
 * @date: 2023-01-16 12:52
 * @Description
 */

public class Test8 {
    static List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        Test8 t = new Test8();
        t2 = new Thread(() -> {
            System.out.println("计数开始");
            LockSupport.park();
            System.out.println("计数结束");
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1 = new Thread(() -> {
            System.out.println("添加开始");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i + " --- size " + t.size());
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("添加结束");
        }, "t1");
        t1.start();
    }
}
