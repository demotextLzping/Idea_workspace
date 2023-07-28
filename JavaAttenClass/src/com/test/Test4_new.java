package com.test;

/**
 * @author: LZPing
 * @date: 2023-03-01 14:53
 * @Description
 */

import java.util.*;

public class Test4_new{
    private static List<Integer> factors = new ArrayList<>();
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        int[] buf = new int[end+1];

        while (begin <= end ){
            factorisan(begin, buf);
            showRst(begin, buf);
            begin ++;
        }
    }
    public static void showRst(int num, int[] buf){
        int i = num;
        System.out.print(num + "=");
        while(buf[i] != i){
            System.out.print(i / buf[i] + "*");
            i = buf[i];
        }
        System.out.println(i);
    }


    public static void factorisan(int num, int[] buf){
        for(int i = 2; i*i <= num; i++){
            if (num % i == 0){
                if (buf[num] == 0 ){
                    buf[num] = num / i;
                    //factorisan(num/i, buf);
                    num = num / i;
                    i = 1;
                    continue;
                }
                return;
            }
        }

        buf[num] = num;
    }
}
