package com.study.study;


import java.io.IOException;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count=scanner.nextInt();

        while(scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
            System.out.println(scanner.nextInt());
        }


    }
}
