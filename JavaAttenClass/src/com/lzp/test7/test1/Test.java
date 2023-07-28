package com.lzp.test7.test1;

import java.util.Arrays;


/**
 * @author: LZPing
 * @date: 2023-01-03 15:38
 * @Description
 */

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("张三", 60, 40);
        students[1] = new Student("李四", 50, 50);
        students[2] = new Student("王五", 60, 30);
        students[3] = new Student("赵六", 30, 70);
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
