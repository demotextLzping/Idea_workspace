package com.lzp.study6.work;

/**
 * @author: LZPing
 * @date: 2023-02-14 12:29
 * @Description  最后肯定会有一个线程是wait状态，必须是要notify释放
 */

public class sync_wait_notify {
    public static void main(String[] args) {
        final Object obj = new Object();
        char[] ai = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();
        new Thread(() -> {
            synchronized (obj) {
                for (char c : ai) {
                    System.out.print(c+" ");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();  //必须释放，否则无法停止
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                for (char c : ac) {
                    System.out.print(c+" ");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();  //必须释放，否则无法停止
            }
        }).start();
    }
}
