package com.lzp.study7;

import java.util.concurrent.*;

/**
 * @author: LZPing
 * @date: 2023-03-16 10:14
 * @Description
 */

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = () -> "hello Callable";

        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service1 = Executors.newFixedThreadPool(2);
        Future<String> future = service.submit(c); //异步
        System.out.println(future.get());  //阻塞等待有结果时间，不在阻塞
        service.shutdown();
    }
}