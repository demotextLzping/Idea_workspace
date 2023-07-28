package com.lzp.classloader;

/**
 * @author: LZPing
 * @date: 2023-03-25 14:21
 * @Description
 */

public class TestParentAndChild {
    public static void main(String[] args) {
        System.out.println(TestParentAndChild.class.getClassLoader());
        System.out.println(TestParentAndChild.class.getClassLoader().getClass().getClassLoader());
        System.out.println(TestParentAndChild.class.getClassLoader().getParent());
        System.out.println(TestParentAndChild.class.getClassLoader().getParent().getParent());
//        System.out.println(TestParentAndChild.class.getClassLoader().getParent().getParent().getParent());
    }
}
