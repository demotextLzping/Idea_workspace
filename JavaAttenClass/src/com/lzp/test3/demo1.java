package com.lzp.test3;

/**
 * @author£º LZPing
 * @date£º 2022-11-15 13:50
 * @Description
 */

public class demo1 {
    public static void main(String[] args) {
        int year = 1988;
        for (; year <= 2022; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(year);
            }

        }

    }
}
