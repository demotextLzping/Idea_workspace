package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 17:10
 * @Description
 */
interface Shape19 {
    float getArea();//求面积

    float getPerimeter();//求周长
}

class Cri implements Shape19 {
    float radius;

    Cri(float radius) {
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return this.radius * this.radius * (float) Math.PI;
    }

    @Override
    public float getPerimeter() {
        return this.radius * 2 * (float) Math.PI;
    }

}

class Rect implements Shape19 {
    float height;
    float width;

    public Rect(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public float getArea() {
        return this.height * this.width;
    }

    @Override
    public float getPerimeter() {
        return (this.height + this.width) * 2;
    }
}

public class work19 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int flag = scanner.nextInt();
            if (flag == 2) {
                float width = scanner.nextFloat();
                float height = scanner.nextFloat();
                Rect rect = new Rect(height, width);
                System.out.print(String.format("%.2f", rect.getArea())+" ");
                System.out.println(String.format("%.2f", rect.getPerimeter()));
            }
            if (flag == 1) {
                float radius = scanner.nextFloat();
                Cri cri = new Cri(radius);
                System.out.print(String.format("%.2f", cri.getArea())+" ");
                System.out.println(String.format("%.2f", cri.getPerimeter()));
            }
        }
    }
}
