package com.lzp.study8;

import java.util.concurrent.*;

/**
 * @author: LZPing
 * @date: 2023-03-18 08:32
 * @Description
 */

public class TestMyRejectedHandler {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 0,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new MyHandler()
        );
    }

    static class MyHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //伪代码例子，实现自定义拒绝策略
            //log("r rejected")
            //save r kafka mysql redis
            //try 3 times
            if (executor.getQueue().size() < 1000) {
                //try put again();
            }
        }
    }
}
