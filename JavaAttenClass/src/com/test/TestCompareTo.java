package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: LZPing
 * @date: 2023-03-04 17:08
 * @Description
 */
class StudentCompareTo /*implements Comparable<StudentCompareTo>*/ {
    int age;
    String name;
    String address;

    StudentCompareTo() {

    }

    StudentCompareTo(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentCompareTo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(StudentCompareTo stu) {
//       return this.name.compareTo(stu.name);
//    }
}

public class TestCompareTo {
    public static void main(String[] args) {
        ArrayList<StudentCompareTo> list = new ArrayList<>();
        list.add(new StudentCompareTo(13, "zs", "bj"));
        list.add(new StudentCompareTo(12, "ls", "hb"));
        list.sort((o1, o2) -> o2.name.compareTo(o1.name));
        for (StudentCompareTo s : list) {
            System.out.println(s);
        }
    }
}
