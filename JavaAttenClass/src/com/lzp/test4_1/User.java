package com.lzp.test4_1;

/**
 * @author： LZPing
 * @date： 2022-11-18 14:00
 * @Description
 */
public class User {
    public static void main(String[] args) {
        CD dataCD = new CD();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        dataCD.setSize(arr.length);
        dataCD.setContent(arr);
        int[] content = dataCD.getContent();
        System.out.println("dataCD上的内容为：");
        for (int i = 0; i < content.length; i++)//输出CD内容
            System.out.printf(content[i] + " ");

        Computer computerIMB = new Computer();
        computerIMB.putCD(dataCD);

        System.out.println("\n将dataCD的内容复制到计算机：computerIMB");
        computerIMB.copyToComputer();
        System.out.println("computerIMB上的内容为：");
        computerIMB.showData();
        int num = 12;
        System.out.println("\ncomputerIMB中的每个数据加 " + num);
        computerIMB.addNum(num);
        System.out.println("computerIMB将增值后的数据复制到CD：dataCD");
        computerIMB.copyToCD();
        System.out.println("dataCD中的内容为：");
        content = dataCD.getContent();
        for (int i = 0; i < content.length; i++)
            System.out.printf(content[i] + " ");
    }
}