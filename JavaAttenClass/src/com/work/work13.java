package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 16:19
 * @Description
 */
abstract class Shape13 {
    final double PI = 3.1415926;
    double area() {
        return 1;
    }
    double perimeter() {
        return 1;
    }
}

class Oval extends Shape13 {
    private final double lRadius;
    private final double sRadius;

    Oval(double a, double b) {
        this.lRadius = a;
        this.sRadius = b;
    }

    Oval() {
        this.lRadius = 0;
        this.sRadius = 0;
    }

    double area() {
        return PI * lRadius * sRadius;
    }

    double perimeter() {
       return  2 * PI * Math.sqrt((lRadius * lRadius + sRadius * sRadius) / 2);
    }

    public String toString() {
        return "Oval(a:" + lRadius + ",b:" + sRadius + ")";
    }

}


public class work13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lRadius = scanner.nextDouble();
        double sRadius = scanner.nextDouble();
        Oval oval = new Oval(lRadius, sRadius);
        System.out.println("The area of " + oval + " is " + oval.area());
        System.out.println("The perimeterof " + oval + " is " + oval.perimeter());
    }
}
