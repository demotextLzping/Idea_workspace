package com.lzp.lambda.example;

/**
 * @author: LZPing
 * @date: 2023-01-08 12:33
 * @Description
 */

public class Example1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程匿名内部类写法");
            }
        }).start();
//        new Thread(() -> System.out.println("线程匿名内部类写法")).start();

        new Thread(() -> {
            System.out.println("线程lambda表达式写法");
        }).start();

        new Thread(()->System.out.println("线程lambda省略表达式写法")).start();

    }
}
