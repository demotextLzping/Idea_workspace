package com.lzp.test6.test1;

public class Test {
    public static void main(String[] args) {
        TV tv = new TV();
        tv.tongDian();
        tv.open();
        tv.lookTv();
        tv.close();
        System.out.println("----------------");

        AirConditioning airConditioning = new AirConditioning();
        airConditioning.tongDian();
        airConditioning.open();
        airConditioning.refrigeration();
        airConditioning.close();
    }
}
