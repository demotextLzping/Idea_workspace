package com.lzp.study1.thread5;

/**
 * @author: LZPing
 * @date: 2023-01-14 10:24
 * @Description
 */

public class Test {
    int count = 0;
    synchronized void m() {

        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count== " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();
    }
}
