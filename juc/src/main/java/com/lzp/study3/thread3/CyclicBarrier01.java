package com.lzp.study3.thread3;

import javax.sound.midi.Soundbank;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: LZPing
 * @date: 2023-01-15 11:30
 * @Description
 */

public class CyclicBarrier01 {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(20, () -> System.out.println("满人,发车"));
        for(int i =0;i<100;i++){
            new Thread(()->{
                try {
                    cb.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
