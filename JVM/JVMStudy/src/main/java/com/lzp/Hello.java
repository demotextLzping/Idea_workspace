package com.lzp;

/**
 * @author: LZPing
 * @date: 2023-03-25 14:56
 * @Description
 */

public class Hello {
    public void m() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        int i = 8;
//        i = i++;
        i = ++i;
        System.out.println(i);
    }

}
