package com.study.study7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-11-30 10:05
 * @Description
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int citys = scanner.nextInt();
        int roads = scanner.nextInt();
        for (int i = 0; i < roads; i++) {
            int startCity = scanner.nextInt();
            int endCity = scanner.nextInt();
            int cost = scanner.nextInt();
        }
    }
}
