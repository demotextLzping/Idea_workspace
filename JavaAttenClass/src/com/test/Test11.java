package com.test;

/**
 * @author: LZPing
 * @date: 2023-03-06 17:13
 * @Description
 */

import java.util.*;
abstract class Shape{
    double PI=3.14;
    abstract double getPerimeter();
    abstract double getArea();
}
class Rectangle extends Shape{
    int width;
    int length;
    Rectangle(int width,int length){
        this.width=width;
        this.length=length;
    }

    public double getArea(){
        return width*length;
    }

    public double getPerimeter(){
        return 2*(width+length);
    }
    @Override
    public String toString(){
        return "Rectangle [width="+width+", length="+length+"]";
    }

}
class Circle extends Shape{
    int radius;
    Circle(int radius){
        this.radius=radius;
    }

    public double getArea(){
        return PI*radius*radius;
    }

    public double getPerimeter(){
        return 2*PI*radius;
    }
    @Override
    public String toString(){
        return "Circle [radius="+radius+"]";
    }
}
public class Test11{
    public static double sumAllArea(Shape[] shapes){
        double sum=0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        return sum;
    }

    public static double sumAllPerimeter(Shape[] shapes){
        double sum=0;
        for (Shape shape : shapes) {
            sum += shape.getPerimeter();
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=sc.nextInt();
        Shape [] shapes=new Shape[count];
        for(int i=0;i<count;i++){
            String clazz=sc.next();
            if("rect".equals(clazz)){
                int width=sc.nextInt();
                int length=sc.nextInt();
                shapes[i]=new Rectangle(width,length);
            }else{
                int radius=sc.nextInt();
                shapes[i]=new Circle(radius);
            }
        }
        System.out.println(sumAllArea(shapes));
        System.out.println(sumAllPerimeter(shapes));
    }
}