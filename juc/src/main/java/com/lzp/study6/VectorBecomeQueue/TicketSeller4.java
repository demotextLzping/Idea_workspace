package com.lzp.study6.VectorBecomeQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: LZPing
 * @date: 2023-02-13 12:37
 * @Description
 */

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有十个口在卖票，请写出模拟程序，并说出可能出现的问题
 */
public class TicketSeller4 {
    //使用Queue但是给票加上锁
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号--" + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if (s == null) break;
                    else System.out.println("销售了" + s);
                }
            }).start();
        }
    }
}
