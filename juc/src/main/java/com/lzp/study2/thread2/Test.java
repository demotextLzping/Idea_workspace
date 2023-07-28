package com.lzp.study2.thread2;

/**
 * @author: LZPing
 * @date: 2023-01-14 12:33
 * @Description
 */

public class Test {
    final Object o = new Object();

    void m() {
        synchronized (o) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        new Thread(t::m,"t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(t::m, "t2");
//        t.o = new Object();
        t2.start();
    }
}
