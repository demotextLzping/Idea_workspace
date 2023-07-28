package com.lzp.pojo;

import java.util.*;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private User user;
    private int[] scoreArr;
    private List<Integer> scoreList;
    private Set<Integer> scoreSet;
    private Map<String, Integer> scoreMap;
    private Properties pro;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", user=" + user +
                ", scoreArr=" + Arrays.toString(scoreArr) +
                ", scoreList=" + scoreList +
                ", scoreSet=" + scoreSet +
                ", scoreMap=" + scoreMap +
                ", pro=" + pro +
                '}';
    }

    public Student() {
        System.out.println("这是Student的空参构造器");
    }


    private void init() {
        System.out.println("这是初始化方法");
    }

    public void des() {
        System.out.println("这是销毁方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Student(String id, String name, String age, String sex) {
    }


    public Student(Integer id, String name, Integer age, String sex, User user, int[] scoreArr, List<Integer> scoreList, Set<Integer> scoreSet, Map<String, Integer> scoreMap, Properties pro) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.user = user;
        this.scoreArr = scoreArr;
        this.scoreList = scoreList;
        this.scoreSet = scoreSet;
        this.scoreMap = scoreMap;
        this.pro = pro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int[] getScoreArr() {
        return scoreArr;
    }

    public void setScoreArr(int[] scoreArr) {
        this.scoreArr = scoreArr;
    }

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public Set<Integer> getScoreSet() {
        return scoreSet;
    }

    public void setScoreSet(Set<Integer> scoreSet) {
        this.scoreSet = scoreSet;
    }

    public Map<String, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(Map<String, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }


}
