package com.lzp.gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-04-08 09:00
 * @Description
 */

public class TestFullGCProblem {
    private static class cardInfo {
        BigDecimal price = new BigDecimal("0.0");
        String name = "";
        int age = 5;
        Date date = new Date();

        public void m() {

        }
    }

    private static ScheduledThreadPoolExecutor executor = new
            ScheduledThreadPoolExecutor(50,
            new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String[] args) throws InterruptedException {
        executor.setMaximumPoolSize(50);
        for (; ; ) {
            modelFit();
            Thread.sleep(100);
        }

    }

    private static void modelFit() {
        List<cardInfo> list = getAllCardInfo();
        Thread.currentThread().setName("TestFullGCProblemThread");
        list.forEach(info -> {
            executor.scheduleWithFixedDelay(() -> {
                info.m();
            }, 2, 3, TimeUnit.SECONDS);
        });
    }

    private static List<cardInfo> getAllCardInfo() {
        List<cardInfo> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            cardInfo c = new cardInfo();
            list.add(c);
        }
        return list;
    }
}
