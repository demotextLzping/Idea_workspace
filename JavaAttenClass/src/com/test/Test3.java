package com.test;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2023-02-27 19:43
 * @Description
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int min = s.nextInt();
        int max = s.nextInt();
        String answer = "";
        for (int i = min; i <= max; i++) {
            answer = i + "=";
            int temp = i;
            int j = 2;
            while (j <= i) {
                if (temp % j == 0) {
                    answer = answer + j + "*";
                    temp = temp / j;
                    j = 1;
                }
                j++;
            }
            if (i != max) {
                System.out.println(answer.substring(0, answer.length() - 1));
            } else {
                System.out.print(answer.substring(0, answer.length() - 1));
            }
        }
    }
}
