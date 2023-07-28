package com.lzp.study3.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-01-15 09:42
 * @Description   synchronized可从入
 */

public class ReentrantLock01 {

    synchronized void m1() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println(i);
                if (i == 3) m2();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized void m2() {
        System.out.println("m2...");

    }

    public static void main(String[] args) {
        ReentrantLock01 r = new  ReentrantLock01();
        new Thread(r::m1, "m1").start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(r::m2, "m2").start();
    }

}
