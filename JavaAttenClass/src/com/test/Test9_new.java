//package com.test;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @author: LZPing
// * @date: 2023-03-02 15:48
// * @Description
// */
//
//class Student implements Comparable<Student2> {
//
//    class Class{
//        String name;
//        int score;
//
//        public Class(String name, int score) {
//            this.name = name;
//            this.score = score;
//        }
//    }
//    private String name;
//    private int id;
//    private List<Class> clazz = new ArrayList<>();
//    public Student(String name, int id){
//        this.name = name;
//        this.id = id;
//    }
//
//    public void addClazz(String name, int score){
//        this.clazz.add(new Class(name, score));
//    }
//    public int getId() {
//        return id;
//    }
//    public double average(){
//        return clazz.stream().mapToInt(c -> c.score).average().orElse(0);
//    }
//
//    @Override
//    public String toString(){
//        return this.id+","+this.name;
//    }
//
//    @Override
//    public int compareTo(Student2 o) {
//        int b = (int) (o.average() - this.average());
//        if (b != 0) {
//            return  b;
//        } else {
//            return this.id- o.id ;
//        }
//
//    }
//}
//
//public class Test9_new {
//    public static int findSite(ArrayList<Student2> list, int id) {
//        int site = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if (id == list.get(i).getId()) {
//                return i;
//            }
//        }
//        return site;
//
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Student2> list = new ArrayList<>();
//        while (sc.hasNext()) {
//            String message = sc.nextLine();
//            if (!("exit".equals(message))) {
//                String[] messages = message.split(",");
//                Student2 stu = null;
//                int idx = findSite(list, Integer.parseInt(messages[1]));
//                if (idx == -1) {
//                    stu = new Student2(messages[0], Integer.parseInt(messages[1]));
//                    list.add(stu);
//                }else {
//                    stu = list.get(idx);
//                }
//                stu.addClazz(messages[2], Integer.parseInt(messages[3]));
//            } else {
//                break;
//            }
//        }
//        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("No"+(i+1)+":"+list.get(i));
//        }
//    }
//}
