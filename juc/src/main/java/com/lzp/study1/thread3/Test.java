package com.lzp.study1.thread3;

import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-01-14 09:47
 * @Description 模拟银行账户
 * 对业务写方法进行加锁 对业务的读方法不加锁   行不信
 */

public class Test {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Test account = new Test();
        new Thread(() -> account.set("zhangsan", 100.0)).start();
        try {
            TimeUnit.SECONDS.sleep(1)
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2)
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("zhangsan"));
    }

}
