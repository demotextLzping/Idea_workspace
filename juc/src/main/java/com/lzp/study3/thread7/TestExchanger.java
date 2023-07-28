package com.lzp.study3.thread7;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-01-15 13:12
 * @Description
 */

public class TestExchanger {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                exchanger.exchange(s);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t1").start();
        new Thread(() -> {
            String s = "T2";
            try {
                exchanger.exchange(s);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t2").start();
    }


}
