package com.lzp.study6.work;

import java.util.concurrent.Phaser;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-02-14 12:32
 * @Description
 */

public class lock_condition {
    final static ReentrantLock lock = new ReentrantLock();
    private static Condition numberRead = lock.newCondition();
    private static Condition charRead = lock.newCondition();
    static char[] ai = "1234567".toCharArray();
    static char[] ac = "ABCDEFG".toCharArray();


    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : ai) {
                    System.out.print(c + " ");
                    charRead.signal();
                    numberRead.await();
                }
                charRead.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : ac) {
                    System.out.print(c + " ");
                    numberRead.signal();
                    charRead.await();
                }
                numberRead.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
    }
}
