package com.work;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 13:12
 * @Description
 */

public class work18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            String s = scanner.next();
            try {
                int t = Integer.parseInt(s);
                arr[i] = t;
            } catch (Exception e) {
                System.out.println("java.lang.NumberFormatException: For input string: \"" + s + "\"");
                i--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
