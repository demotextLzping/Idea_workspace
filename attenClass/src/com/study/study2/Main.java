package com.study.study2;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void sort(int[] a, int[] b) {
        int len_a = a.length;
        int len_b = b.length;
        int[] result = new int[len_a + len_b];
        int i, j, k;
        i = j = k = 0;
        while (i < len_a && j < len_b) {
            if (a[i] <= b[j])
                result[k++] = a[i++];
            else
                result[k++] = b[j++];
        }
        while (i < len_a)
            result[k++] = a[i++];
        while (j < len_b)
            result[k++] = b[j++];

        for (int p : result) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int[] firstArr=new int[firstNum];
        for (int i = 0; i < firstNum; i++) {
            firstArr[i]=scanner.nextInt();
        }
        int secondNum = scanner.nextInt();
        int[] secondArr=new int[secondNum];
        for (int i = 0; i < secondNum; i++) {
            secondArr[i]=scanner.nextInt();
        }
        sort(firstArr,secondArr);
    }
}