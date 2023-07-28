package com.lzp;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: LZPing
 * @date: 2023-03-18 14:28
 * @Description
 */

public class PS {

    static ArrayList<Integer> nums = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) nums.add(1000000 + new Random().nextInt(1000000));
    }

    static void foreach() {
        nums.forEach(PS::isPrime);
    }

    static void parallel() {
        nums.parallelStream().forEach(PS::isPrime);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
