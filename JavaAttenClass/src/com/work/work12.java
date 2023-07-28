package com.work;

/**
 * @author: LZPing
 * @date: 2022-12-18 16:00
 * @Description
 */

public class work12 {
    public static void main(String[] args) {
        Son son = new Son();
        son.method();
    }
}

class Parent {
    Parent() {
        System.out.println("Parent's Constructor without parameter");
    }

    Parent(boolean b) {
        System.out.println("Parent's Constructor with a boolean parameter");
    }

    public void method() {
        System.out.println("Parent's method()");
    }
}

class Son extends Parent {
    Son() {
        super(true);
        System.out.println("Son's Constructor without parameter");
    }
    @Override
    public void method() {
        System.out.println("Son's method()");
        super.method();
    }
}
