package com.lzp.study3.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-01-15 10:15
 * @Description
 */

public class ReentrantLock04 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();   //打断线程2的等待
    }
}
