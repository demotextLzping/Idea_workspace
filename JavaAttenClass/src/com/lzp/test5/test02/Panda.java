package com.lzp.test5.test02;

/**
 * @author： LZPing
 * @date： 2022-11-28 14:43
 * @Description
 */

public class Panda extends Animal{
    @Override
    public void eat() {
        System.out.println(getColor()+getNumOfLegs()+"条腿的大熊猫在吃竹子");
    }


    public void climbTree(){
        System.out.println(getColor()+getNumOfLegs()+"条腿的大熊猫在爬树");
    }
}
