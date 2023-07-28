package com.lzp.test7.test1;

/**
 * @author: LZPing
 * @date: 2023-01-03 15:36
 * @Description
 */

public class Student implements Comparable {
    private String name;
    private Integer chineseScore;
    private Integer mathScore;
    private Integer sumScore;
    public Student() {}
    public Student(String name, Integer chineseScore, Integer mathScore) {
        this.name = name;this.chineseScore = chineseScore;this.mathScore = mathScore;
        this.sumScore = chineseScore + mathScore;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getChineseScore() {
        return chineseScore;
    }
    public void setChineseScore(Integer chineseScore) {
        this.chineseScore = chineseScore;
    }
    public Integer getMathScore() {
        return mathScore;
    }
    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }
    public Integer getSumScore() {
        return sumScore;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        if (((Student) o).getSumScore() == this.getSumScore()) {

            return Integer.compare(((Student) o).getChineseScore(), this.getChineseScore());
        } else {
            return Integer.compare(((Student) o).getSumScore(), this.getSumScore());
        }

    }
}
