package com.lzp.test4_1;

/**
 * @author£º LZPing
 * @date£º 2022-11-18 14:00
 * @Description
 */

public class Computer {
    private int[] data;
    private CD includeCD;

    public void putCD(CD includeCD) {
        this.includeCD = includeCD;
    }

    public void copyToComputer() {
        data = includeCD.getContent();


    }

    public void copyToCD() {
        includeCD.setContent(data);

    }

    public void showData() {
        for (int datum : data) {
            System.out.print(datum + " ");
        }

    }

    public void addNum(int num) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] + num;
        }

    }

}
