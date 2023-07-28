package com.lzp.study6.VectorBecomeQueue;

/**
 * @author: LZPing
 * @date: 2023-02-13 12:23
 * @Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有十个口在卖票，请写出模拟程序，并说出可能出现的问题
 * 存在的问题：在最后一张票时，多个线程争抢，只有一个线程拿到了票，其他的线程拿得到的是空值，会出现超卖问题
 */

public class TicketSeller1 {
    //只使用List来装火车票，票不加锁
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号--" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    System.out.println("销售了" + tickets.remove(0));
                }
            }).start();
        }
    }

}
