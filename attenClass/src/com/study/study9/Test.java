package com.study.study9;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2023-01-04 09:59
 * @Description
 */

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.next());
        int count = Integer.parseInt(scanner.next());
        int[] number = new int[len];
        for (int i = 0; i < len; i++) {
            number[i] = Integer.parseInt(scanner.next());
        }
        for (int j = 0; j < count; j++) {
            for (int i = 0; i < len - 1; i++) {
                if (number[i] > number[i + 1]) {
                    int temp = number[i];
                    number[i] = number[i + 1];
                    number[i + 1] = temp;
                }

            }
        }
        for (int i : number) {
            System.out.print(i + " ");
        }
    }
}
