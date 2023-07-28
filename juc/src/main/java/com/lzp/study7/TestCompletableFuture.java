package com.lzp.study7;

import java.io.IOException;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-02-19 09:56
 * @Description
 * 假设你能够提供一个服务
 * 这个服务查询个各大电商网站同一类产品的价格并汇总展示（商品比价格）
 */

public class TestCompletableFuture {
    public static void main(String[] args) {
        long start, end;
        //三者依次运行
        start = System.currentTimeMillis();
        priceOfTM();
        priceOfTB();
        priceOfJD();
        end = System.currentTimeMillis();
        System.out.println("use time " + (end - start));

        //使用CompletableFuture三者并行运行
//        start = System.currentTimeMillis();
//        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(() -> priceOfTM());
//        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(() -> priceOfTB());
//        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(() -> priceOfJD());
//        //allOf任务全部完成结束
//        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();

        //CompletableFuture提供的其他lambda链式的写法
//        CompletableFuture.supplyAsync(()->priceOfTM())
//                .thenApply(String::valueOf)
//                .thenApply(str->"price "+str)
//                .thenAccept(System.out::println);
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        end = System.currentTimeMillis();
//        System.out.println("use CompletableFuture time " + (end - start));
    }

    public static double priceOfTM() {
        delay();
        return 1.00;
    }

    public static double priceOfTB() {
        delay();
        return 1.00;
    }

    public static double priceOfJD() {
        delay();
        return 1.00;
    }


    public static void delay() {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep!\n", time);
    }
}
