package com.lzp.study6.VectorBecomeQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author: LZPing
 * @date: 2023-02-13 12:28
 * @Description
 */

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有十个口在卖票，请写出模拟程序，并说出可能出现的问题
 * 存在的问题：在最后一张票时，因为Vector的size和remove方法原子性的，都是加锁的不会出现问题，
 * 但是在size和remove中加上了一段时间的sleep，一样会导致线程争抢出现超买，如果没有时间延迟不会出现问题
 */
public class TicketSeller2 {
    //只使用vector来装火车票，票不加锁
    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号--" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了" + tickets.remove(0));
                }
            }).start();
        }
    }
}
