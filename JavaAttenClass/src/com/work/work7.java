package com.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ValueRange;
import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 12:25
 * @Description
 */

public class work7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int letter = 0;
        int number = 0;
        int other = 0;
        int blank = 0;
        char[] valueLine=br.readLine().toCharArray();
        for (int i = 0; i < valueLine.length; i++) {
            int value=valueLine[i];
            if ((value >= 65 && value <= 90) || (value >= 97 && value <= 122)) {
                letter++;
            } else if (value >= 48 && value <= 57) {
                number++;
            } else if (value == 32) {
                blank++;
            } else {
                other++;
            }
        }
        System.out.println("字母个数：" +letter);
        System.out.println("数字个数："+number);
        System.out.println("空格个数："+blank);
        System.out.print("其他字符个数："+other);
    }
}
