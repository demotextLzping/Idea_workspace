package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2023-01-16 11:13
 * @Description 添加数据时，计数线程监控列表长度，当长度为5时，计数线程结束计数
 * 无法操作成功 : 两个线程都是的数据list没有共享，修改的是各自线程的备份数据
 */

public class Test3 {
    List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i + " --- size " + t.size() );
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (t.size() == 5) {
                    break;
                }
            }
            System.out.println("计数结束");
        }, "t2").start();
    }
}