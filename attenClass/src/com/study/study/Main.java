package com.study.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int [] num=new int[26];
            for (int i = 0; i < str.length(); i++) {
                int site=(int) str.charAt(i)-97;
                if(site<26&&site>-1){
                    num[site]=num[site]+1;
                }
            }
            for (int i = 0; i < num.length; i++) {
                System.out.println((char)(i + 'a')+":"+num[i]);
            }
        }
    }
}
