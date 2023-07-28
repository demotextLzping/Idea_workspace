package com.lzp.classloader;

/**
 * @author: LZPing
 * @date: 2023-03-25 13:58
 * @Description
 */

public class TestClassLoaderLever {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(TestClassLoaderLever.class.getClassLoader());

        System.out.println(TestClassLoaderLever.class.getClassLoader().getClass().getClassLoader());
     }
}