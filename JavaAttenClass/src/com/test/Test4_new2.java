package com.test;

/**
 * @author: LZPing
 * @date: 2023-03-05 19:36
 * @Description
 */
import java.util.Scanner;
public class Test4_new2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt(); // 输入行数
        int width = sc.nextInt(); // 输入列数
        for (int i = 0; i < height; i++) { // 遍历每一行
            for (int j = 0; j < width; j++) { // 遍历每一列
                char c = (char) (Math.abs(i - j) + 'A'); // 计算字母
                System.out.print(c); // 输出字母
            }
            System.out.println(); // 换行
        }
    }
}