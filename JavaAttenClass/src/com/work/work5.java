package com.work;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: LZPing
 * @date: 2022-12-16 17:58
 * @Description
 */

public class work5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int min = s.nextInt();
        int max = s.nextInt();
        String answer="";
        for (int i = min; i <= max; i++) {
            answer=i+"=";
            int temp = i;
            for (int j = 2; j <= i; j++) {
                if (temp % j == 0) {
                    answer=answer+j+"*";
                    temp = temp / j;
                    j=1;
                }
            }
            if(i!=max){
                System.out.println(answer.substring(0,answer.length()-1));
            }else {
                System.out.print(answer.substring(0,answer.length()-1));
            }

        }
        System.out.println();
    }
}
