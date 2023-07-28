package com.work;

import javax.swing.text.html.CSS;
import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 14:46
 * @Description
 */
import java.util.*;

abstract class Shape{
    static final double PI = 3.14;
    public abstract double getPerimeter();
    public abstract double getArea();
}

class Rectangle extends Shape{
    private int width;
    private int length;
    public Rectangle(int width,int length) {
        this.width = width;
        this.length = length;
    }
    public double getPerimeter() {
        return 2*(this.width+this.length);
    }
    public double getArea() {
        return this.width*this.length;
    }
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", length=" + length + "]";
    }
}

class Circle extends Shape{
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    public double getPerimeter() {
        return PI*this.radius*2;
    }
    public double getArea() {
        return PI*this.radius*this.radius;
    }
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}

public class work9{
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Shape [] shapes = new Shape[n];
        for(int i=0;i<n;i++){
            String shape = in.nextLine();
            if(shape.equals("rect")) {
                int width = in.nextInt();
                int length = in.nextInt();
                in.nextLine();
                shapes[i] = new Rectangle(width, length);
            }
            else {
                int radius = in.nextInt();
                in.nextLine();
                shapes[i] = new Circle(radius);
            }
        }
        System.out.println(sumAllPerimeter(shapes));
        System.out.println(sumAllArea(shapes));
        System.out.println(Arrays.toString(shapes));
        for(Shape s:shapes) {
            System.out.println(s.getClass()+","+s.getClass().getSuperclass());
        }
    }
    public static double sumAllArea(Shape[] shapes) {
        double sum = 0;

        for(Shape s:shapes) {
            sum+=s.getArea();
        }
        return sum;
    }
    public static double sumAllPerimeter(Shape[] shapes) {
        double sum = 0;

        for(Shape s:shapes) {
            sum+=s.getPerimeter();
        }
        return sum;
    }
}