package com.lzp.study3.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-01-15 09:22
 * @Description 使用trylock
 */

public class ReentrantLock03 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据tryLock的返回值来判断是否锁定，为true是锁定成功，反之未成功
     * 也可以指定tryLock 的时间，由于tryLock(time)抛出异常，所以要注意unlock的处理，必须放到finally中
     */
    void m2() {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            System.out.println("m2..." + locked);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (locked)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock03 r = new ReentrantLock03();
        new Thread(r::m1, "m1").start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r::m2, "m2").start();
    }

}
