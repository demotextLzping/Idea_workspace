package com.lzp.classloader;

/**
 * @author: LZPing
 * @date: 2023-03-26 08:46
 * @Description
 */

public class TestLazyLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        P p;  //没有输出
        X x = new X();  //输出P X
        System.out.println(P.i);  //输出P X 1
        System.out.println(P.j);  //输出P X 1 9
        Class.forName("com.lzp.classloader.TestLazyLoading$P");
    }

    public static class P {
        final static int i = 1;
        static int j = 9;

        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
