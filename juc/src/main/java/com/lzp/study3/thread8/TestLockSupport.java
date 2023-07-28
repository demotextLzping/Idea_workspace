package com.lzp.study3.thread8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: LZPing
 * @date: 2023-01-16 09:04
 * @Description
 */

public class TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }

                if(i==8){
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("after 5 second");
        LockSupport.unpark(t);
        try {
            TimeUnit.SECONDS.sleep(8);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("after 8 second");
        LockSupport.unpark(t);
    }
}
