package com.lzp.study4.thread;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-01-16 11:45
 * @Description  使用synchronized 的wait和notify，将读取集合长度作为观察者，一开始便执行并进入等待队列，当添加的长度为5时，唤醒计数线程
 * 无法操作成功 :notify只是唤醒计数线程不释放锁，添加线程没有释放锁，计数线程拿不到锁，依旧无法进行计数
 */

public class Test5 {

    static List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test4 t = new Test4();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("计数开始");
                if (list.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("计数结束");
            }
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("添加开始");
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());

                    System.out.println("add " + i + " --- size " + t.size());
                    if (t.size() == 5) {
                        lock.notify();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("添加结束");
            }
        }, "t1").start();
    }
}