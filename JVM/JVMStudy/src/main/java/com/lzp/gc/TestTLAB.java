package com.lzp.gc;

/**
 * @author: LZPing
 * @date: 2023-04-02 09:41
 * @Description 栈上分配和线程本地分配
 */

public class TestTLAB {
//    User u;
    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.name = name;
            this.id = id;
        }
    }

    void alloc(int i) {
        new User(i, "name" + i);
    }

    public static void main(String[] args) {
        TestTLAB testTLAB = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            testTLAB.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
