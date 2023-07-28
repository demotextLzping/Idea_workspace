package com.lzp.study6.work;

/**
 * @author: LZPing
 * @date: 2023-02-14 13:16
 * @Description
 */

public class cas {
    enum ReadyToRun {T1,T2}
    static volatile ReadyToRun r=ReadyToRun.T1;

    public static void main(String[] args) {
        char[] ai = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();
        new Thread(()->{
            for (char c : ai) {
                while (r!=ReadyToRun.T1){}  //自旋，等到r是T1时继续运行
                System.out.print(c + " ");
                r=ReadyToRun.T2;
            }
        }).start();
        new Thread(()->{
            for (char c : ac) {
                while (r!=ReadyToRun.T2){}  //自旋，等到r是T2时继续运行
                System.out.print(c + " ");
                r=ReadyToRun.T1;
            }
        }).start();


    }
}
