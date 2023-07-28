package com.lzp.study8;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author: LZPing
 * @date: 2023-02-19 13:13
 * @Description  参与总线程8   线程池最大线程数为4，核心线程为2，等待队列4
 *
 */

public class TestThreadPoolExecutor {
    static class Task implements Runnable {
        private int i;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public Task(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }
    public static void main(String[] args) {
        try (ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy())) {
            for (int i = 0; i < 8; i++) {
                tpe.execute(new Task(i));
            }
            //任务队列里的线程
            System.out.println(tpe.getQueue());
            //再次添加新的线程到任务队列
            tpe.execute(new Task(100));
            //任务队列里的线程
            System.out.println(tpe.getQueue());
            tpe.shutdown();
        }
    }

}
