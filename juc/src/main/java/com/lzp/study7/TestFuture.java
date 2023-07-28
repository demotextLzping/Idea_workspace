package com.lzp.study7;

import java.io.Flushable;
import java.util.concurrent.*;

/**
 * @author: LZPing
 * @date: 2023-02-19 13:35
 * @Description
 */

public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        使用方法
//        FutureTask
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 500;
        });
        new Thread(task).start();
        System.out.println(task.get()); //阻塞

//Future
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f=service.submit(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        System.out.println(f.get()); //阻塞
        System.out.println(f.isDone());
    }
}
