package com.lzp.test2;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入矩形的宽 : ");
        double width= scanner.nextDouble();
        System.out.println("输入矩形的高 : ");
        double height=scanner.nextDouble();
        double area=width*height;
        System.out.println("宽 : "+width+"\t高 :"+height+"\t矩形的面积未 :"+ area);
    }
}
