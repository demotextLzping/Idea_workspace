package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-01-16 12:04
 * @Description  在添加线程知道长度为5时，notify唤醒等待的计数线程，并自己wait进入等待队列，直到计数线程操作完成，唤醒添加线程在继续添加数据
 */

public class Test6 {

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
                lock.notify();
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
                        lock.notify();  //唤醒计数线程并将自己的线程睡眠
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                System.out.println("添加结束");
            }
        }, "t1").start();
    }
}