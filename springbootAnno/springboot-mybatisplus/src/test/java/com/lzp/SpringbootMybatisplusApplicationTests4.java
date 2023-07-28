package com.lzp;

import com.lzp.pojo.Dept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@DisplayName("前置条件测试类")
class SpringbootMybatisplusApplicationTests4 {


    @DisplayName("前置条件断言1")
    @Test
    public void testAssumptions() {
        Assumptions.assumeTrue(false,"前置条件不成立");
        System.out.println("测试了");
    }
}
