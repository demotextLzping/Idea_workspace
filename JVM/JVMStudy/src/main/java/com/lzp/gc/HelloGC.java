package com.lzp.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2023-04-03 15:19
 * @Description
 */

public class HelloGC {
    public static void main(String[] args) {
        System.out.println("HelloGC");
        List list = new LinkedList();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }

    }
}

