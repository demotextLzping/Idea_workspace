package com.lzp.study6.work;

///**
// * @author: LZPing
// * @date: 2023-02-14 15:04
// * @Description
// */
//
//public class ExchangeWork {
//    static char[] ai = "1234567".toCharArray();
//    static char[] ac = "ABCDEFG".toCharArray();
//
//    public static void main(String[] args) {
//        Exchanger<String> exchanger = new Exchanger<>();
//        new Thread(() -> {
//                for (char c : ai) {
//
//                    try {
//                        System.out.print(c+" ");
//                        exchanger.exchange("T2");
//
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//        }).start();
//
//        new Thread(() -> {
//
//                for (char c : ac) {
//                    try {
//                        System.out.print(c+" ");
//                        exchanger.exchange("T1");
//
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//        }).start();
//    }
//}
