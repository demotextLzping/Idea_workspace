package com.lzp.study4.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2023-01-16 11:13
 * @Description 给list添加volatile使得数据共享
 * 使用同步容器解决数据的同步和数据与可见
 * <p>
 * 问题:在删除时间等待后，仍然会出现问题
 */

public class Test4 {
    //使用volatile(解决了数据可见)
//    volatile List<Object> list = new ArrayList<>();
    //使用同步容器(解决同步和数据可见)
    volatile List<Object> list = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test4 t = new Test4();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i + " --- size " + t.size());
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