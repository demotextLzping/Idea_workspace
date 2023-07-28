package com.lzp.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-03-26 15:37
 * @Description
 */

public class TestDisorder {
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                    a = 1;
                    x = b;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread other = new Thread(() -> {
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                    b = 1;
                    y = a;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次(" + x + "," + y + ")";
            System.out.println(result);
            if (x == 0 && y == 0) {
                System.out.println("========================"+result);
                break;
            }
        }
    }
}
