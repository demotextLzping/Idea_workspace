package com.test;

/**
 * @author: LZPing
 * @date: 2023-02-27 20:05
 * @Description
 */

import java.util.Scanner;
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        StringBuilder answer;
        for (int i = min; i <= max; i++) {
            answer = new StringBuilder(i + "=");
            int temp = i;
            int j=2;
            while(j<=temp){
                if (temp % j == 0) {
                    answer.append(j).append("*");
                    temp = temp / j;
                    j=1;
                }
                j++;
            }
            System.out.println(answer.substring(0,answer.length()-1));
        }
    }
}