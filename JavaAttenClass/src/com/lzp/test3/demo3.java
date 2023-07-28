package com.lzp.test3;

import java.util.Scanner;

/**
 * @author£º LZPing
 * @date£º 2022-11-15 14:03
 * @Description
 */

public class demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wages = scanner.nextInt();
        double tax_wages = (int) (wages - (wages * 0.1) - 5000);
        System.out.println(tax_wages);
        double sum = 0;
        if (tax_wages < 5000) {
            System.out.println(tax_wages);
        } else {
            if (tax_wages < 3000) {
                sum = (int) (3000 * 0.03);
            }
            if (tax_wages < 12000) {
                sum = 90 + (tax_wages - 3000) * 0.1;
            }
            if (tax_wages < 25000 && tax_wages >= 12000) {
                sum = 990 + (tax_wages - 12000) * 0.2;
            }
            if (tax_wages < 35000 && tax_wages >= 25000) {
                sum = (int) (3000 * 0.03) + (tax_wages - 3000) * 0.1 + (tax_wages - 12000) * 0.2 + (tax_wages - 25000) * 0.25;
            }
            if (tax_wages < 55000 && tax_wages >= 35000) {
                sum = (int) (3000 * 0.03) + (tax_wages - 3000) * 0.1 + (tax_wages - 12000) * 0.2 + (tax_wages - 25000) * 0.25 + (tax_wages - 35000) * 0.3;
            }
            if (tax_wages < 80000 && tax_wages >= 55000) {
                sum = (int) (3000 * 0.03) + (tax_wages - 3000) * 0.1 + (tax_wages - 12000) * 0.2 + (tax_wages - 25000) * 0.25 + (tax_wages - 35000) * 0.3 + (tax_wages - 55000) * 0.35;
            }
            if (tax_wages >= 80000) {
                sum = (int) (3000 * 0.03) + (tax_wages - 3000) * 0.1 + (tax_wages - 12000) * 0.2 + (tax_wages - 25000) * 0.25 + (tax_wages - 35000) * 0.3 + (tax_wages - 55000) * 0.35 + (tax_wages - 80000) * 0.45;
            }
        }
        System.out.println(tax_wages + 5000 - sum);


    }
}
