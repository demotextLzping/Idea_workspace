package com.lzp;

import org.openjdk.jmh.annotations.*;

/**
 * @author: LZPing
 * @date: 2023-03-18 14:34
 * @Description
 */

public class PSTest {
    @Benchmark                              //
    @Warmup(iterations = 1, time = 3)       //预热次数 一次，预热时间三秒
    @Fork(5)                                //使用多少个线程执行
    @BenchmarkMode(Mode.Throughput)         //基准测试的模式
    @Measurement(iterations = 1, time = 3)  //总共执行多少次测试
    public void TestForeach() {
        PS.foreach();
    }

    @Benchmark
    public void TestParallel() {
        PS.parallel();
    }
}
