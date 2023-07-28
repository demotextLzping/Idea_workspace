package com.lzp.study6.work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: LZPing
 * @date: 2023-02-14 13:17
 * @Description
 */

public class LockSupportWork {
    static Thread t1, t2 = null;
    public static void main(String[] args) {
        char[] ai = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();
        t1 = new Thread(() -> {
            for (char c : ai) {
                System.out.print(c+" ");
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 = new Thread(() -> {
            for (char c : ac) {
                LockSupport.park();
                System.out.print(c+" ");
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
        System.out.println();
    }
}
