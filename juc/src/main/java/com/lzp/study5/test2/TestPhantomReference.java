package com.lzp.study5.test2;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @author: LZPing
 * @date: 2023-02-12 15:51
 * @Description
 */

public class TestPhantomReference {
    private  static  final List<Object> LIST=new LinkedList<>();
    private  static  final ReferenceQueue<M> QUEUE=new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> mPhantomReference = new PhantomReference<>(new M(), QUEUE);
        new Thread(()->{

            while (true){
                LIST.add(new byte[1024*1024]);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(mPhantomReference.get());
            }
        }).start();
        new Thread(()->{
            while (true){
                Reference<?extends M> poll= QUEUE.poll();
                if(poll!=null){
                    System.out.println("虚拟对象被jvm回收了");
                }
            }
        }).start();
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
