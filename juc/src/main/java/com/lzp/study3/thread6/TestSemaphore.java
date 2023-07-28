package com.lzp.study3.thread6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-01-15 13:01
 * @Description
 */


public class TestSemaphore {
    public static void main(String[] args) {
//        Semaphore semaphore = new Semaphore(1);
//        Semaphore semaphore = new Semaphore(2);

        Semaphore semaphore = new Semaphore(2, true);
        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T1 start...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T1 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T2 start...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
    }
}