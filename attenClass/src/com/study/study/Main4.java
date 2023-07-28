package com.study.study;

import java.io.InputStreamReader;
import java.util.Scanner;


public class Main4 {
    public static int flag = 0;

    public static void Print(int num) {
        if (flag != 0) System.out.print(" ");
        else flag = 1;
        System.out.printf("%d", num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int count = sc.nextInt();
        int[] num = new int[count];
        for (int i = 0; i < count; i++) {
            num[i] = sc.nextInt();
        }
        int even = 0, odd = 0;
        while (even < count || odd < count) {
            for (; even < count; even++)
                if (num[even] % 2 == 1) {
                    Print(num[even++]);
                    break;
                }
            for (; even < count; even++) {
                if (num[even] % 2 == 1) {
                    Print(num[even++]);
                    break;
                }
            }
            for (; odd < count; odd++) {
                if (num[odd] % 2 == 0) {
                    Print(num[odd++]);
                    break;
                }
            }
        }
    }
}