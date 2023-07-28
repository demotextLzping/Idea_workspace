package com.demo;

/**
 * @author: LZPing
 * @date: 2023-03-06 20:48
 * @Description
 */

import java.util.*;
import java.text.DecimalFormat;

class Person {
    String name;
    int age;
    boolean gender;
    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person p = (Person) obj;
        return Objects.equals(this.name, p.name) && this.age == p.age && this.gender == p.gender;
    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(this.name, this.age, this.gender);
//    }
}

class Student extends Person {
    String stuNo;
    String clazz;

    public Student(String name, int age, boolean gender, String stuNo, String clazz) {
        super(name, age, gender);
        this.stuNo = stuNo;
        this.clazz = clazz;
    }

    public String toString() {
        return "Student:" + super.toString() + "-" + this.stuNo + "-" + this.clazz;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Student p = (Student) obj;
        if (!super.equals(p)) return false;
        return Objects.equals(this.stuNo, p.stuNo) && Objects.equals(this.clazz, p.clazz);
    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(super.hashCode(), stuNo, clazz);
//    }
}

class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String toString() {        //直接返回name
        return this.name;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Company c = (Company) obj;
        return Objects.equals(c.name, this.name);
    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(this.name);
//    }
}

class Employee extends Person {
    private Company company;
    private double salary;

    public Employee(String name, int age, boolean gender, double salary, Company company) {
        super(name, age, gender);
        this.salary = salary;
        this.company = company;
    }

    public String toString() {
        return "Employee:" + super.toString() + "-" + this.company + "-" + this.salary;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Employee p = (Employee) obj;
        if (!super.equals(p)) return false;
        DecimalFormat df = new DecimalFormat("#.#");
        return Objects.equals(df.format(this.salary), df.format(p.salary)) && Objects.equals(this.company, p.company);
    }
//    @Override
//    public int hashCode(){
//        DecimalFormat df = new DecimalFormat("#.#");
//        return Objects.hash(super.hashCode(), df.format(salary), company);
//    }
}

public class Test_new11 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        System.out.println();
        while (in.hasNext()) {
            String[] line = in.nextLine().split(" ");
            if (line.length < 6) {
                break;
            }
            String type = line[0];
            String name = line[1];
            int age = Integer.parseInt(line[2]);
            boolean gender = "true".equals(line[3]);
            if ("s".equals(type)) {
                String stuNo = line[4];
                String clazz = line[5];
                persons.add(new Student(name, age, gender, stuNo, clazz));
            } else if ("e".equals(type)) {
                double salary = Double.parseDouble(line[4]);
                Company company = "null".equals(line[5]) ? null : new Company(line[5]);
                persons.add(new Employee(name, age, gender, salary, company));
            } else {
                break;
            }
        }
        persons.sort((p1, p2) -> {
            int rst = p1.name.compareTo(p2.name);
            return rst != 0 ? rst : p1.age - p2.age;
        });
        persons.forEach(System.out::println);
        if ("exit".equals(in.next())) {
            return;
        }
        List<Student> stuList = new ArrayList<>();
        List<Employee> empList = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Student && !stuList.contains(person)) {
                stuList.add((Student) person);
            } else if (person instanceof Employee && !empList.contains(person)) {
                empList.add((Employee) person);
            }
        }
        System.out.println("stuList");
        stuList.forEach(System.out::println);
        System.out.println("empList");
        empList.forEach(System.out::println);
    }
}