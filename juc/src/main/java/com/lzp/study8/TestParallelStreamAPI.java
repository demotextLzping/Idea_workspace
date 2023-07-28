package com.lzp.study8;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: LZPing
 * @date: 2023-03-18 10:24
 * @Description
 */

public class TestParallelStreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10000; i++) nums.add(1000000 + new Random().nextInt(1000000));
        //使用普通stream流 串行
        long start = System.currentTimeMillis();
        nums.forEach(v -> isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println("stream: " + (end - start));

        //使用并行流
        start = System.currentTimeMillis();
        nums.parallelStream().forEach(TestParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println("parallelStream: " + (end - start));
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
