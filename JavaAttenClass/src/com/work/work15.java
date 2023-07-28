package com.work;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2022-12-18 17:35
 * @Description
 */
class Person {
    private String name=null;
    private int age=0;
    private boolean gender=false;
    private int id=0;
    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        System.out.println("This is constructor");
        System.out.println(this.name + "," + this.age + "," + this.gender + "," + this.id);
    }

    @Override
    public String toString() {
        return "Person" + " [name=" + name + ", age=" + age + ", gender=" + gender + ", id=" + id + ']';
    }

}

public class work15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        Person[] persons = new Person[num];
        for (int i = 0; i < num; i++) {
            Person person1 = new Person(scanner.next(),scanner.nextInt(),scanner.nextBoolean());
            persons[i]=person1;
        }
        for (int i = num-1; i >=0; i--) {
            System.out.println(persons[i].toString());;
        }
        Person personNull = new Person();
        System.out.println(personNull.toString());
    }
}
