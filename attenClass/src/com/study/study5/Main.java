package com.study.study5;

import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    static int[] markNumber;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int strCount = sc.nextInt();
        int reflectHeight = sc.nextInt();
        markNumber = new int[reflectHeight];
        for (int i = 0; i < reflectHeight; i++) {
            markNumber[i] = i;
        }
        int spaceCount = 0;
        while (spaceCount < strCount) {
            String str = sc.next();
            char[] ch = str.toCharArray();
            int len = ch.length;
            int sum=0 ;
            if(len>=3){
                 sum = ((int) ch[len - 3] - 65) * 32 * 32 + ((int) ch[len - 2] - 65) * 32 + ((int) ch[len - 1] - 65);
            }else {
                for(int i=len;i>0;i--){
                    sum= (int) (ch[i-1]*(Math.pow(32,len-i)));
                }
            }

            int data = sum % reflectHeight;
            if (spaceCount < strCount - 1) {
                System.out.print(data + " ");
            } else {
                System.out.print(data);
            }
            spaceCount++;
        }
    }

    public int siteFind() {

        return 8;
    }
}