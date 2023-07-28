package com.study.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> fh = new ArrayList<>();
        String str = br.readLine();
        while (!".".equals(str)) {
            loop:
            for (int i = 0, size = str.length(); i < size; i++) {
                char ch = str.charAt(i);
                switch (ch) {
                    case '/':
                        if (i + 1 < size && '*' == str.charAt(i + 1)) {
                            fh.add(1);
                        }
                        break;
                    case '(':
                        fh.add(2);
                        break;
                    case '[':
                        fh.add(3);
                        break;
                    case '{':
                        fh.add(4);
                        break;
                    case '*':
                        if (i - 1 >= 0 && '/' != str.charAt(i - 1)
                                && i + 1 < size && '/' == str.charAt(i + 1)) {
                            if (fh.isEmpty()) {
                                System.out.println("NO");
                                System.out.println("?-*/");
                                System.exit(0);
                            } else if (fh.get(fh.size() - 1) == 1)
                                fh.remove(fh.size() - 1);
                            else
                                break loop;
                        }
                        break;
                    case ')':
                        if (fh.isEmpty()) {
                            System.out.println("NO");
                            System.out.println("?-)");
                            System.exit(0);
                        } else if (fh.get(fh.size() - 1) == 2)
                            fh.remove(fh.size() - 1);
                        else
                            break loop;

                        break;
                    case ']':
                        if (fh.isEmpty()) {
                            System.out.println("NO");
                            System.out.println("?-]");
                            System.exit(0);
                        } else if (fh.get(fh.size() - 1) == 3)
                            fh.remove(fh.size() - 1);
                        else
                            break loop;
                        break;
                    case '}':
                        if (fh.isEmpty()) {
                            System.out.println("NO");
                            System.out.println("?-}");
                            System.exit(0);
                        } else if (fh.get(fh.size() - 1) == 4)
                            fh.remove(fh.size() - 1);
                        else
                            break loop;
                        break;
                }
            }
            str = br.readLine();
        }
        if (fh.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
            int judge = fh.get(fh.size() - 1);
            if (judge == 1)
                System.out.println("/*-?");
            else if (judge == 2)
                System.out.println("(-?");
            else if (judge == 3)
                System.out.println("[-?");
            else if (judge == 4)
                System.out.println("{-?");
        }
    }
}