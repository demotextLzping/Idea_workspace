package com.lzp.study5.test;

import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-02-12 12:17
 * @Description
 */

public class TestThreadLocal {
    static Person p=new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(p.name);

        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            p.name="lisi";

        }).start();

    }
    static class Person{
        String name="zhangsan";
    }

}

