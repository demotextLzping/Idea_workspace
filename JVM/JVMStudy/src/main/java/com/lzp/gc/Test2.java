package com.lzp.gc;

/**
 * @author: LZPing
 * @date: 2023-04-08 10:24
 * @Description
 */

public class Test2 {


    public static void main(String[] args) {
        final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                Thread.currentThread().setName("lockTest");
                System.out.println("锁住");
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            synchronized (o){
                Thread.currentThread().setName("waitTest");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                new Thread(() -> {
                    System.out.println("等待");
                }).start();
            }
        }
    }
}
