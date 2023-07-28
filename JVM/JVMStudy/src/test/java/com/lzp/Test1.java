package com.lzp;


/**
 * @author: LZPing
 * @date: 2023-04-02 17:15
 * @Description
 */
public class Test1 {
    public static void main(String[] args) {

    }
   static int bitCount(int x)
    {
        int count=0;
        while(x!=0){
            int i=1&x;
            if(i==1){
                count++;
            }
            x=x>>1;
        }
        return count;


    }
}

