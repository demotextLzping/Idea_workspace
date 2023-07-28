package com.study.study3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int number = sc.nextInt();
        int[] postOrder = new int[number];
        int[] inOrder= new int[number];
        for (int i = 0; i < number; i++) {
            postOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < number; i++) {
            inOrder[i] = sc.nextInt();
        }

    }
}
