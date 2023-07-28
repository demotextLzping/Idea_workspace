package com.lzp.study5.test2;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-02-12 14:56
 * @Description
 */

public class TestSoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> s = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(s.get());
        System.gc();
        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s.get());

        byte[] bytes = new byte[1024 * 1024 * 15];
        System.out.println(s.get());

    }
}
