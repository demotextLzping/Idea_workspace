package com.lzp.test2;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入姓名(按Enter确认)");
        String name = scanner.next();


        System.out.println("输入年龄(按Enter确认)");
        int year = scanner.nextInt();

        System.out.println("输入身高(按Enter确认)");
        double height = scanner.nextDouble();

        System.out.println("--基本信息--");
        System.out.println("姓名: "+name+"\t年龄: "+year+"\t身高: "+height);


    }
}
