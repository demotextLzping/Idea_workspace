package com.lzp;

import org.junit.jupiter.api.*;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

@DisplayName("junit测试类")
class SpringbootMybatisplusApplicationTests2 {

    @BeforeAll //改类中方法执行前执行，只会执行一次
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll //改类中方法执行前执行，只会执行一次
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
//每个方法执行后都会执行一次
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
        //每个方法执行前都会执行一次
    void afterEach() {
        System.out.println("afterEachEach");
    }

    @DisplayName("junit测试方法1")
    @RepeatedTest(3) //重复执行多少次
    //指定测试允许的时间超过会出现异常，前面的参数为时间大小，后面参数是时间的单位
    @Timeout(value = 1000, unit = TimeUnit.MICROSECONDS)
    @Test
    void test() throws InterruptedException {
        System.out.println("a");
//        Thread.sleep(1001);
    }

    @Disabled //让该方法不可用法用，大批量测试方法同时测试时是不可用
    @DisplayName("junit测试方法2")
    @Test
    void test2() {
        System.out.println("b");
    }

}
