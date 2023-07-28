package com.lzp.study8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: LZPing
 * @date: 2023-02-19 16:01
 * @Description 求范围内的素数
 */

public class TestFixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start,end;
        start=System.currentTimeMillis();
        getPrime(1,200000);
        end=System.currentTimeMillis();
        System.out.println("普通方法："+(end-start));

        //线程池大小
        final int cpuCoreNum=4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        //将不同的任务交给不同的线程，submit是异步的
        MyTask myTask = new MyTask(1, 50000);
        MyTask myTask2 = new MyTask(50001, 100000);
        MyTask myTask3 = new MyTask(100000, 100001);
        MyTask myTask4 = new MyTask(100001, 200000);

        Future<List<Integer>> f1 = service.submit(myTask);
        Future<List<Integer>> f2 = service.submit(myTask2);
        Future<List<Integer>> f3 = service.submit(myTask3);
        Future<List<Integer>> f4 = service.submit(myTask4);

        start=System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end=System.currentTimeMillis();
        System.out.println("多线程方法："+(end-start));
    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos, endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(startPos, endPos);
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isPrime(i)) results.add(i);
        }
        return results;
    }
}
