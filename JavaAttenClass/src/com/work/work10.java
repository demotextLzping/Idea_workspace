//package com.work;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @author: LZPing
// * @date: 2022-12-18 15:18
// * @Description
// */
//
//abstract class Person {
//    String name;
//    int age;
//    boolean gender;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public boolean isGender() {
//        return gender;
//    }
//
//    public void setGender(boolean gender) {
//        this.gender = gender;
//    }
//
//    public Person(String name, int age, boolean gender) {
//    }
//
//    //返回"name-age-gender"格式的字符串
//    public String toString() {
//        return this.name + "-" + this.age + "-" + this.gender;
//    }
//
//    //比较name、age、gender,都相同返回true,否则返回false
//    public boolean equals(Object obj) {
//
//        return true;
//    }
//
//}
//
//class Student extends person {
//    String stuNo;
//    String clazz;
//
//    //建议使用super复用Person类的相关有参构造函数
//    public Student(String name, int age, boolean gender, String stuNo, String clazz) {
//        super(name, age, gender);
//    }
//
//    //返回 “Student:person的toString-stuNo-clazz”格式的字符串
//    public String toString() {
//        return "Student:"+super.toString()+"-"+this.stuNo+"-"+this.clazz;
//    }
//
//    //首先调用父类的equals方法,如果返回true，则继续比较stuNo与clazz。
//    public boolean equals(Object obj) {
//        return true;
//    }
//
//}
//
//class Company {
//    String name;
//
//    public Company(String name) {
//    }
//
//    //直接返回name
//    public String toString() {
//        return this.name;
//    }
//
//    //name相同返回true
//    public boolean equals(Object obj) {
//        if (this.name.equals(obj)) {
//            return true;
//        }
//        return false;
//    }
//}
//
//class Employee extends person {
//    Company company;
//    double salary;
//
//    //建议使用super复用Person类的相关有参构造函数
//    public Employee(String name, int age, boolean gender, double salary, Company company) {
//        super(name, age, gender);
//    }
//
//    //返回"Employee:person的toString-company-salary"格式的字符串
//    public String toString() {
//        return "Employee:"+super.toString()+"-"+this.company+"-"+this.salary;
//    }
//
//    //首先调用父类的equals方法,如果返回true。再比较company与salary。
//    //比较salary属性时，使用DecimalFormat df = new DecimalFormat("#.#");保留1位小数
//    public boolean equals(Object obj) {
//        return true;
//    }
//
//}
//
//public class work10 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String flag = sc.next();
//        List<person> personList=new ArrayList<person>();
//        while ("s".equals(flag) || "e".equals(flag)) {
//            if ("s".equals(flag)) {
//                String name = sc.next();
//                int age = sc.nextInt();
//                boolean gender = sc.nextBoolean();
//                String stuNo = sc.next();
//                String clazz = sc.next();
//                Student student = new Student(name, age, gender, stuNo, clazz);
//                personList.add(student);
//            }
//            if ("e".equals(flag)) {
//                String name = sc.next();
//                int age = sc.nextInt();
//                boolean gender = sc.nextBoolean();
//                double salary = sc.nextDouble();
//                Company company = new Company(sc.next());
//                Employee employee=new Employee(name, age, gender, salary, company);
//                personList.add(employee);
//            }
//
//        }
//
//
//    }
//}
