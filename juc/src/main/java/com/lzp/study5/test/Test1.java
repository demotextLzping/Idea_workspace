package com.lzp.study5.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-02-11 17:55
 * @Description
 */

public class Test1 {
    private static volatile int i = 0;
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        i++;
        lock.unlock();

    }

}
