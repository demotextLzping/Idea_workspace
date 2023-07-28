package com.lzp.study6.TestConcurrentMap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author: LZPing
 * @date: 2023-02-13 13:16
 * @Description
 */

public class ConcurrentMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//       ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
//        Hashtable<String, String> map = new Hashtable<>();
//        HashMap<String, String> map = new HashMap<>();
        Random r = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() ->
            {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + r.nextInt(1000), "a" + r.nextInt());
                }
                latch.countDown();

            });
        }
        for (Thread t : threads) {
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
