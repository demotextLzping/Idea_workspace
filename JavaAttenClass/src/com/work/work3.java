package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-16 16:57
 * @Description
 */

public class work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int oddNumber = 0;
        int evenNumber = 0;
        for (int i = 1; i <= num; i++) {
            if(i%3==0){
                if(i%2==0){
                    evenNumber++;
                }else {
                    oddNumber++;
                }
            }
        }
        System.out.print(oddNumber+","+evenNumber);
    }
}