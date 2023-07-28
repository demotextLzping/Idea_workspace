package com.lzp.study6.VectorBecomeQueue;

/**
 * @author: LZPing
 * @date: 2023-02-13 12:33
 * @Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有十个口在卖票，请写出模拟程序，并说出可能出现的问题
 */
public class TicketSeller3 {
    //使用List但是给票加上锁
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号--" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) break;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}


