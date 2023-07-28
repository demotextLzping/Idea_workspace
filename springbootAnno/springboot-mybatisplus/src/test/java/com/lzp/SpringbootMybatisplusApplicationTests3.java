package com.lzp;

import com.lzp.pojo.Dept;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("断言测试类")
class SpringbootMybatisplusApplicationTests3 {
    @DisplayName("简单断言1")
    @Test
    public void testAssertion() {
        int a = 1;
        int b = 2;
        int c = a + b;
        Assertions.assertEquals(4, c, "add计算错误");
    }


    @DisplayName("简单断言2")
    @Test
    public void testAssertion2() {
        Dept dept = new Dept();
        Dept dept2 = new Dept();
        Assertions.assertSame(dept2, dept2, "两个对象不一样");

        String s1 = new String("xxx");
        String s2 = "xxx";
        Assertions.assertSame(s1, s2, "两个对象不一样");
    }

    @DisplayName("组合断言")
    @Test
    public void testAssertAll() {
        Assertions.assertAll(
                "AssertALL",
                () -> Assertions.assertTrue(1 > 0),
                () -> Assertions.assertTrue(2 > 3)
        );
    }

    @DisplayName("异常断言")
    @Test  //断言它会出现指定的异常，没有异常则表示测试失败
    public void testAssertThrow() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 1;
        }, "没有异常");
    }

    @DisplayName("超时断言")
    @Test  //断言它测试在指定的时间，超出时间会异常
    public void testAssertTimeOut() {
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(900));
    }

    @DisplayName("快速失败断言")
    @Test  //如果测试时出现了某些情况，直接生成测试失败的报告，后续也不再测试
    public void testFail() {
        int a=1;
        int b=0;
        if(b==0){
            Assertions.fail("测试失败");
        }
        System.out.println(a);
    }
}
