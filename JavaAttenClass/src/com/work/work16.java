package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 16:21
 * @Description
 */
class goods {

    String id;
    String name ;
    double price;

    public goods(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id  + "," + name + "," + price ;
    }
}

public class work16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id=scanner.next();
        String name=scanner.next();
        double price=scanner.nextDouble();
        goods goods = new goods(id, name, price);
        System.out.println(goods);

    }
}
