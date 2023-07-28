package com.lzp.classloader;

/**
 * @author: LZPing
 * @date: 2023-03-25 14:42
 * @Description
 */

public class TestLocalClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = TestLocalClassByHand.class.getClassLoader().loadClass("com.lzp.classloader.TestLocalClassByHand");
        System.out.println(clazz);
    }
}
