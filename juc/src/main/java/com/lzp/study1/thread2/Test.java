package com.lzp.study1.thread2;

/**
 * @author: LZPing
 * @date: 2023-01-14 09:30
 * @Description 同步方法和非同步方法是否能同时调用
 */

public class Test {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "   m1 start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "   m1 end...");
    }

    public void m2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "   m2");
    }

    public static void main(String[] args) {
        Test t = new Test();

        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();
    }
}
