package com.lzp.study3.thread;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: LZPing
 * @date: 2023-01-15 10:26
 * @Description
 */

public class ReentrantLock05 extends  Thread {
    private static ReentrantLock lock=new ReentrantLock(true);  //为true是公平锁，反之是不公平锁
    public void run(){
        for(int i=0;i<100;i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"  "+i+" 获取锁");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        ReentrantLock05 t = new ReentrantLock05();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }
}
