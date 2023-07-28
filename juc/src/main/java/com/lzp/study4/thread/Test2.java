package com.lzp.study4.thread;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author: LZPing
 * @date: 2023-01-16 10:12
 * @Description
 */

public class Test2<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10; // 容器最大容量
    private int count = 0;

    public synchronized void put(T t) {
        while (list.size() == MAX) { // 注意此处用while而不是if
            try {
                this.wait(); // wait会主动释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        this.notifyAll(); // 注意此处为notifyAll而不是notify,因为notify是随机唤醒一个线程，很可能又是一个生产者，接着wait继续执行，检查while条件，如果成立，wait,程序不动了。
    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        Test2<String> c = new Test2<>();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j <5 ; j++) {
                    System.out.println(c.get());
                }
            },"c_"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //启动生产者线程
        for (int i = 0; i <2 ; i++) {
            new Thread(()->{
                for (int j = 0; j <25 ; j++) {
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            },"p_"+i).start();
        }
    }
}

