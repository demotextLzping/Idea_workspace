package com.lzp.bytecode;

/**
 * @author: LZPing
 * @date: 2023-03-19 15:03
 * @Description
 */

public class TestByteCode {
    private String name;
    private Integer age;
    private boolean gender;

    public TestByteCode() {
    }

    public TestByteCode(String name, Integer age, boolean gender) {
        this.name = name;
        this.age = age;
        this.age = age;
        this.age = age;
        this.age = age;
        this.age = age;
        this.age = age;
        this.age = age;
        this.gender = gender;
    }
    public void m(Integer age1, Integer age2, Integer age3) {
        System.out.println(age1 + age2 + age3);
    }
}
