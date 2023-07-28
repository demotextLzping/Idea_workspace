package com.lzp.gc;

/**
 * @author: LZPing
 * @date: 2023-04-08 10:15
 * @Description
 */

public class Test1 {
    public static final String LOCK_1 = "lock1";
    public static final String LOCK_2 = "lock2";

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                while (true) {
                    Thread.currentThread().setName("AAAAA");
                    synchronized (Test1.LOCK_1) {
                        System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                        Thread.sleep(1000);
                        synchronized (Test1.LOCK_2) {
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                while (true) {
                    Thread.currentThread().setName("BBBB");
                    synchronized (Test1.LOCK_2) {
                        System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                        Thread.sleep(1000);
                        synchronized (Test1.LOCK_1) {
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}