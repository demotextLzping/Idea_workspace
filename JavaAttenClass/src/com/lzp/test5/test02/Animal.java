package com.lzp.test5.test02;

/**
 * @author£º LZPing
 * @date£º 2022-11-28 14:38
 * @Description
 */

public abstract   class Animal {
    private String color;
    private Integer numOfLegs;
    public Animal() {}
    public Animal(String color, Integer numOfLegs) {this.color = color;this.numOfLegs = numOfLegs;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public Integer getNumOfLegs() {return numOfLegs;}
    public void setNumOfLegs(Integer numOfLegs) {this.numOfLegs = numOfLegs;}
    public abstract void eat();
}
