package com.work;

/**
 * @author: LZPing
 * @date: 2022-12-18 15:58
 * @Description
 */

public class work11 {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.shout();
        animal.run();
    }
}

class Animal {
    void shout() {
        System.out.println("animal shout！");
    }
    void run(){

    }
}

class Dog extends Animal {
    void shout() {
        super.shout();
        System.out.println("wangwang……");
    }

    void run() {
        System.out.println("Dog is running");
    }
}