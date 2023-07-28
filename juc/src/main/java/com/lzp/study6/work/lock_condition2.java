package com.lzp.study6.work;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-02-14 14:21
 * @Description
 */

public class lock_condition2 {
    final static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    static char[] ai = "1234567".toCharArray();
    static char[] ac = "ABCDEFG".toCharArray();


    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : ai) {
                    System.out.print(c + " ");
                    condition.signal();
                    condition.await();
                }
                condition.signal();
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
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
    }
}
