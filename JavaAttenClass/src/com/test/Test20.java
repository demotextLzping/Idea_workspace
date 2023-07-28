//package com.test;
//
//import java.util.Scanner;
//
///**
// * @author: LZPing
// * @date: 2023-02-28 18:32
// * @Description
// */
//
//interface Shape {
//    float getArea();//求面积
//
//    float getPerimeter();//求周长
//
//}
//
//class Cir implements Shape {
//    float radius;
//
//    public Cir(float radius) {
//        this.radius = radius;
//    }
//
//    @Override
//    public float getArea() {
//        return (float) (Math.PI * (this.radius) * (this.radius));
//    }
//
//    @Override
//    public float getPerimeter() {
//        return (float) (Math.PI * 2 * (this.radius));
//    }
//}
//
//class Rang implements Shape {
//    float height;
//    float width;
//
//    public Rang(float height, float width) {
//        this.height = height;
//        this.width = width;
//    }
//
//    @Override
//    public float getArea() {
//        return this.width * this.height * (1.00F);
//    }
//
//    @Override
//    public float getPerimeter() {
//        return (this.width + this.height) * (2.00F);
//    }
//}
//
//class Test20 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        for (int i = 0; i < num; i++) {
//            int choice = sc.nextInt();
//            if (choice == 1) {
//                float radius = sc.nextFloat();
//                Cir cir = new Cir(radius);
//                System.out.print(String.format("%.2f", cir.getArea()) + " ");
//                System.out.println(String.format("%.2f", cir.getPerimeter()) + " ");
//            } else if (choice == 2) {
//                float width = sc.nextFloat();
//                float height = sc.nextFloat();
//                Rang rang = new Rang(height, width);
//                System.out.print(String.format("%.2f", rang.getArea()) + " ");
//                System.out.println(String.format("%.2f", rang.getPerimeter()) + " ");
//            }
//        }
//    }
//}