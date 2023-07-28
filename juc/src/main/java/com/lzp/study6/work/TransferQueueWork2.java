package com.lzp.study6.work;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author: LZPing
 * @date: 2023-02-14 15:07
 * @Description
 */

public class TransferQueueWork2 {
    static char[] ai = "1234567".toCharArray();
    static char[] ac = "ABCDEFG".toCharArray();

    public static void main(String[] args) {
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                for (char c : ac) {
                    System.out.print(queue.take() + "->+ ");  //等待有人装
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (char c : ai) {
                    queue.transfer(c);
                    System.out.print(queue.take() + "->.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}