package com.lzp.study6.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: LZPing
 * @date: 2023-02-14 13:30
 * @Description
 */

public class BlockingQueueWork {
    static char[] ai = "1234567".toCharArray();
    static char[] ac = "ABCDEFG".toCharArray();

    public static void main(String[] args) {
        ArrayBlockingQueue<Object> numQ = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Object> charsQ = new ArrayBlockingQueue<>(1);
        new Thread(() -> {
            for (char c : ai) {
                System.out.print(c + " ");
                try {
                    numQ.put("ok");
                    charsQ.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (char c : ac) {
                try {
                    numQ.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(c + " ");
                try {
                    charsQ.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
