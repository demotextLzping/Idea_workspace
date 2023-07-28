package com.work;

import java.util.*;

/**
 * @author: LZPing
 * @date: 2022-12-18 13:06
 * @Description
 */

public class work8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> s1 = new TreeSet<>();
        TreeSet<String> s2 = new TreeSet<>();
        while (s1.size() < 5) {
            String value = scanner.next();
                s1.add(value);
        }
        while (s2.size() < 5) {
            String value = scanner.next();
            s2.add(value);
        }
        s1.addAll(s2);
        for (String i : s1) {
            System.out.println(i);
        }
    }
}
