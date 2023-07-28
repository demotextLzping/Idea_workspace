package com.lzp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("参数化测试类")
class SpringbootMybatisplusApplicationTests6 {


    //手动添加数据源
    @ParameterizedTest  //参数化测试使用的注解
    @ValueSource(ints = 1)  //一个参数
    public void testParam1(int a) {
        Assertions.assertTrue(a > 0 && a < 4,"超出范围");
    }

    @ParameterizedTest  //多个参数循环测试
    @ValueSource(ints = {1, 2, 3, 4})
    public void testParam2(int a) {
        Assertions.assertTrue(a > 0 && a < 4,"超出范围");
    }

    //通过方法添加参数  ，调用方法需要为静态方法
    @ParameterizedTest  //多个参数循环测试
    @MethodSource("stringProvider")
    public void testPara3(String str) {
        Assertions.assertNotNull(str,"为空");
    }
    public static Stream<String> stringProvider(){
        List<String> strs=new ArrayList<>();
        strs.add("aaa");
        strs.add("bbb");
        strs.add(null);
        strs.add("ccc");
        Stream<String> stream = strs.stream();
        return stream;
    }

}
