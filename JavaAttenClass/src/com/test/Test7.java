package com.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: LZPing
 * @date: 2023-02-27 22:26
 * @Description
 */

public class Test7 {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.shout();
    }
}

class Animal {
    void shout() {
        System.out.println("animal shout！");
    }
}

class Dog extends Animal {
    Dog(){
        super.shout();
        this.shout();
    }
    void shout() {
        super.shout();
        System.out.println("wangwang……");
        this.run();
    }

    void run() {
        System.out.println("Dog is running");
    }
}
//public class Test7 {
//    public static void main(String[] args) {
//        Son son = new Son();
//        son.method();
//    }
//}
//
//class Parent {
//    Parent() {
//        System.out.println("Parent's Constructor without parameter");
//    }
//
//    Parent(boolean b) {
//        System.out.println("Parent's Constructor with a boolean parameter");
//    }
//
//    public void method() {
//        System.out.println("Parent's method()");
//    }
//}
//
//class Son extends Parent {
//    Son() {
//        super(true);
//        System.out.println("Son's Constructor without parameter");
//    }
//
//    public void method() {
//        System.out.println("Son's method()");
//        super.method();
//    }
//}