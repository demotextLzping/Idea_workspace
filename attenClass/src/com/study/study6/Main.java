package com.study.study6;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int peak = sc.nextInt();//顶点
        int border = sc.nextInt();//边框数
        String str = sc.next();
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }
        int[] number = new int[peak];
        for (int i = 0; i < border; i++) {
            char[] chars = sc.next().toCharArray();
            char firChar = chars[0];
            int firSite = charList.indexOf(firChar);
            number[firSite]++;
            char secChar = chars[1];
            int secSite = charList.indexOf(secChar);
            number[secSite]++;
        }
        for (int i = 0; i < number.length; i++) {
            if (i == number.length - 1) {
                System.out.print(number[i]);
                break;
            }
            System.out.print(number[i] + " ");
        }
    }
}
