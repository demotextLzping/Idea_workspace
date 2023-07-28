package com.study.study4;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> l = new PriorityQueue<Integer>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            l.add(sc.nextInt());
        }
        int sum = 0;
        while (l.size() != 1) {
            int t1 = l.poll();
            int t2 = l.poll();
            sum += t1 + t2;
            l.add(t1 + t2);
        }
        System.out.println(sum);
    }
}