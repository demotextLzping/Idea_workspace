package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-16 17:09
 * @Description
 */

public class work4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int height = s.nextInt();
        int width = s.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = i; j >= 0 && i-j<width ; j--) {
                System.out.print(" ("+i+j+width+") ");
                System.out.print((char) (65 + j));
            }
            for (int k = 1; k < width - i; k++) {
                System.out.print((char) (65 + k));
            }
            System.out.println();
        }
    }
}
