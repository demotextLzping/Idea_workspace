package com.work;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-16 16:17
 * @Description
 */

public class work1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int upperCase = 0;
        int lowerCase = 0;
        int otherCase = 0;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCase++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCase++;
            } else {
                otherCase++;
            }
        }
        System.out.println(upperCase);
        System.out.println(lowerCase);
        System.out.println(otherCase);
    }
}
