//package com.test;
//
//import java.util.*;
//
//class Student implements Comparable<com.demo.Student> {
//    private String name;
//    private int id;
//    private int classNum = 0;
//
//    public void setClassNum(int classNum) {
//        this.classNum = classNum;
//    }
//
//    public int getClassNum() {
//        return classNum;
//    }
//
//    private int score;
//
//    public int getId() {
//        return id;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    Student(String name, int id, int score) {
//        this.name = name;
//        this.id = id;
//        this.classNum = this.getClassNum() + 1;
//        this.score = score;
//    }
//
//    @Override
//    public String toString() {
//        return this.id + "," + this.name;
//    }
//
//    @Override
//    public int compareTo(com.demo.Student o) {
//        if (this.score - o.score != 0) {
//            return o.score - this.score;
//        } else {
//            return this.id - o.id;
//        }
//    }
//}
//
//public class Test9 {
//    public static int findSite(ArrayList<com.demo.Student> list, com.demo.Student stu) {  //获取同学号的stu的位置，进行计算
//        int index = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if (stu.getId() == list.get(i).getId()) {
//                return i;
//            }
//        }
//        return index;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<com.demo.Student> list = new ArrayList<>();
//        while (sc.hasNext()) {
//            String message = sc.nextLine();
//            if (("exit".equals(message))) {
//                break;
//            }
//            String[] messages = message.split(",");
//            com.demo.Student stu = new com.demo.Student(messages[0], Integer.parseInt(messages[1]), Integer.parseInt(messages[3]));
//            int index = findSite(list, stu);
//            if (index == -1) {
//                list.add(stu);
//            } else {
//                list.get(index).setScore((list.get(index).getScore() + stu.getScore()));
//                list.get(index).setClassNum(list.get(index).getClassNum() + 1);
//            }
//        }
//        for (com.demo.Student student : list) {
//            student.setScore(student.getScore() / student.getClassNum());
//        }
//        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("No" + (i + 1) + ":" + list.get(i));
//        }
//    }
//}
