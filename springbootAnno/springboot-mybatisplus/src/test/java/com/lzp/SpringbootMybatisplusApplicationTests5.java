package com.lzp;

import org.junit.jupiter.api.*;
import org.springframework.beans.propertyeditors.ClassArrayEditor;

@DisplayName("嵌套测试类")
class SpringbootMybatisplusApplicationTests5 {

    @BeforeEach
    public void outerBeforeEach() {
        System.out.println("outerBeforeEach");

    }

    @AfterEach
    public void outerAfterEach() {
        System.out.println("outerAfterEach");

    }
    @Test
    public void test() {
        System.out.println("outTest");
    }

    @Nested
    @DisplayName("嵌套测试")
    class InnerClass {
        @BeforeEach
        public void outerBeforeEach() {
            System.out.println("outerBeforeEach");
        }
        @AfterEach
        public void outerAfterEach() {
            System.out.println("outerAfterEach");
        }

        @Test
        public void test() {
            System.out.println("outTest");
        }
    }
}
