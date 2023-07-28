package com.lzp.test3;

import java.util.Arrays;

/**
 * @author£º LZPing
 * @date£º 2022-11-15 13:50
 * @Description
 */

public class demo2 {
    public static void main(String[] args) {
        int[] number = {100, 50, 90, 60, 80, 70};
        int sum = Arrays.stream(number).sum();
        int max = Arrays.stream(number).max().getAsInt();
        int min = Arrays.stream(number).min().getAsInt();
        int avg = (sum - max - min) / (number.length - 2);
        System.out.println(avg);

    }
}
