package com.lzp.study1.thread4;

/**
 * @author: LZPing
 * @date: 2023-01-14 10:03
 * @Description
 */

public class Test {
    synchronized void m1() {
        System.out.println("m1 start...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end...");
    }

    synchronized void m2() {
        System.out.println("m2 start...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end...");
    }

    public static void main(String[] args) {
        new Test().m1();
    }
}
