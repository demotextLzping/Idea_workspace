package com.test;

/**
 * @author: LZPing
 * @date: 2023-02-27 20:39
 * @Description
 */

import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        int max=num;
        int count=1;
        while(num!=0){
            num=sc.nextInt();
            if(num==max){
                count++;
            }
            if(num>max){
                max=num;
                count=1;
            }
        }
        System.out.println("The largest number is "+max);
        System.out.println("The occurrence count of the largest number is "+count);
    }
}