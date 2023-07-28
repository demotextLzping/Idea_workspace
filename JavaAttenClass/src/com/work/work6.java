package com.work;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 11:39
 * @Description
 */
public class work6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int count = 1;
        int max = value;
        int i = 1;
        while (value != 0) {
            if (value > max) {
                count = 1;
                max = value;
            } else if (value == max) {
                if (i != 1) {
                    count++;
                }
            }
            i++;
            value = scanner.nextInt();
        }
        System.out.println("The largest number is " + max);
        System.out.println("The occurrence count of the largest number is " + count);
    }
}
