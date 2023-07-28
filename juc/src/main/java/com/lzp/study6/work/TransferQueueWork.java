package com.lzp.study6.work;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author: LZPing
 * @date: 2023-02-14 15:07
 * @Description
 */

public class TransferQueueWork {
    static char[] ai = "1234567".toCharArray();
    static char[] ac = "ABCDEFG".toCharArray();

    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            for (char c : ai) {
                System.out.print(c+" ");
                try {
                    queue.transfer("ok");
                    queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (char c : ac) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(c+" ");
                try {
                    queue.transfer("ok");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }
}
