package com.lzp.study8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author: LZPing
 * @date: 2023-03-18 09:35
 * @Description  ForkJoinPool的两个实现类
 * RecursiveAction没有返回值
 * RecursiveTask<T>有返回值
 * 案例 计算长度为100000的数组的全部元素的和
 */

public class TestForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("Norm   " + Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction {
        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) sum += nums[i];
                System.out.println("RecursiveAction form: " + start + " to: " + end + " = " + sum);
            } else {
                int middle = start + (end - start) / 2;
                AddTask task1 = new AddTask(start, middle);
                AddTask task2 = new AddTask(middle, end);
                task1.fork();
                task2.fork();
            }
        }
    }

    static class AddTaskRet extends RecursiveTask<Long> {
        private static final long serialVersionUID = 1L;
        int start, end;

        public AddTaskRet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) sum += nums[i];
                return sum;
            }
            int middle = start + (end - start) / 2;
            AddTaskRet task1 = new AddTaskRet(start, middle);
            AddTaskRet task2 = new AddTaskRet(middle, end);
            task1.fork();
            task2.fork();
            return task1.join() + task1.join();
        }
    }

    public static void main(String[] args) throws IOException {
//        RecursiveAction
//        ForkJoinPool fjp = new ForkJoinPool();
//        AddTask task = new AddTask(0, nums.length);
//        fjp.execute(task);
//        System.in.read();

//        RecursiveTask
        ForkJoinPool fjp2 = new ForkJoinPool();
        AddTaskRet taskRet = new AddTaskRet(0, nums.length);
        fjp2.execute(taskRet);
        Long result = taskRet.join();
        System.out.println(result);
    }

}
