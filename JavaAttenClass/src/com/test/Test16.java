//package com.test;
//
///**
// * @author: LZPing
// * @date: 2023-03-05 22:32
// * @Description
// */
//
//import java.text.DecimalFormat;
//import java.util.*;
//class Person{
//    private String name;
//    private int age;
//    private boolean gender;
//    private int id;
//    public String getName(){
//        return name ;
//    }
//    public void setName(){
//        this.name=name;
//    }
//
//    public int getAge(){
//        return age ;
//    }
//    public void setAge(){
//        this.age=age;
//    }
//
//    public boolean getGender(){
//        return gender ;
//    }
//    public void setGender(){
//        this.gender=gender;
//    }
//    public int getId(){
//        return id ;
//    }
//    public void setId(){
//        this.id=id;
//    }
//    Person(){
//        System.out.println("This is constructor");
//        System.out.println(name+","+age+","+gender+","+id);
//    }
//
//    Person(String name,int age,boolean gender ){
//        this.name=name;
//        this.age=age;
//        this.gender=gender;
//    }
//    @Override
//    public String toString(){
//        return "Person "+"[name="+name+", age="+age+", gender="+gender+", id="+id+"]";
//    }
//}
//class Main{
//    public static void main(String [] args){
//        Scanner sc= new Scanner(System.in);
//        int num =sc.nextInt();
//
//
//        DecimalFormat df = new DecimalFormat("#.#");
//        com.demo.Person[] persons=new com.demo.Person[num];
//        for(int i=0;i<num;i++){
//            String[] stus=sc.nextLine().split(" ");
//            com.demo.Person p=new com.demo.Person(stus[0],Integer.parseInt(stus[1]),Boolean.parseBoolean(stus[2]));
//            persons[num-i-1]=p;
//        }
//        for(com.demo.Person p:persons){
//            System.out.println(p);
//        }
//        com.demo.Person PNCon=new com.demo.Person();
//        System.out.println(PNCon);
//
//    }
//}