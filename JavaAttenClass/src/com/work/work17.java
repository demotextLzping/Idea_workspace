package com.work;

/**
 * @author: LZPing
 * @date: 2022-12-18 16:26
 * @Description
 */
class Person17 {
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person17(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "this person is "  + name +",her age is "+age;
    }
}

public class work17 {
    public static void main(String[] args) {
        Person17 lili = new Person17("lili", 19);
        System.out.println(lili);
        Person17 lucy = new Person17("lucy", 20);
        System.out.println(lucy);
    }
}
