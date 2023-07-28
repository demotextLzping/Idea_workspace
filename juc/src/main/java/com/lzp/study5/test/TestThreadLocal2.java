package com.lzp.study5.test;

import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-02-12 12:33
 * @Description   ThreadLocal叫做线程变量，
 * 意思是ThreadLocal中填充的变量属于当前线程，该变量对其他线程而言是隔离的，也就是说该变量是当前线程独有的变量。
 * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
 * t2线程先执行，且设置了一个new Person(),是t2自己独有的变量，而t1启动时没有自己的new Person()获取的对象自然为空
 *
 */

public class TestThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1=new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //创建自己线程的Person能获取到
//            tl.set(new Person());
//            System.out.println(tl.get().name);
            //没有自己的和共享的Person，获取为null
            System.out.println(tl.get());

        });
        t1.start();

        Thread t2=new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tl.set(new Person());
        });
        t2.start();
    }

    static class Person {
         String name = "zhangsan";
    }
}
