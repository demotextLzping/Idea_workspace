package com.lzp.test7.test3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.DAYS;

/**
 * @author: LZPing
 * @date: 2023-01-03 17:41
 * @Description
 */

public class Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[^0-9]+"); //scanner设置分隔标记
        System.out.println("输入开始的年月日，年月日之间用-，/或.分割");
        int startY = scanner.nextInt();
        int startM = scanner.nextInt();
        int startD = scanner.nextInt();
        LocalDate startDate = LocalDate.of(startY, startM, startD);
//        System.out.println(startDate);
        System.out.println("输入结束的年月日，年月日之间用-，/或.分割");
        int endY = scanner.nextInt();
        int endM = scanner.nextInt();
        int endD = scanner.nextInt();
        LocalDate endDate = LocalDate.of(endY, endM, endD);
//        System.out.println(endDate);
        long days = startDate.until(endDate, ChronoUnit.DAYS);
        if (startDate.isAfter(endDate)) {
            System.out.println(startDate + "在" + endDate + "之后");
            System.out.println(startDate + "和" + endDate + "相隔" + days);
        } else {
            System.out.println(startDate + "在" + endDate + "之前");
            System.out.println(startDate + "和" + endDate + "相隔" + days);

        }

    }
}
