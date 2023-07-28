package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-16 16:52
 * @Description
 */

public class work2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if((year%4==0&&year%100!=0)||  year%400==0){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
